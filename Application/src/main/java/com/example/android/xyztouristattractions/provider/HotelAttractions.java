package com.example.android.xyztouristattractions.provider;

import android.net.Uri;

import com.example.android.xyztouristattractions.App;
import com.example.android.xyztouristattractions.Attraction;
import com.example.android.xyztouristattractions.HotelConstruction;
import com.example.android.xyztouristattractions.R;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelAttractions {
    public static final String CITY_SYDNEY = "Sydney";
    public static final String CITY_India = "Dehli";

    public static final String TEST_CITY = CITY_SYDNEY;

    private static final float TRIGGER_RADIUS = 2000; // 2KM
    private static final int TRIGGER_TRANSITION = Geofence.GEOFENCE_TRANSITION_ENTER |
            Geofence.GEOFENCE_TRANSITION_EXIT;
    private static final long EXPIRATION_DURATION = Geofence.NEVER_EXPIRE;

    public static final Map<String, LatLng> CITY_LOCATIONS = new HashMap<String, LatLng>() {{
        put(CITY_SYDNEY, new LatLng(-33.873651, 151.2068896));
    }};


    public static final HashMap<String, List<HotelConstruction>> HotelATTRACTIONS =
            new HashMap<String, List<HotelConstruction>>() {{

                put(CITY_SYDNEY, new ArrayList<HotelConstruction>() {{
                    add(new HotelConstruction(App.getResourses().getString(R.string.regentaantarim),
                            App.getResourses().getString(R.string.regentaantarimdes),
                             R.drawable.regenta
                            ,new LatLng(23.0332706,72.4868186),
                            CITY_India,"4.3","₹3316"
                    ));
                    add(new HotelConstruction(App.getResourses().getString(R.string.ramadaplazapalm),
                            App.getResourses().getString(R.string.ramadaplazapalmdec),
                            R.drawable.ramada,
                            new LatLng(19.0986, 72.8268),
                            CITY_India,"4.1","₹8769"
                    ));

                    add(new HotelConstruction(App.getResourses().getString(R.string.rajasthanpalace),
                            App.getResourses().getString(R.string.rajasthanpalacedes),
                            R.drawable.rajasthan,
                            new LatLng(26.9008, 75.8209),
                            CITY_India,"4.0","₹1651"
                    ));

                }});

            }};

    /**
     * Creates a list of geofences based on the city locations
     */
    public static List<Geofence> getGeofenceList() {
        List<Geofence> geofenceList = new ArrayList<Geofence>();
        for (String city : CITY_LOCATIONS.keySet()) {
            LatLng cityLatLng = CITY_LOCATIONS.get(city);
            geofenceList.add(new Geofence.Builder()
                    .setCircularRegion(cityLatLng.latitude, cityLatLng.longitude, TRIGGER_RADIUS)
                    .setRequestId(city)
                    .setTransitionTypes(TRIGGER_TRANSITION)
                    .setExpirationDuration(EXPIRATION_DURATION)
                    .build());
        }
        return geofenceList;
    }

    public static String getClosestCity(LatLng curLatLng) {
        if (curLatLng == null) {
            // If location is unknown return test city so some data is shown
            return TEST_CITY;
        }

        double minDistance = 0;
        String closestCity = null;
        for (Map.Entry<String, LatLng> entry: CITY_LOCATIONS.entrySet()) {
            double distance = SphericalUtil.computeDistanceBetween(curLatLng, entry.getValue());
            if (minDistance == 0 || distance < minDistance) {
                minDistance = distance;
                closestCity = entry.getKey();
            }
        }
        return closestCity;
    }
}
