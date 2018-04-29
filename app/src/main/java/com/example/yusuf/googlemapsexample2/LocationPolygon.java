package com.example.yusuf.googlemapsexample2;

import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Yusuf on 26.03.2018.
 */

public  class LocationPolygon {
    public String LocationName;
    public ArrayList<Point> polygonNodes;
    public Point[] polygonArray;

    public LocationPolygon(){
        LocationName="";
        polygonNodes=new ArrayList<Point>();
    }

    public LocationPolygon(String locationname){
        LocationName=locationname;
        polygonNodes=new ArrayList<Point>();
    }
    public LocationPolygon(String locationname,ArrayList locationlist){
        LocationName=locationname;
        polygonNodes=locationlist;
    }
    public void addNode(Point p){
        // TODO: 19.04.2018 şeklin en az 3 noktalı olması kontrol etmeli
        polygonNodes.add(p);
        createpolygonArray();

    }
    public void WriteAllNodes(){
        for (Point a:polygonNodes)
        {
            Log.e("Point","Node: "+" X: "+a.x+" Y: "+a.y);
        }
    }
    public boolean isInside(Point point){
       // createpolygonArray();

     //   Log.d("PolygonArrayLenght: ",String.valueOf(polygonArray.length));
       boolean  result=false;
       int i,j;
        for (i=0,j=polygonArray.length-1;i<polygonArray.length;j=i++) {
            if ((polygonArray[i].y>point.y!=(polygonArray[j].y>point.y)&&(point.x<(polygonArray[j].x-polygonArray[i].x)*(point.y-polygonArray[i].y)/(polygonArray[j].y-polygonArray[i].y)+polygonArray[i].x))) {
              result=!result;
              break;
            }
        }




       return result;
    }
    public int getNumberOfpolygonNodes(){

        int number=0;
        for (Point a:polygonNodes)
        {
            number++;
        }
        Log.e("NumberOfpolygonNodes: ",String.valueOf(number));


        return number;
    }
    public void createpolygonArray(){
        polygonArray=new Point[getNumberOfpolygonNodes()];
        Log.e("ArrayLenght:  ",String.valueOf(polygonArray.length));
        int i=0;
        for (Point tmp:polygonNodes)
        {
          polygonArray[i]=tmp;

          Log.e("Points: ","X: "+String.valueOf(tmp.x)+"Y:  "+String.valueOf(tmp.y));
          Log.e("Array ","id: "+i+"  X:  "+String.valueOf(polygonArray[i].x)+"  Y:  "+String.valueOf(polygonArray[i].y));
            i++;
        }
    }
    public void setLocationName(String name){
        this.LocationName=name;
    }
    public String getLocationName(){
        return LocationName;
    }
}
