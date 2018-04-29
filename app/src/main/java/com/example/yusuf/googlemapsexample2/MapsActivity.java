package com.example.yusuf.googlemapsexample2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.OverScroller;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
    ,LocationListener
{

    private GoogleMap mMap;
    Button btn1;
    LatLng currentLatLng;

    FusedLocationProviderClient fusedLocationProviderClient;
    LocationRequest locationRequest;
    Location myLocation;
    Marker myMarker;


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        createMuhendislikMimarlik();
        btn1= (Button) findViewById(R.id.Satbtn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MapsActivity.this,"This button is working s well",Toast.LENGTH_LONG).show();
            }
        });

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        mMap.setIndoorEnabled(true);
        locationRequest=new LocationRequest();
        locationRequest.setInterval(1000);// yarım saniye
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,mLocationCallback, Looper.myLooper());
        mMap.setMyLocationEnabled(true);

        //Toast.makeText(this,String.valueOf(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)),Toast.LENGTH_LONG).show();




    }
    LocationCallback mLocationCallback = new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for (Location location : locationResult.getLocations()) {
                Log.i("MapsActivity", "Location: " + location.getLatitude() + " " + location.getLongitude());
                myLocation = location;

//                if (myMarker != null) {
//                    myMarker.remove();
//                }

                //Place current location marker
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                currentLatLng=latLng;
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("Current Position");
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

                myMarker = mMap.addMarker(markerOptions);

                //move map camera
                //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 11));
            }

        };

    };



    @Override
    public void onLocationChanged(Location location) {
////        if (location!=null){
////            Log.d("Location: "+String.valueOf(location.getLatitude())+" "+String.valueOf(location.getLongitude()),"");
////        CameraUpdate cam =CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(),location.getLongitude()));
////        mMap.moveCamera(cam);
////        //Toast.makeText(this,"Location: "+String.valueOf(location.getLatitude())+" "+String.valueOf(location.getLongitude()),Toast.LENGTH_LONG).show();
////        }
//        if (location!=null){
//            double latitude=location.getLatitude();
//            double longitude=location.getLongitude();
//            tw.setText("Location: "+String.valueOf(latitude)+" , "+String.valueOf(longitude));
//        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
       Toast.makeText(this,provider+":  "+"status: "+String.valueOf(status),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
      Toast.makeText(this,provider+" is enabled!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this,provider+" is disabled!",Toast.LENGTH_SHORT).show();
    }
    public boolean isInsideLocation(Point[]points,Point test){
        boolean result=false;
        int i,j;

        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].y > test.y) != (points[j].y > test.y) &&
                    (test.x < (points[j].x - points[i].x) * (test.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
                result = !result;
            }
        }

        return result;
    }
    public void createMuhendislikMimarlik(){
        LocationPolygon muhendislik=new LocationPolygon();
        muhendislik.setLocationName("Muhendislik Mimarlik");
        muhendislik.addNode(new Point(37961871,41850316));
        muhendislik.addNode(new Point(37962358,41851420));
        muhendislik.addNode(new Point(37963455,41850687));
        muhendislik.addNode(new Point(37962991,41849685));

        Log.e("is Inside Result",String.valueOf(muhendislik.isInside(new Point(37962672,41850412))));
        Log.i("is Inside Result",String.valueOf(muhendislik.isInside(new Point(37963169,41851564))));
        Log.e("is Inside Result",String.valueOf(muhendislik.isInside(new Point(37962390,41851105))));

    }


//    private Location MgetMyLocation() {
//        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//        Location myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        if (myLocation == null) {
//            Criteria criteria = new Criteria();
//            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
//            String provider = lm.getBestProvider(criteria, true);
//            myLocation = lm.getLastKnownLocation(provider);
//        }
//        return myLocation;
//    }
//    public void UpdateLocation(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//              //  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,1);
//
//            }
//        }).start();
//    }
}
