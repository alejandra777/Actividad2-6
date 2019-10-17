package com.example.proyecto;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MAPA extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        int estado = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (estado == ConnectionResult.SUCCESS) {
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } else {
            Dialog mens = GooglePlayServicesUtil.getErrorDialog(estado, (Activity) getApplicationContext(), 10);
            mens.show();
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        UiSettings USet = mMap.getUiSettings();
        USet.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng chile = new LatLng(-30.604494, -71.2047422);
        mMap.addMarker(new MarkerOptions().position(chile).title("Creacion De Aplicacion").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        float zoomnivel = 16;

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chile, zoomnivel));
    }
}