package com.example.custom_recycler_list;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;


import org.osmdroid.config.Configuration;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;
//https://stackoverflow.com/questions/22295768/how-to-use-osm-map-in-an-android-application-is-there-any-tutorial-to-learn-ab
//https://github.com/osmdroid/osmdroid/wiki/How-to-use-the-osmdroid-library-(Java)
//https://github.com/osmdroid/osmdroid/wiki/Markers,-Lines-and-Polygons-(Java)
public class MapActivity extends AppCompatActivity {
    MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the OSMDroid configuration
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_map);

        // Initialize the MapView
        mapView = findViewById(R.id.map);

        // Get the intent and retrieve the latitude and longitude
        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("latitude", 0);
        double longitude = intent.getDoubleExtra("longitude", 0);

        // Use latitude and longitude to set the map's center

        IMapController mapController = mapView.getController();
        mapController.setZoom(15);
        GeoPoint point = new GeoPoint(latitude, longitude);
        mapController.setCenter(point);


        Marker marker = new Marker(mapView);
        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(marker);
    }


}
