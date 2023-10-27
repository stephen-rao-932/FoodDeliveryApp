package com.raogroup.fooddeliveryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mySqlLite extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "Products.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Product_List";
    private static final String COLUMN_NAME = "_id";

    public mySqlLite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
