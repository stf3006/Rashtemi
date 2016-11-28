package com.example.alex.rashtemirestaurant;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Rares on 28.11.2016.
 */

public class PropertiesHelper {
    private String filename;
    private Context context;
    private Properties properties;
    private AssetManager assetManager;
    private InputStream inputStream;

    public PropertiesHelper(Context context) throws IOException {
        filename = "rashtemi.properties";
        properties = new Properties();
        assetManager = context.getAssets();
        inputStream = assetManager.open(filename);
        properties.load(inputStream);
    }

    public LatLng GetLocation() {
        double lat = Double.parseDouble(properties.getProperty("lat"));
        double lng = Double.parseDouble(properties.getProperty("lon"));

        return new LatLng(lat, lng);
    }
}
