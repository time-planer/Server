/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables;


import com.niton.db.Indexes;
import com.niton.db.Keys;
import com.niton.db.ProjEds;
import com.niton.db.tables.records.GroupmemberRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
 * The Member of a group defined by his name and permissions
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Groupmember extends TableImpl<GroupmemberRecord> {

    private static final long serialVersionUID = 1159930816;

    /**
     * The reference instance of <code>proj_eds.groupmember</code>
     */
    public static final Groupmember GROUPMEMBER = new Groupmember();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GroupmemberRecord> getRecordType() {
        return GroupmemberRecord.class;
    }

    /**
     * The column <code>proj_eds.groupmember.edit</code>. Is the user permitted to edit tasks within the group
     */
    public final TableField<GroupmemberRecord, Byte> EDIT = createField("edit", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "Is the user permitted to edit tasks within the group");

    /**
     * The column <code>proj_eds.groupmember.create</code>. is the user permitted to create tasks within the Group
     */
    public final TableField<GroupmemberRecord, Byte> CREATE = createField("create", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "is the user permitted to create tasks within the Group");

    /**
     * The column <code>proj_eds.groupmember.delete</code>. is the User permitted to delte tasks within the group
     */
    public final TableField<GroupmemberRecord, Byte> DELETE = createField("delete", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "is the User permitted to delte tasks within the group");

    /**
     * The column <code>proj_eds.groupmember.group</code>.
     */
    public final TableField<GroupmemberRecord, Integer> GROUP = createField("group", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>proj_eds.groupmember.user</code>.
     */
    public final TableField<GroupmemberRecord, String> USER = createField("user", org.jooq.impl.SQLDataType.VARCHAR(320).nullable(false), this, "");

    /**
     * Create a <code>proj_eds.groupmember</code> table reference
     */
    public Groupmember() {
        this(DSL.name("groupmember"), null);
    }

    /**
     * Create an aliased <code>proj_eds.groupmember</code> table reference
     */
    public Groupmember(String alias) {
        this(DSL.name(alias), GROUPMEMBER);
    }

    /**
     * Create an aliased <code>proj_eds.groupmember</code> table reference
     */
    public Groupmember(Name alias) {
        this(alias, GROUPMEMBER);
    }

    private Groupmember(Name alias, Table<GroupmemberRecord> aliased) {
        this(alias, aliased, null);
    }

    private Groupmember(Name alias, Table<GroupmemberRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("The Member of a group defined by his name and permissions"));
    }

    public <O extends Record> Groupmember(Table<O> child, ForeignKey<O, GroupmemberRecord> key) {
        super(child, key, GROUPMEMBER);
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
        return Arrays.<Index>asList(Indexes.GROUPMEMBER_FK_GROUPMEMBER_USERS1_IDX, Indexes.GROUPMEMBER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GroupmemberRecord> getPrimaryKey() {
        return Keys.KEY_GROUPMEMBER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GroupmemberRecord>> getKeys() {
        return Arrays.<UniqueKey<GroupmemberRecord>>asList(Keys.KEY_GROUPMEMBER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<GroupmemberRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GroupmemberRecord, ?>>asList(Keys.INGROUP, Keys.ISUSER);
    }

    public EdsGroup edsGroup() {
        return new EdsGroup(this, Keys.INGROUP);
    }

    public Users users() {
        return new Users(this, Keys.ISUSER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Groupmember as(String alias) {
        return new Groupmember(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Groupmember as(Name alias) {
        return new Groupmember(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Groupmember rename(String name) {
        return new Groupmember(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Groupmember rename(Name name) {
        return new Groupmember(name, null);
    }
}
