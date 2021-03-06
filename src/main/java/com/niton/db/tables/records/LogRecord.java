/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables.records;


import com.niton.db.tables.Log;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


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
public class LogRecord extends TableRecordImpl<LogRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -1510946542;

    /**
     * Setter for <code>proj_eds.log.msg</code>.
     */
    public void setMsg(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>proj_eds.log.msg</code>.
     */
    public String getMsg() {
        return (String) get(0);
    }

    /**
     * Setter for <code>proj_eds.log.desc</code>.
     */
    public void setDesc(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>proj_eds.log.desc</code>.
     */
    public String getDesc() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Log.LOG.MSG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Log.LOG.DESC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getMsg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDesc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getMsg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDesc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LogRecord value1(String value) {
        setMsg(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LogRecord value2(String value) {
        setDesc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LogRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LogRecord
     */
    public LogRecord() {
        super(Log.LOG);
    }

    /**
     * Create a detached, initialised LogRecord
     */
    public LogRecord(String msg, String desc) {
        super(Log.LOG);

        set(0, msg);
        set(1, desc);
    }
}
