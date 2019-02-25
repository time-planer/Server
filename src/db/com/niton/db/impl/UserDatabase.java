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

public class UserDatabase {
	private DSLContext sql;
	private String email;

	public UserDatabase(DSLContext sql) {
		this.sql = sql;
	}

	public String apikey() {
		return sql.select(USERS.APIKEY).from(USERS).where(USERS.EMAIL.eq(email)).fetch().get(0).component1();

	}

	/**
	 * @param enc
	 * @param pwd
	 * @return null on wrong key
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

	public void delete() {
		sql.deleteFrom(USERS).where(USERS.EMAIL.eq(email));
	}

	/**
	 * @param pwd
	 * @return null on error
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

	public boolean exists() {
		return sql.select().from(USERS).where(USERS.EMAIL.eq(email)).fetch().size() > 0;
	}

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

	public boolean login(String password) {
		try {
			String enc = sql.select(USERS.PASSWORD).from(USERS).where(USERS.EMAIL.eq(email)).fetch().get(0).component1();
			return password.equals(decryptPwd(enc, password));
		} catch (Exception e) {
			return false;
		}
	}

	public String privateUID() {
		return sql.select(USERS.PRIVATE_GROUP).from(USERS).where(USERS.EMAIL.eq(email)).limit(1).fetch().get(0).get(USERS.PRIVATE_GROUP);
	}

	public void register(String name, String password) {
		sql.insertInto(USERS, USERS.EMAIL, USERS.NAME, USERS.PASSWORD).values(email, name, encryptPwd(password))
		.execute();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSql(DSLContext sql2) {
		sql = sql2;
		
	}
}
