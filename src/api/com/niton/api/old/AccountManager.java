package com.niton.api.old;

import java.util.Hashtable;

import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

public class AccountManager {

	public static String isAccountValid(String email, String password) {
		email = email.toLowerCase();
		Hashtable<String, String> initialProperties = new Hashtable<>();
		initialProperties.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
		initialProperties.put("java.naming.provider.url", "ldap://10.2.24.151");
		initialProperties.put("java.naming.security.principal", email);
		initialProperties.put("java.naming.security.credentials", password);
		try {
			InitialDirContext dir = new InitialDirContext(initialProperties);
			String path = "ou=HIT,ou=schueler,ou=people,ou=identity,dc=tgm,dc=ac,dc=at";
			NamingEnumeration<NameClassPair> enu = dir.list(path);
			while (enu.hasMoreElements()) {
				NameClassPair object = enu.nextElement();
				String fullPath = object.getNameInNamespace();
				String fillCN = fullPath.split(",")[0];
				fillCN = fillCN.substring(3);
				System.out.println("Fill CN : "+fillCN);
				Attributes answer = dir.getAttributes(fullPath);
				NamingEnumeration<? extends Attribute> atrs = answer.getAll();
				atrs = answer.getAll();
				while (atrs.hasMoreElements()) {
					Attribute attribute = atrs.nextElement();
					if(attribute.getID().equals("name")) {
						return attribute.get().toString();
					}
				}
				
			}
		} catch (NamingException e) {
			return null;
		}
		return null;
	}
}
