package com.example.yusuf.googlemapsexample2;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Yusuf on 14.04.2018.
 */

public class LocationChecker {
    String Latitude="";
    String Longitude="";

    private int TargetStringSize=9;


    public LocationChecker(LatLng latLng){

       Latitude=String.valueOf(latLng.latitude);
       Longitude=String.valueOf(latLng.longitude);
    }
    private String CutString(String text){
        String newtext="";
        for (int i=0;i<TargetStringSize;i++){
            if (text.charAt(i)!='.')
            {
                newtext+=text.charAt(i);
            }
        }
        return newtext;
    }
    public void MakeTargetLocationFormats(){
        Latitude=CutString(Latitude);
        Longitude=CutString(Longitude);
    }
    public String getLatitude(){
        return Latitude;
    }
    public String getLongitude(){
        return Longitude;
    }
}
