package com.niton.db.impl;

import static com.niton.db.Tables.USERS;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.jooq.DSLContext;

import com.niton.media.crypt.SimpleAES;
/**
 * Contains the methodes which are used for the user data
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 19:05:25
 */
public class UserDatabase {
	private DSLContext sql;
	private String email;
	/**
	 * Default Constructur
	 * @param sql current sql connection
	 */
	public UserDatabase(DSLContext sql) {
		this.sql = sql;
	}
	/**
	 * @return the apikey
	 */
	public String apikey() {
		return sql.select(USERS.APIKEY).from(USERS).where(USERS.EMAIL.eq(email)).fetch().get(0).component1();

	}

	/**
	 * decrypts a password
	 */
	private String decryptPwd(String enc, String pwd) {
		try {
			return new String(SimpleAES.decrypt(SimpleAES.getKey(getKeyFrom(pwd)), Base64.getDecoder().decode(enc)));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * deletes a user
	 */
	public void delete() {
		sql.deleteFrom(USERS).where(USERS.EMAIL.eq(email));
	}

	/**
	 * encrypts a password
	 */
	private String encryptPwd(String pwd) {
		try {
			return Base64.getEncoder()
					.encodeToString(SimpleAES.encrypt(SimpleAES.getKey(getKeyFrom(pwd)), pwd.getBytes()));
		} catch (InvalidKeyException | InvalidAlgorithmParameterException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @return a value which describes if a user exists
	 */
	public boolean exists() {
		return sql.select().from(USERS).where(USERS.EMAIL.eq(email)).fetch().size() > 0;
	}
	/**
	 * returns a byte array of acceptable bit key length
	 */
	private byte[] getKeyFrom(String pwd) {
		int n = 7;
		byte[] base = pwd.getBytes();
		while ((base.length) > Math.pow(2, n) / 8)
			n++;
		byte[] key = new byte[(int) Math.pow(2, n) / 8];
		for (int i = 0; i < base.length; i++) {
			key[i] = base[0];
		}
		return key;
	}
	/**
	 * Is managing the login process
	 * @param password the inserted password
	 * @return a boolean which describes if the login is legit
	 */
	public boolean login(String password) {
		try {
			String enc = sql.select(USERS.PASSWORD).from(USERS).where(USERS.EMAIL.eq(email)).fetch().get(0).component1();
			return password.equals(decryptPwd(enc, password));
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * @return the private uid if a user
	 */
	public String privateUID() {
		return sql.select(USERS.PRIVATE_GROUP).from(USERS).where(USERS.EMAIL.eq(email)).limit(1).fetch().get(0).get(USERS.PRIVATE_GROUP);
	}
	/**
	 * Is managing the registration process
	 * @param name the name of the user inserted
	 * @param password the password of the user 
	 */
	public void register(String name, String password) {
		sql.insertInto(USERS, USERS.EMAIL, USERS.NAME, USERS.PASSWORD).values(email, name, encryptPwd(password))
		.execute();
	}
	/**
	 * Sets the email address
	 * @param email the email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Sets the sql connection
	 * @param sql2 the sql connection
	 */
	public void setSql(DSLContext sql2) {
		sql = sql2;	
	}
}
