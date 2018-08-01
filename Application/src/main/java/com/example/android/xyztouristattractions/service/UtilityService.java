
package com.example.android.xyztouristattractions.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.location.Location;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.android.xyztouristattractions.R;
import com.example.android.xyztouristattractions.Attraction;
import com.example.android.xyztouristattractions.Constants;
import com.example.android.xyztouristattractions.Utils;
import com.example.android.xyztouristattractions.provider.TouristAttractions;
import com.example.android.xyztouristattractions.ui.DetailActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.example.android.xyztouristattractions.provider.TouristAttractions.ATTRACTIONS;
import static com.google.android.gms.location.LocationServices.FusedLocationApi;
import static com.google.android.gms.location.LocationServices.GeofencingApi;

public class UtilityService extends IntentService {
    private static final String TAG = UtilityService.class.getSimpleName();

    public static final String ACTION_GEOFENCE_TRIGGERED = "geofence_triggered";
    private static final String ACTION_LOCATION_UPDATED = "location_updated";
    private static final String ACTION_REQUEST_LOCATION = "request_location";
    private static final String ACTION_ADD_GEOFENCES = "add_geofences";
    private static final String ACTION_FAKE_UPDATE = "fake_update";


    public static IntentFilter getLocationUpdatedIntentFilter() {
        return new IntentFilter(UtilityService.ACTION_LOCATION_UPDATED);
    }

    public static void addGeofences(Context context) {
        Intent intent = new Intent(context, UtilityService.class);
        intent.setAction(UtilityService.ACTION_ADD_GEOFENCES);
        context.startService(intent);
    }

    public static void requestLocation(Context context) {
        Intent intent = new Intent(context, UtilityService.class);
        intent.setAction(UtilityService.ACTION_REQUEST_LOCATION);
        context.startService(intent);
    }
    public UtilityService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent != null ? intent.getAction() : null;

        if (ACTION_REQUEST_LOCATION.equals(action)) {
            requestLocationInternal();
        } else if (ACTION_LOCATION_UPDATED.equals(action)) {
            locationUpdated(intent); } }

    /**
     * Called when a location update is requested
     */
    private void requestLocationInternal() {
        Log.v(TAG, ACTION_REQUEST_LOCATION);

        if (!Utils.checkFineLocationPermission(this)) {
            return;
        }

        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .build();

        // It's OK to use blockingConnect() here as we are running in an
        // IntentService that executes work on a separate (background) thread.
        ConnectionResult connectionResult = googleApiClient.blockingConnect(
                Constants.GOOGLE_API_CLIENT_TIMEOUT_S, TimeUnit.SECONDS);

        if (connectionResult.isSuccess() && googleApiClient.isConnected()) {

            Intent locationUpdatedIntent = new Intent(this, UtilityService.class);
            locationUpdatedIntent.setAction(ACTION_LOCATION_UPDATED);

            // Send last known location out first if available
            Location location = FusedLocationApi.getLastLocation(googleApiClient);
            if (location != null) {
                Intent lastLocationIntent = new Intent(locationUpdatedIntent);
                lastLocationIntent.putExtra(
                        FusedLocationProviderApi.KEY_LOCATION_CHANGED, location);
                startService(lastLocationIntent);
            }

            // Request new location
            LocationRequest mLocationRequest = new LocationRequest()
                    .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            FusedLocationApi.requestLocationUpdates(
                    googleApiClient, mLocationRequest,
                    PendingIntent.getService(this, 0, locationUpdatedIntent, 0));

            googleApiClient.disconnect();
        } else {
            Log.e(TAG, String.format(Constants.GOOGLE_API_CLIENT_ERROR_MSG,
                    connectionResult.getErrorCode()));
        }
    }

    /**
     * Called when the location has been updated
     */
    private void locationUpdated(Intent intent) {
        Log.v(TAG, ACTION_LOCATION_UPDATED);

        // Extra new location
        Location location =
                intent.getParcelableExtra(FusedLocationProviderApi.KEY_LOCATION_CHANGED);

        if (location != null) {
            LatLng latLngLocation = new LatLng(location.getLatitude(), location.getLongitude());

            // Store in a local preference as well
            Utils.storeLocation(this, latLngLocation);

            // Send a local broadcast so if an Activity is open it can respond
            // to the updated location
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }
}
