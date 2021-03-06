/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables;


import com.niton.db.ProjEds;
import com.niton.db.tables.records.LogRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Log extends TableImpl<LogRecord> {

    private static final long serialVersionUID = -1325200792;

    /**
     * The reference instance of <code>proj_eds.log</code>
     */
    public static final Log LOG = new Log();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LogRecord> getRecordType() {
        return LogRecord.class;
    }

    /**
     * The column <code>proj_eds.log.msg</code>.
     */
    public final TableField<LogRecord, String> MSG = createField("msg", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>proj_eds.log.desc</code>.
     */
    public final TableField<LogRecord, String> DESC = createField("desc", org.jooq.impl.SQLDataType.VARCHAR(45).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>proj_eds.log</code> table reference
     */
    public Log() {
        this(DSL.name("log"), null);
    }

    /**
     * Create an aliased <code>proj_eds.log</code> table reference
     */
    public Log(String alias) {
        this(DSL.name(alias), LOG);
    }

    /**
     * Create an aliased <code>proj_eds.log</code> table reference
     */
    public Log(Name alias) {
        this(alias, LOG);
    }

    private Log(Name alias, Table<LogRecord> aliased) {
        this(alias, aliased, null);
    }

    private Log(Name alias, Table<LogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Log(Table<O> child, ForeignKey<O, LogRecord> key) {
        super(child, key, LOG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return ProjEds.PROJ_EDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Log as(String alias) {
        return new Log(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Log as(Name alias) {
        return new Log(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Log rename(String name) {
        return new Log(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Log rename(Name name) {
        return new Log(name, null);
    }
}
