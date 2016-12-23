package com.binaryflop.kyles.currencyconverter;

import android.provider.BaseColumns;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kylei on 12/22/2016.
 */

public final class ConversionsContract {
    private ConversionsContract() {}

    public static class ConversionEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String FROM = "from";
        public static final String TO = "to";
        public static final String MULTIPLIER = "multiplier";
    }

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ConversionEntry.TABLE_NAME + " (" + ConversionEntry._ID + " INTEGER PRIMARY KEY," + ConversionEntry.FROM + " TEXT    ," + ConversionEntry.TO + " TEXT, " + ConversionEntry.MULTIPLIER + ")";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ConversionEntry.TABLE_NAME;



}
