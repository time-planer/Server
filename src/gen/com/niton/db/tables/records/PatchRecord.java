/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables.records;


import com.niton.db.tables.Patch;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UByte;


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
public class PatchRecord extends UpdatableRecordImpl<PatchRecord> implements Record6<String, UByte, String, String, Date, String> {

    private static final long serialVersionUID = -658228843;

    /**
     * Setter for <code>proj_eds.patch.version</code>.
     */
    public void setVersion(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>proj_eds.patch.version</code>.
     */
    public String getVersion() {
        return (String) get(0);
    }

    /**
     * Setter for <code>proj_eds.patch.released</code>.
     */
    public void setReleased(UByte value) {
        set(1, value);
    }

    /**
     * Getter for <code>proj_eds.patch.released</code>.
     */
    public UByte getReleased() {
        return (UByte) get(1);
    }

    /**
     * Setter for <code>proj_eds.patch.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>proj_eds.patch.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>proj_eds.patch.description</code>.
     */
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>proj_eds.patch.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>proj_eds.patch.release</code>.
     */
    public void setRelease(Date value) {
        set(4, value);
    }

    /**
     * Getter for <code>proj_eds.patch.release</code>.
     */
    public Date getRelease() {
        return (Date) get(4);
    }

    /**
     * Setter for <code>proj_eds.patch.image</code>.
     */
    public void setImage(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>proj_eds.patch.image</code>.
     */
    public String getImage() {
        return (String) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, UByte, String, String, Date, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, UByte, String, String, Date, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Patch.PATCH.VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UByte> field2() {
        return Patch.PATCH.RELEASED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Patch.PATCH.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Patch.PATCH.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field5() {
        return Patch.PATCH.RELEASE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Patch.PATCH.IMAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte component2() {
        return getReleased();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component5() {
        return getRelease();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getImage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte value2() {
        return getReleased();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value5() {
        return getRelease();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getImage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchRecord value1(String value) {
        setVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchRecord value2(UByte value) {
        setReleased(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchRecord value5(Date value) {
        setRelease(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchRecord value6(String value) {
        setImage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchRecord values(String value1, UByte value2, String value3, String value4, Date value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PatchRecord
     */
    public PatchRecord() {
        super(Patch.PATCH);
    }

    /**
     * Create a detached, initialised PatchRecord
     */
    public PatchRecord(String version, UByte released, String name, String description, Date release, String image) {
        super(Patch.PATCH);

        set(0, version);
        set(1, released);
        set(2, name);
        set(3, description);
        set(4, release);
        set(5, image);
    }
}