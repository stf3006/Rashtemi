package com.example.alex.rashtemirestaurant;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;

public class ContactActivity extends FragmentActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            PropertiesHelper helper = new PropertiesHelper(getApplicationContext());

            LatLng location = helper.GetLocation();
            googleMap.addMarker(new MarkerOptions()
                    .position(location)
                    .title("LOCATIA 1"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
