/*
 * This file is generated by jOOQ.
 */
package com.niton.db;


import com.niton.db.tables.Apikey;
import com.niton.db.tables.EdsGroup;
import com.niton.db.tables.Groupmember;
import com.niton.db.tables.Patch;
import com.niton.db.tables.Patchfeature;
import com.niton.db.tables.Task;
import com.niton.db.tables.Users;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in proj_eds
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>proj_eds.apikey</code>.
     */
    public static final Apikey APIKEY = com.niton.db.tables.Apikey.APIKEY;

    /**
     * All information about the group
     */
    public static final EdsGroup EDS_GROUP = com.niton.db.tables.EdsGroup.EDS_GROUP;

    /**
     * The Member of a group defined by his name and permissions
     */
    public static final Groupmember GROUPMEMBER = com.niton.db.tables.Groupmember.GROUPMEMBER;

    /**
     * The table <code>proj_eds.patch</code>.
     */
    public static final Patch PATCH = com.niton.db.tables.Patch.PATCH;

    /**
     * The table <code>proj_eds.patchfeature</code>.
     */
    public static final Patchfeature PATCHFEATURE = com.niton.db.tables.Patchfeature.PATCHFEATURE;

    /**
     * A task is a thing you need to do till a certain point.
     */
    public static final Task TASK = com.niton.db.tables.Task.TASK;

    /**
     * ### Requirements * Name * Email * Password
     */
    public static final Users USERS = com.niton.db.tables.Users.USERS;
}