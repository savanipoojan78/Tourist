

package com.example.android.xyztouristattractions;

import android.graphics.Bitmap;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

/**
 * A simple shared tourist attraction class to easily pass data around. Used
 * in both the mobile app and wearable app.
 */
public class Attraction {
    public String name;
    public String description;
    public String longDescription;
    public int imageUrl;
    public LatLng location;
    public String city;

    public Bitmap image;
    public Bitmap secondaryImage;
    public String distance;

    public Attraction(String name, String description, String longDescription, int imageUrl, LatLng location, String city) {
        this.name = name;
        this.description = description;
        this.longDescription = longDescription;
        this.imageUrl = imageUrl;
        this.location = location;
        this.city = city;
    }
}