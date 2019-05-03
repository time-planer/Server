/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables.records;


import com.niton.db.tables.Apikey;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ApikeyRecord extends UpdatableRecordImpl<ApikeyRecord> implements Record1<String> {

    private static final long serialVersionUID = 1142220642;

    /**
     * Setter for <code>proj_eds.apikey.apikey</code>.
     */
    public void setApikey(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>proj_eds.apikey.apikey</code>.
     */
    public String getApikey() {
        return (String) get(0);
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
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Apikey.APIKEY.APIKEY_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getApikey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getApikey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApikeyRecord value1(String value) {
        setApikey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ApikeyRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ApikeyRecord
     */
    public ApikeyRecord() {
        super(Apikey.APIKEY);
    }

    /**
     * Create a detached, initialised ApikeyRecord
     */
    public ApikeyRecord(String apikey) {
        super(Apikey.APIKEY);

        set(0, apikey);
    }
}