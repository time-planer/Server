/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables.records;


import com.niton.db.tables.Users;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * ### Requirements * Name * Email * Password
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record5<String, String, String, String, String> {

    private static final long serialVersionUID = -1304063222;

    /**
     * Setter for <code>eds.users.name</code>. The name of an user.  unique
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>eds.users.name</code>. The name of an user.  unique
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>eds.users.email</code>.
     */
    public void setEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>eds.users.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>eds.users.apikey</code>.
     */
    public void setApikey(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>eds.users.apikey</code>.
     */
    public String getApikey() {
        return (String) get(2);
    }

    /**
     * Setter for <code>eds.users.password</code>. # Password   * Min length: 8   * Max Length : 40   * At least one small capitalized char   * One upper case char   * pattern : ^(?&amp;#x3D;.*\\\\d)(?&amp;#x3D;.*[a-z])(?&amp;#x3D;.*[A-Z]).{8,40}$
     */
    public void setPassword(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>eds.users.password</code>. # Password   * Min length: 8   * Max Length : 40   * At least one small capitalized char   * One upper case char   * pattern : ^(?&amp;#x3D;.*\\\\d)(?&amp;#x3D;.*[a-z])(?&amp;#x3D;.*[A-Z]).{8,40}$
     */
    public String getPassword() {
        return (String) get(3);
    }

    /**
     * Setter for <code>eds.users.private_group</code>.
     */
    public void setPrivateGroup(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>eds.users.private_group</code>.
     */
    public String getPrivateGroup() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Users.USERS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Users.USERS.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Users.USERS.APIKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Users.USERS.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Users.USERS.PRIVATE_GROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getApikey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getPrivateGroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getApikey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPrivateGroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value1(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value2(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value3(String value) {
        setApikey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value4(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value5(String value) {
        setPrivateGroup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(String value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(String name, String email, String apikey, String password, String privateGroup) {
        super(Users.USERS);

        set(0, name);
        set(1, email);
        set(2, apikey);
        set(3, password);
        set(4, privateGroup);
    }
}