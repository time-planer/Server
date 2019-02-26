/*
 * This file is generated by jOOQ.
 */
package com.niton.db;


import com.niton.db.tables.Apikey;
import com.niton.db.tables.Group;
import com.niton.db.tables.Groupmember;
import com.niton.db.tables.Task;
import com.niton.db.tables.Users;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>eds</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index APIKEY_PRIMARY = Indexes0.APIKEY_PRIMARY;
    public static final Index GROUP_FK_GROUP_USERS1 = Indexes0.GROUP_FK_GROUP_USERS1;
    public static final Index GROUP_PRIMARY = Indexes0.GROUP_PRIMARY;
    public static final Index GROUPMEMBER_FK_GROUPMEMBER_USERS1_IDX = Indexes0.GROUPMEMBER_FK_GROUPMEMBER_USERS1_IDX;
    public static final Index GROUPMEMBER_PRIMARY = Indexes0.GROUPMEMBER_PRIMARY;
    public static final Index TASK_FK_TASK_GROUP1_IDX = Indexes0.TASK_FK_TASK_GROUP1_IDX;
    public static final Index TASK_FK_TASK_USERS1_IDX = Indexes0.TASK_FK_TASK_USERS1_IDX;
    public static final Index TASK_PRIMARY = Indexes0.TASK_PRIMARY;
    public static final Index USERS_FK_USERS_APIKEY_IDX = Indexes0.USERS_FK_USERS_APIKEY_IDX;
    public static final Index USERS_FK_USERS_GROUP1_IDX = Indexes0.USERS_FK_USERS_GROUP1_IDX;
    public static final Index USERS_PRIMARY = Indexes0.USERS_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index APIKEY_PRIMARY = Internal.createIndex("PRIMARY", Apikey.APIKEY, new OrderField[] { Apikey.APIKEY.APIKEY_ }, true);
        public static Index GROUP_FK_GROUP_USERS1 = Internal.createIndex("fk_group_users1", Group.GROUP, new OrderField[] { Group.GROUP.CREATOR }, false);
        public static Index GROUP_PRIMARY = Internal.createIndex("PRIMARY", Group.GROUP, new OrderField[] { Group.GROUP.UID }, true);
        public static Index GROUPMEMBER_FK_GROUPMEMBER_USERS1_IDX = Internal.createIndex("fk_groupmember_users1_idx", Groupmember.GROUPMEMBER, new OrderField[] { Groupmember.GROUPMEMBER.USER }, false);
        public static Index GROUPMEMBER_PRIMARY = Internal.createIndex("PRIMARY", Groupmember.GROUPMEMBER, new OrderField[] { Groupmember.GROUPMEMBER.GROUP, Groupmember.GROUPMEMBER.USER }, true);
        public static Index TASK_FK_TASK_GROUP1_IDX = Internal.createIndex("fk_task_group1_idx", Task.TASK, new OrderField[] { Task.TASK.GROUP_UID }, false);
        public static Index TASK_FK_TASK_USERS1_IDX = Internal.createIndex("fk_task_users1_idx", Task.TASK, new OrderField[] { Task.TASK.USERS_EMAIL }, false);
        public static Index TASK_PRIMARY = Internal.createIndex("PRIMARY", Task.TASK, new OrderField[] { Task.TASK.NAME, Task.TASK.GROUP_UID, Task.TASK.USERS_EMAIL }, true);
        public static Index USERS_FK_USERS_APIKEY_IDX = Internal.createIndex("fk_users_apikey_idx", Users.USERS, new OrderField[] { Users.USERS.APIKEY }, false);
        public static Index USERS_FK_USERS_GROUP1_IDX = Internal.createIndex("fk_users_group1_idx", Users.USERS, new OrderField[] { Users.USERS.PRIVATE_GROUP }, false);
        public static Index USERS_PRIMARY = Internal.createIndex("PRIMARY", Users.USERS, new OrderField[] { Users.USERS.EMAIL }, true);
    }
}