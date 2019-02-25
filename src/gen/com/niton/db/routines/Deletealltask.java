/*
 * This file is generated by jOOQ.
 */
package com.niton.db.routines;


import com.niton.db.Eds;

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
public class Deletealltask extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = -393171831;

    /**
     * The parameter <code>eds.deleteAllTask.groupuid</code>.
     */
    public static final Parameter<String> GROUPUID = Internal.createParameter("groupuid", org.jooq.impl.SQLDataType.VARCHAR(30), false, false);

    /**
     * Create a new routine call instance
     */
    public Deletealltask() {
        super("deleteAllTask", Eds.EDS);

        addInParameter(GROUPUID);
    }

    /**
     * Set the <code>groupuid</code> parameter IN value to the routine
     */
    public void setGroupuid(String value) {
        setValue(GROUPUID, value);
    }
}
