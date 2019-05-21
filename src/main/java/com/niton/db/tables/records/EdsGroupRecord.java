/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables.records;


import com.niton.db.tables.EdsGroup;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class EdsGroupRecord extends UpdatableRecordImpl<EdsGroupRecord> implements Record5<String, String, Date, Integer, String> {

    private static final long serialVersionUID = 1797924732;

    /**
     * Setter for <code>proj_eds.eds_group.name</code>. The name of the group, must **NOT** be unique
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>proj_eds.eds_group.name</code>. The name of the group, must **NOT** be unique
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>proj_eds.eds_group.description</code>. A short description of the Group visible for all members
     */
    public void setDescription(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>proj_eds.eds_group.description</code>. A short description of the Group visible for all members
     */
    public String getDescription() {
        return (String) get(1);
    }

    /**
     * Setter for <code>proj_eds.eds_group.creation_date</code>. The date when the group was created
     */
    public void setCreationDate(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>proj_eds.eds_group.creation_date</code>. The date when the group was created
     */
    public Date getCreationDate() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>proj_eds.eds_group.uid</code>. An identifyer for the Group as multiple groups with the same name can exist
     */
    public void setUid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>proj_eds.eds_group.uid</code>. An identifyer for the Group as multiple groups with the same name can exist
     */
    public Integer getUid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>proj_eds.eds_group.creator</code>.
     */
    public void setCreator(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>proj_eds.eds_group.creator</code>.
     */
    public String getCreator() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, Date, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, Date, Integer, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return EdsGroup.EDS_GROUP.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return EdsGroup.EDS_GROUP.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return EdsGroup.EDS_GROUP.CREATION_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return EdsGroup.EDS_GROUP.UID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return EdsGroup.EDS_GROUP.CREATOR;
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
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component3() {
        return getCreationDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCreator();
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
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value3() {
        return getCreationDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getUid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCreator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroupRecord value1(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroupRecord value2(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroupRecord value3(Date value) {
        setCreationDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroupRecord value4(Integer value) {
        setUid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroupRecord value5(String value) {
        setCreator(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EdsGroupRecord values(String value1, String value2, Date value3, Integer value4, String value5) {
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
     * Create a detached EdsGroupRecord
     */
    public EdsGroupRecord() {
        super(EdsGroup.EDS_GROUP);
    }

    /**
     * Create a detached, initialised EdsGroupRecord
     */
    public EdsGroupRecord(String name, String description, Date creationDate, Integer uid, String creator) {
        super(EdsGroup.EDS_GROUP);

        set(0, name);
        set(1, description);
        set(2, creationDate);
        set(3, uid);
        set(4, creator);
    }
}
