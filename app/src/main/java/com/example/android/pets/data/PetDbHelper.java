package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;
/**
 * Created by Raider on 18-04-2017.
 */

public   class PetDbHelper extends SQLiteOpenHelper {

    public static final String Database_Name="Pets.db";
    public static final int Database_Version=1;

    public PetDbHelper(Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      // CREATE TABLE PETS (_id Integer Primary Key, name Text, breed TEXT, gender Integer, weight Integer);
        // Create a string that contains SQL statement to create table pets
       String SQL_CREATE_PETS_Table= "CREATE TABLE "+ PetEntry.TABLE_NAME+"("+ PetEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PetEntry.COLUMN_PET_NAME+" TEXT NOT NULL, "
                +PetEntry.COLUMN_PET_BREED+" TEXT, "
                +PetEntry.COLUMN_PET_GENDER+" INTEGER NOT NULL, "
                +PetEntry.COLUMN_PET_WEIGHT+" INTEGER NOT NULL DEFAULT 0); ";
        db.execSQL(SQL_CREATE_PETS_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
