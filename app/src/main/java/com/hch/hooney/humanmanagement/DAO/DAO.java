package com.hch.hooney.humanmanagement.DAO;

import android.content.Context;
import android.database.Cursor;

import com.hch.hooney.humanmanagement.Database.MySQLiteHandler;

import java.util.ArrayList;

/**
 * Created by hch on 2018-03-24.
 */

public class DAO {
    public static MySQLiteHandler handler;
    public static ArrayList<HumanManagement> hmList;

    public static void initStaticDAOResources(Context mContext){
        DAO.handler = MySQLiteHandler.open(mContext);
        DAO.hmList = new ArrayList<HumanManagement>();
    }

    public static void loadHumanResources(){
        DAO.hmList.clear();
        Cursor cursor = DAO.handler.selectAllHuman();

        if(cursor.moveToFirst()){
            do{
                HumanManagement item = new HumanManagement();
                item.setHm_id(cursor.getInt(0));
                item.setHm_name(cursor.getString(1));
                item.setHm_part(cursor.getString(2));
                item.setHm_date(cursor.getString(3));
                item.setHm_phone(cursor.getString(4));
                item.setHm_address(cursor.getString(5));
                item.setHm_spotName(cursor.getString(6));
                item.setHm_mapX(cursor.getDouble(7));
                item.setHm_mapY(cursor.getDouble(8));
                item.setHm_comment(cursor.getString(9));
                item.setHm_mainPhoto(cursor.getString(10));
                item.setHm_mainPhoto(cursor.getString(11));
                item.setHm_subPhotos(cursor.getString(12));
                item.setIsNew(cursor.getInt(13));
                DAO.hmList.add(0, item);
            }while (cursor.moveToNext());
        }
    }
}
