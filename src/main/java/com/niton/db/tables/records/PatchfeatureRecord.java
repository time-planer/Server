/*
 * This file is generated by jOOQ.
 */
package com.niton.db.tables.records;


import com.niton.db.tables.Patchfeature;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class PatchfeatureRecord extends TableRecordImpl<PatchfeatureRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 1031453966;

    /**
     * Setter for <code>proj_eds.patchfeature.description</code>.
     */
    public void setDescription(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>proj_eds.patchfeature.description</code>.
     */
    public String getDescription() {
        return (String) get(0);
    }

    /**
     * Setter for <code>proj_eds.patchfeature.added</code>.
     */
    public void setAdded(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>proj_eds.patchfeature.added</code>.
     */
    public String getAdded() {
        return (String) get(1);
    }

    /**
     * Setter for <code>proj_eds.patchfeature.removed</code>.
     */
    public void setRemoved(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>proj_eds.patchfeature.removed</code>.
     */
    public String getRemoved() {
        return (String) get(2);
    }

    /**
     * Setter for <code>proj_eds.patchfeature.modifyed</code>.
     */
    public void setModifyed(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>proj_eds.patchfeature.modifyed</code>.
     */
    public String getModifyed() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Patchfeature.PATCHFEATURE.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Patchfeature.PATCHFEATURE.ADDED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Patchfeature.PATCHFEATURE.REMOVED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Patchfeature.PATCHFEATURE.MODIFYED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAdded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getRemoved();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getModifyed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAdded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getRemoved();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getModifyed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchfeatureRecord value1(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchfeatureRecord value2(String value) {
        setAdded(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchfeatureRecord value3(String value) {
        setRemoved(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchfeatureRecord value4(String value) {
        setModifyed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PatchfeatureRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PatchfeatureRecord
     */
    public PatchfeatureRecord() {
        super(Patchfeature.PATCHFEATURE);
    }

    /**
     * Create a detached, initialised PatchfeatureRecord
     */
    public PatchfeatureRecord(String description, String added, String removed, String modifyed) {
        super(Patchfeature.PATCHFEATURE);

        set(0, description);
        set(1, added);
        set(2, removed);
        set(3, modifyed);
    }
}
