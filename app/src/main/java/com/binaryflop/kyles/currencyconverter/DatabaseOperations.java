package com.binaryflop.kyles.currencyconverter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kylei on 12/23/2016.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "conversion";

    //  Call our parent constructor
    public DatabaseOperations(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database is created for the first time, like on install
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConversionsContract.SQL_CREATE_ENTRIES);
    }

    // Called when the database needs upgrading, for instance on version update
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database should be refreshed often anyway, so we will just delete and reset it.
        db.execSQL(ConversionsContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
