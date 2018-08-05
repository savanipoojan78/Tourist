package com.example.android.xyztouristattractions.provider;

import android.net.Uri;

import com.example.android.xyztouristattractions.ResturentConstruction;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResturentAttractions {
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


    public static final HashMap<String, List<ResturentConstruction>> ResturentATTRACTIONS =
            new HashMap<String, List<ResturentConstruction>>() {{

                put(CITY_SYDNEY, new ArrayList<ResturentConstruction> () {{
                    add(new ResturentConstruction(
                            "Havmor Restaurant",
                            "Open since 2003, this homegrown curry house serves street food and traditional snacks and sweets.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae bibendum justo, vitae cursus velit. Suspendisse potenti. Suspendisse scelerisque risus justo, non tincidunt nibh blandit et. Vivamus elit lacus, luctus nec erat in, pharetra semper turpis. Quisque viverra nulla ligula, non pulvinar ante dictum sit amet. Vestibulum aliquet tortor mauris, vel suscipit nisl malesuada eget. Aliquam maximus dictum euismod. Maecenas leo quam, volutpat id diam eget, placerat fringilla ipsum. Nam pretium vehicula augue quis euismod.\n\nNam sed blandit magna. Vestibulum a fermentum arcu. Vestibulum et ligula at nisi luctus facilisis. Proin fermentum enim a nibh commodo finibus. Suspendisse justo elit, vulputate ut ipsum at, pellentesque auctor massa. Praesent vestibulum erat interdum imperdiet dapibus. In hac habitasse platea dictumst. Proin varius orci vitae tempor vulputate.\n\nEtiam sed mollis orci. Integer et ex sed tortor scelerisque blandit semper id libero. Nulla facilisi. Pellentesque tempor magna eget massa ultrices, et efficitur lectus finibus.",
                            Uri.parse("https://lh3.googleusercontent.com/BZ-c0lbjHt309gxfYa_VGx9lQ7qza5u_Dlb0SUKA1tE0hhxc7RuvU_SE6_vkthYRr_Jy-p2-Ry0EZC1KoK5GuRiPJ4zq5tXZ0pk7S3iNzepb0PwWPeUIvqrriW_SKl_Q74FMonXyFsx_qs-7qZKrAHRnU_OlyJKHuxlXRAeS_kaTAjKwNLkcS3ASKYecXim_y6HxTym2Bg0DxiWLAd7CK5PDARH_JNIYjH1-vuWXw-4GKYw-kc43zUUp8GNOHJEWoZ5CojZaYKFRB0D1131elY3WhRwbYRIHlZcCyUzSCkvwUCp8np6XM-Pz_0H7RBznYixRxhvG16rE3cc3bq_WMWERS02uWxON9U79XBVyEjQZOTY5VOSkd-79Vz-wW4hQWqsdsdGUVG6KqdA3nr1yPfDoZ5jl0mKD4SImRW5DV1tX1iUe2fXs6C_Jxc4Qi9x3jVGydvp75rv3IQF-6Z8q_5UW_-tpfRp3ROo-FP1RFDWfl0IGQNJ0Cru7bbn4PRqdWjWXe5nYXK6SDaTutqxdjYKE-4_x8rU3rKgILr-cpwpnJZExFCOJjnaeqQUUgnN4hzdfQg1j7DJxYoYrb3IHXKQsplzC-41b1XO3kHw=w550-h374-no"), Uri.parse("https://lh3.googleusercontent.com/-EFEw6s7mT6I/VGLkCH4Xt4I/AAAAAAAAADY/ZlznhaQvb8E/w600-no/DSC_2775.JPG"),
                            new LatLng(23.0376, 72.5658),
                            "Ahmedabad"
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
