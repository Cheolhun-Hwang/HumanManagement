package com.hch.hooney.humanmanagement.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hch.hooney.humanmanagement.DAO.HumanManagement;

/**
 * Created by hch on 2018-03-24.
 */

public class MySQLiteHandler {
    private MySQLiteOpenHelper helper;
    private SQLiteDatabase db;

    public MySQLiteHandler(Context mContext) {
        this.helper = new MySQLiteOpenHelper(mContext, "sqlite_project.sqlite", null, 1);
    }

    public static MySQLiteHandler open(Context ctx){
        return new MySQLiteHandler(ctx);
    }

    public void close(){
        helper.close();
    }

    public void insertHuman(HumanManagement hm){
        db = helper.getWritableDatabase();
        ContentValues vales = new ContentValues();
        vales.put("hm_id", hm.getHm_id());
        vales.put("hm_name", hm.getHm_name());
        vales.put("hm_part", hm.getHm_part());
        vales.put("hm_date", hm.getHm_date());
        vales.put("hm_phone", hm.getHm_phone());
        vales.put("hm_address", hm.getHm_address());
        vales.put("hm_spotName", hm.getHm_spotName());
        vales.put("hm_mapX", hm.getHm_mapX());
        vales.put("hm_mapY", hm.getHm_mapY());
        vales.put("hm_comment", hm.getHm_comment());
        vales.put("hm_mainPhoto", hm.getHm_mainPhoto());
        vales.put("hm_subPhotos", hm.getHm_subPhotos());
        vales.put("hm_isNew", hm.getIsNew());
        db.insert("human", null, vales);
    }

    public void updeateHuman(HumanManagement hm){
        db = helper.getWritableDatabase();
        ContentValues vales = new ContentValues();
        vales.put("hm_name", hm.getHm_name());
        vales.put("hm_part", hm.getHm_part());
        vales.put("hm_date", hm.getHm_date());
        vales.put("hm_phone", hm.getHm_phone());
        vales.put("hm_address", hm.getHm_address());
        vales.put("hm_spotName", hm.getHm_spotName());
        vales.put("hm_mapX", hm.getHm_mapX());
        vales.put("hm_mapY", hm.getHm_mapY());
        vales.put("hm_comment", hm.getHm_comment());
        vales.put("hm_mainPhoto", hm.getHm_mainPhoto());
        vales.put("hm_subPhotos", hm.getHm_subPhotos());
        vales.put("hm_isNew", hm.getIsNew());
        db.update("human", vales, "hm_id = ?", new String[]{(hm.getHm_id()+"")});
    }

    public void deleteHumanByID(String hm_id){
        db.delete("human", "hm_id = ?", new String[]{hm_id});
    }

    public void clearHuman(){
        db = helper.getWritableDatabase();
        db.execSQL("delete from human");
    }

    public Cursor selectAllHuman(){
        db = helper.getWritableDatabase();
        Cursor c = db.query("human", null, null, null, null, null, null);
        return c;
    }

    public Cursor selectByIDHuman(String hm_id){
        db = helper.getWritableDatabase();
        Cursor c = db.query("human", null, "hm_id = ?", new String[]{hm_id}, null, null, null);
        return c;
    }
}
