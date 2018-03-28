package com.hch.hooney.humanmanagement.Database;

/**
 * Created by hch on 2018-03-24.
 */
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private final String TAG = "MySQLiteOpenHelper";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate..");
        String sql1 = "CREATE TABLE IF NOT EXISTS human("+
                "hm_id integer NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                "hm_name text NOT NULL, "+
                "hm_part text, "+
                "hm_date text NOT NULL, "+
                "hm_phone text, "+
                "hm_address text NOT NULL, "+
                "hm_spotName text NOT NULL, "+
                "hm_mapX double NOT NULL, "+
                "hm_mapY double NOT NULL, "+
                "hm_comment text, "+
                "hm_mainPhoto text, "+
                "hm_subPhotos text, "+
                "hm_isNew integer NOT NULL "+
                ")";

        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade.. to Delete");
        String sql1 = "DROP TABLE IF EXISTS human";

        db.execSQL(sql1);

        onCreate(db);
    }
}
