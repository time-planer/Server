/*
 * This file is generated by jOOQ.
 */
package com.niton.db.routines;


import com.niton.db.Eds;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;


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
public class Addtask extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 475614983;

    /**
     * The parameter <code>eds.addTask.name</code>.
     */
    public static final Parameter<String> NAME = Internal.createParameter("name", org.jooq.impl.SQLDataType.VARCHAR(50), false, false);

    /**
     * The parameter <code>eds.addTask.deadline</code>.
     */
    public static final Parameter<Date> DEADLINE = Internal.createParameter("deadline", org.jooq.impl.SQLDataType.DATE, false, false);

    /**
     * The parameter <code>eds.addTask.planeddate</code>.
     */
    public static final Parameter<Date> PLANEDDATE = Internal.createParameter("planeddate", org.jooq.impl.SQLDataType.DATE, false, false);

    /**
     * The parameter <code>eds.addTask.description</code>.
     */
    public static final Parameter<String> DESCRIPTION = Internal.createParameter("description", org.jooq.impl.SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>eds.addTask.importance</code>.
     */
    public static final Parameter<Byte> IMPORTANCE = Internal.createParameter("importance", org.jooq.impl.SQLDataType.TINYINT, false, false);

    /**
     * The parameter <code>eds.addTask.groupuid</code>.
     */
    public static final Parameter<String> GROUPUID = Internal.createParameter("groupuid", org.jooq.impl.SQLDataType.VARCHAR(30), false, false);

    /**
     * Create a new routine call instance
     */
    public Addtask() {
        super("addTask", Eds.EDS);

        addInParameter(NAME);
        addInParameter(DEADLINE);
        addInParameter(PLANEDDATE);
        addInParameter(DESCRIPTION);
        addInParameter(IMPORTANCE);
        addInParameter(GROUPUID);
    }

    /**
     * Set the <code>name</code> parameter IN value to the routine
     */
    public void setName_(String value) {
        setValue(NAME, value);
    }

    /**
     * Set the <code>deadline</code> parameter IN value to the routine
     */
    public void setDeadline(Date value) {
        setValue(DEADLINE, value);
    }

    /**
     * Set the <code>planeddate</code> parameter IN value to the routine
     */
    public void setPlaneddate(Date value) {
        setValue(PLANEDDATE, value);
    }

    /**
     * Set the <code>description</code> parameter IN value to the routine
     */
    public void setDescription(String value) {
        setValue(DESCRIPTION, value);
    }

    /**
     * Set the <code>importance</code> parameter IN value to the routine
     */
    public void setImportance(Byte value) {
        setValue(IMPORTANCE, value);
    }

    /**
     * Set the <code>groupuid</code> parameter IN value to the routine
     */
    public void setGroupuid(String value) {
        setValue(GROUPUID, value);
    }
}
