/*
 * This file is generated by jOOQ.
 */
package com.niton.db;


import com.niton.db.tables.Apikey;
import com.niton.db.tables.Group;
import com.niton.db.tables.Groupmember;
import com.niton.db.tables.Task;
import com.niton.db.tables.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Eds extends SchemaImpl {

    private static final long serialVersionUID = 1662957893;

    /**
     * The reference instance of <code>eds</code>
     */
    public static final Eds EDS = new Eds();

    /**
     * The table <code>eds.apikey</code>.
     */
    public final Apikey APIKEY = com.niton.db.tables.Apikey.APIKEY;

    /**
     * All information about the group
     */
    public final Group GROUP = com.niton.db.tables.Group.GROUP;

    /**
     * The Member of a group defined by his name and permissions
     */
    public final Groupmember GROUPMEMBER = com.niton.db.tables.Groupmember.GROUPMEMBER;

    /**
     * A task is a thing you need to do till a certain point.
     */
    public final Task TASK = com.niton.db.tables.Task.TASK;

    /**
     * ### Requirements * Name * Email * Password
     */
    public final Users USERS = com.niton.db.tables.Users.USERS;

    /**
     * No further instances allowed
     */
    private Eds() {
        super("proj_eds", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Apikey.APIKEY,
            Group.GROUP,
            Groupmember.GROUPMEMBER,
            Task.TASK,
            Users.USERS);
    }
}
