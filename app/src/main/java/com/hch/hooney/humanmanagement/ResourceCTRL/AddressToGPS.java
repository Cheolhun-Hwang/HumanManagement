package com.hch.hooney.humanmanagement.ResourceCTRL;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by hch on 2018-03-29.
 */

public class AddressToGPS {
    //주소를 이용해 위치 좌표를 찾는 메소드 정의
    public static Address getAddress(Context context, String addr){
        Address address = null;
        List<Address> addressList = null;
        Geocoder gc;
        try{
            gc = new Geocoder(context, Locale.KOREA);
            //해당 주소의 최대 검색 크기 10;
            addressList = gc.getFromLocationName(addr, 10);

            if(addressList == null || addressList.size()<1){
                return null;
            }else{
                Log.d("AddressToGPS", "address Length : " + addressList.size());
                for(int index = 0 ; index < addressList.size();index++){
                    Address outAddr = addressList.get(index);

                    if(index == 0){
                        address = outAddr;
                    }

                    //TEST
                    Log.d("AddressToGPS", "경도 : " + outAddr.getLatitude()
                            + " / 위도 : "+ outAddr.getLongitude() );
                }
            }

        }catch (IOException e){
            Log.e("AddressToGPS", "Address To GPS Error...");
            e.printStackTrace();
        }

        return address;
    }
}
