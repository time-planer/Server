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
import com.niton.db.tables.records.ApikeyRecord;
import com.niton.db.tables.records.EdsGroupRecord;
import com.niton.db.tables.records.GroupmemberRecord;
import com.niton.db.tables.records.PatchRecord;
import com.niton.db.tables.records.PatchfeatureRecord;
import com.niton.db.tables.records.TaskRecord;
import com.niton.db.tables.records.UsersRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>proj_eds</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<EdsGroupRecord, Integer> IDENTITY_EDS_GROUP = Identities0.IDENTITY_EDS_GROUP;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ApikeyRecord> KEY_APIKEY_PRIMARY = UniqueKeys0.KEY_APIKEY_PRIMARY;
    public static final UniqueKey<EdsGroupRecord> KEY_EDS_GROUP_PRIMARY = UniqueKeys0.KEY_EDS_GROUP_PRIMARY;
    public static final UniqueKey<GroupmemberRecord> KEY_GROUPMEMBER_PRIMARY = UniqueKeys0.KEY_GROUPMEMBER_PRIMARY;
    public static final UniqueKey<PatchRecord> KEY_PATCH_PRIMARY = UniqueKeys0.KEY_PATCH_PRIMARY;
    public static final UniqueKey<PatchRecord> KEY_PATCH_NAME_UNIQUE = UniqueKeys0.KEY_PATCH_NAME_UNIQUE;
    public static final UniqueKey<TaskRecord> KEY_TASK_PRIMARY = UniqueKeys0.KEY_TASK_PRIMARY;
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = UniqueKeys0.KEY_USERS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<EdsGroupRecord, UsersRecord> GROUPHASCREATOR = ForeignKeys0.GROUPHASCREATOR;
    public static final ForeignKey<GroupmemberRecord, EdsGroupRecord> INGROUP = ForeignKeys0.INGROUP;
    public static final ForeignKey<GroupmemberRecord, UsersRecord> ISUSER = ForeignKeys0.ISUSER;
    public static final ForeignKey<PatchfeatureRecord, PatchRecord> ADDED = ForeignKeys0.ADDED;
    public static final ForeignKey<PatchfeatureRecord, PatchRecord> REMOVED = ForeignKeys0.REMOVED;
    public static final ForeignKey<PatchfeatureRecord, PatchRecord> MODIFYED = ForeignKeys0.MODIFYED;
    public static final ForeignKey<TaskRecord, EdsGroupRecord> ISTINGRUPPE = ForeignKeys0.ISTINGRUPPE;
    public static final ForeignKey<TaskRecord, UsersRecord> GEHÖRT = ForeignKeys0.GEHÖRT;
    public static final ForeignKey<UsersRecord, ApikeyRecord> INDENDIFIZIERT = ForeignKeys0.INDENDIFIZIERT;
    public static final ForeignKey<UsersRecord, EdsGroupRecord> HATPRIVATEGRUPPE = ForeignKeys0.HATPRIVATEGRUPPE;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<EdsGroupRecord, Integer> IDENTITY_EDS_GROUP = Internal.createIdentity(EdsGroup.EDS_GROUP, EdsGroup.EDS_GROUP.UID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<ApikeyRecord> KEY_APIKEY_PRIMARY = Internal.createUniqueKey(Apikey.APIKEY, "KEY_apikey_PRIMARY", Apikey.APIKEY.APIKEY_);
        public static final UniqueKey<EdsGroupRecord> KEY_EDS_GROUP_PRIMARY = Internal.createUniqueKey(EdsGroup.EDS_GROUP, "KEY_eds_group_PRIMARY", EdsGroup.EDS_GROUP.UID);
        public static final UniqueKey<GroupmemberRecord> KEY_GROUPMEMBER_PRIMARY = Internal.createUniqueKey(Groupmember.GROUPMEMBER, "KEY_groupmember_PRIMARY", Groupmember.GROUPMEMBER.GROUP, Groupmember.GROUPMEMBER.USER);
        public static final UniqueKey<PatchRecord> KEY_PATCH_PRIMARY = Internal.createUniqueKey(Patch.PATCH, "KEY_patch_PRIMARY", Patch.PATCH.VERSION);
        public static final UniqueKey<PatchRecord> KEY_PATCH_NAME_UNIQUE = Internal.createUniqueKey(Patch.PATCH, "KEY_patch_name_UNIQUE", Patch.PATCH.NAME);
        public static final UniqueKey<TaskRecord> KEY_TASK_PRIMARY = Internal.createUniqueKey(Task.TASK, "KEY_task_PRIMARY", Task.TASK.NAME, Task.TASK.GROUP_UID, Task.TASK.USERS_EMAIL);
        public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, "KEY_users_PRIMARY", Users.USERS.EMAIL);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<EdsGroupRecord, UsersRecord> GROUPHASCREATOR = Internal.createForeignKey(com.niton.db.Keys.KEY_USERS_PRIMARY, EdsGroup.EDS_GROUP, "groupHasCreator", EdsGroup.EDS_GROUP.CREATOR);
        public static final ForeignKey<GroupmemberRecord, EdsGroupRecord> INGROUP = Internal.createForeignKey(com.niton.db.Keys.KEY_EDS_GROUP_PRIMARY, Groupmember.GROUPMEMBER, "inGroup", Groupmember.GROUPMEMBER.GROUP);
        public static final ForeignKey<GroupmemberRecord, UsersRecord> ISUSER = Internal.createForeignKey(com.niton.db.Keys.KEY_USERS_PRIMARY, Groupmember.GROUPMEMBER, "isUser", Groupmember.GROUPMEMBER.USER);
        public static final ForeignKey<PatchfeatureRecord, PatchRecord> ADDED = Internal.createForeignKey(com.niton.db.Keys.KEY_PATCH_PRIMARY, Patchfeature.PATCHFEATURE, "added", Patchfeature.PATCHFEATURE.ADDED);
        public static final ForeignKey<PatchfeatureRecord, PatchRecord> REMOVED = Internal.createForeignKey(com.niton.db.Keys.KEY_PATCH_PRIMARY, Patchfeature.PATCHFEATURE, "removed", Patchfeature.PATCHFEATURE.REMOVED);
        public static final ForeignKey<PatchfeatureRecord, PatchRecord> MODIFYED = Internal.createForeignKey(com.niton.db.Keys.KEY_PATCH_PRIMARY, Patchfeature.PATCHFEATURE, "modifyed", Patchfeature.PATCHFEATURE.MODIFYED);
        public static final ForeignKey<TaskRecord, EdsGroupRecord> ISTINGRUPPE = Internal.createForeignKey(com.niton.db.Keys.KEY_EDS_GROUP_PRIMARY, Task.TASK, "istInGruppe", Task.TASK.GROUP_UID);
        public static final ForeignKey<TaskRecord, UsersRecord> GEHÖRT = Internal.createForeignKey(com.niton.db.Keys.KEY_USERS_PRIMARY, Task.TASK, "gehört", Task.TASK.USERS_EMAIL);
        public static final ForeignKey<UsersRecord, ApikeyRecord> INDENDIFIZIERT = Internal.createForeignKey(com.niton.db.Keys.KEY_APIKEY_PRIMARY, Users.USERS, "indendifiziert", Users.USERS.APIKEY);
        public static final ForeignKey<UsersRecord, EdsGroupRecord> HATPRIVATEGRUPPE = Internal.createForeignKey(com.niton.db.Keys.KEY_EDS_GROUP_PRIMARY, Users.USERS, "hatPrivateGruppe", Users.USERS.PRIVATE_GROUP);
    }
}
