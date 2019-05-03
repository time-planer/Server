/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables;


import com.niton.db.Indexes;
import com.niton.db.Keys;
import com.niton.db.ProjEds;
import com.niton.db.tables.records.EdsGroupRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * All information about the group
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EdsGroup extends TableImpl<EdsGroupRecord> {

    private static final long serialVersionUID = -1818131066;

    /**
     * The reference instance of <code>proj_eds.eds_group</code>
     */
    public static final EdsGroup EDS_GROUP = new EdsGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EdsGroupRecord> getRecordType() {
        return EdsGroupRecord.class;
    }

    /**
     * The column <code>proj_eds.eds_group.name</code>. The name of the group, must **NOT** be unique
     */
    public final TableField<EdsGroupRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "The name of the group, must **NOT** be unique");

    /**
     * The column <code>proj_eds.eds_group.description</code>. A short description of the Group visible for all members
     */
    public final TableField<EdsGroupRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "A short description of the Group visible for all members");

    /**
     * The column <code>proj_eds.eds_group.creation_date</code>. The date when the group was created
     */
    public final TableField<EdsGroupRecord, Date> CREATION_DATE = createField("creation_date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "The date when the group was created");

    /**
     * The column <code>proj_eds.eds_group.uid</code>. An identifyer for the Group as multiple groups with the same name can exist
     */
    public final TableField<EdsGroupRecord, Integer> UID = createField("uid", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "An identifyer for the Group as multiple groups with the same name can exist");

    /**
     * The column <code>proj_eds.eds_group.creator</code>.
     */
    public final TableField<EdsGroupRecord, String> CREATOR = createField("creator", org.jooq.impl.SQLDataType.VARCHAR(320), this, "");

    /**
     * Create a <code>proj_eds.eds_group</code> table reference
     */
    public EdsGroup() {
        this(DSL.name("eds_group"), null);
    }

    /**
     * Create an aliased <code>proj_eds.eds_group</code> table reference
     */
    public EdsGroup(String alias) {
        this(DSL.name(alias), EDS_GROUP);
    }

    /**
     * Create an aliased <code>proj_eds.eds_group</code> table reference
     */
    public EdsGroup(Name alias) {
        this(alias, EDS_GROUP);
    }

    private EdsGroup(Name alias, Table<EdsGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private EdsGroup(Name alias, Table<EdsGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("All information about the group"));
    }

    public <O extends Record> EdsGroup(Table<O> child, ForeignKey<O, EdsGroupRecord> key) {
        super(child, key, EDS_GROUP);
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.EDS_GROUP_FK_GROUP_USERS1, Indexes.EDS_GROUP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<EdsGroupRecord, Integer> getIdentity() {
        return Keys.IDENTITY_EDS_GROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<EdsGroupRecord> getPrimaryKey() {
        return Keys.KEY_EDS_GROUP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<EdsGroupRecord>> getKeys() {
        return Arrays.<UniqueKey<EdsGroupRecord>>asList(Keys.KEY_EDS_GROUP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<EdsGroupRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<EdsGroupRecord, ?>>asList(Keys.GROUPHASCREATOR);
    }

    public Users users() {
        return new Users(this, Keys.GROUPHASCREATOR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroup as(String alias) {
        return new EdsGroup(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroup as(Name alias) {
        return new EdsGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public EdsGroup rename(String name) {
        return new EdsGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public EdsGroup rename(Name name) {
        return new EdsGroup(name, null);
    }
}
