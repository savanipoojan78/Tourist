package com.example.android.xyztouristattractions;

import android.graphics.Bitmap;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

public class ResturentConstruction {
    public String name;
    public String description;
    public String longDescription;
    public int imageUrl;

    public LatLng location;
    public String city;

    public Bitmap image;
    public String distance;

    public ResturentConstruction(String name, String description, String longDescription, int imageUrl,
                      LatLng location, String city) {
        this.name = name;
        this.description = description;
        this.longDescription = longDescription;
        this.imageUrl = imageUrl;

        this.location = location;
        this.city = city;
    }
}
