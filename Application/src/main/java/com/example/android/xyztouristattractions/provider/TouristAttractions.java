

package com.example.android.xyztouristattractions.provider;

import com.example.android.xyztouristattractions.Attraction;
import com.example.android.xyztouristattractions.R;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.android.xyztouristattractions.App;


/**
 * Static data content provider.
 */
public class TouristAttractions {



    public static final String CITY_India = "Dehli";

    public static final String TEST_CITY = CITY_India;

    private static final float TRIGGER_RADIUS = 2000; // 2KM
    private static final int TRIGGER_TRANSITION = Geofence.GEOFENCE_TRANSITION_ENTER |
            Geofence.GEOFENCE_TRANSITION_EXIT;
    private static final long EXPIRATION_DURATION = Geofence.NEVER_EXPIRE;

    public static final Map<String, LatLng> CITY_LOCATIONS = new HashMap<String, LatLng>() {{
        put(CITY_India, new LatLng(-33.873651, 151.2068896));
    }};


    public static final HashMap<String, List<Attraction>> ATTRACTIONS =
            new HashMap<String, List<Attraction>>() {{


                put(CITY_India, new ArrayList<Attraction>() {{
                    add(new Attraction( App.getResourses().getString(R.string.tajmahel),
                    App.getResourses().getString(R.string.tajmaheldes),
                    App.getResourses().getString(R.string.tajmaellong),
                    R.drawable.taj_mahal,
                    new LatLng(27.1750, 78.0422),
                    CITY_India
                    ));
            add(new Attraction(App.getResourses().getString(R.string.somnath),
                    App.getResourses().getString(R.string.somnathdes),
                    App.getResourses().getString(R.string.somnathlong),
                    R.drawable.somnath,
                    new LatLng(20.8880, 70.4012),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.adalaj),
                    App.getResourses().getString(R.string.adalajdes),
                    App.getResourses().getString(R.string.adalajlong),
                    R.drawable.adalaj,new LatLng(23.1667, 72.5801),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.Akshardham),
                    App.getResourses().getString(R.string.Akshardhamdes),
                    App.getResourses().getString(R.string.Akshardhamlong),
                    R.drawable.akshardham,new LatLng(23.2310, 72.6741),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.theredfort),
                    App.getResourses().getString(R.string.theredforelong),
                    App.getResourses().getString(R.string.theredforelong),
                    R.drawable.red_fort,new LatLng(28.6562, 77.2410),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.elloracaves),
                    App.getResourses().getString(R.string.elloracavesdes),
                    App.getResourses().getString(R.string.elloracaveslong),
                    R.drawable.ellora,new LatLng(20.0269, 75.1772),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.goldentemple),
                    App.getResourses().getString(R.string.goldentempledes),
                    App.getResourses().getString(R.string.goldentemplelong),
                    R.drawable.golden_temple,new LatLng(31.6200, 74.8765),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.qutbminar),
                    App.getResourses().getString(R.string.qutbminardes),
                    App.getResourses().getString(R.string.qutbminarlong),
                    R.drawable.qutb,new LatLng(28.5244, 77.1855),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.ranthamborenationalpark),
                    App.getResourses().getString(R.string.ranthamborenationalparkdes),
                    App.getResourses().getString(R.string.ranthamborenationalparklong),
                    R.drawable.ranthambore
                    ,new LatLng(26.0173, 76.5026),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.amerfort),
                    App.getResourses().getString(R.string.amerfortdes),
                    App.getResourses().getString(R.string.amerfortlong),
                    R.drawable.amber_fort,new LatLng(26.9855, 75.8513),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.hawamahal),
                    App.getResourses().getString(R.string.hawamahaldes),
                    App.getResourses().getString(R.string.hawamahallong),
                    R.drawable.hawa_mahal
                    ,new LatLng(26.9239, 75.8267),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.citypalacejaipur),
                    App.getResourses().getString(R.string.citypalacejaipurdes),
                    App.getResourses().getString(R.string.citypalacejaipurlong),
                    R.drawable.city_palace,new LatLng(26.9258, 75.8237),
            CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.indiagate),
                    App.getResourses().getString(R.string.indiagatedes),
                    App.getResourses().getString(R.string.indiagatelong),
                    R.drawable.india_gate
                    ,new LatLng(28.6129, 77.2295),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.agrafort),
                    App.getResourses().getString(R.string.agrafortdes),
                    App.getResourses().getString(R.string.agrafortlong),
                    R.drawable.agra,new LatLng(27.1795, 78.0211),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.jimcorbettnationalpark),
                    App.getResourses().getString(R.string.jimcorbettnationalparkdes),
                    App.getResourses().getString(R.string.jimcorbettnationalparklong),
                    R.drawable.jim_corbett,new LatLng(29.5300, 78.7747),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.jamamasjiddelhi),
                    App.getResourses().getString(R.string.jamamasjiddelhides),
                    App.getResourses().getString(R.string.jamamasjiddelhilong),
                    R.drawable.jama_masjid_4,new LatLng(28.6507, 77.2334),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.rohtangpass),
                    App.getResourses().getString(R.string.rohtangpassdes),
                    App.getResourses().getString(R.string.rohtangpasslong),
                    R.drawable.rohtang,new LatLng(32.3716, 77.2466),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.gatewayofindia),
                    App.getResourses().getString(R.string.gatewayofindiades),
                    App.getResourses().getString(R.string.gatewayofindialong),
                    R.drawable.gate_way_of_india
                    ,new LatLng(18.9220, 72.8347),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.mehrangarh),
                    App.getResourses().getString(R.string.mehrangarhdes),
                    App.getResourses().getString(R.string.mehrangarhlong),
                    R.drawable.mehrangarh
                    ,new LatLng(26.2981, 73.0184),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.jantarmantarjaipur),
                    App.getResourses().getString(R.string.jantarmantarjaipurdes),
                    App.getResourses().getString(R.string.jantarmantarjaipurlong),
                    R.drawable.jantar_mantar,new LatLng(26.9248, 75.8246),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.ajantacaves),
                    App.getResourses().getString(R.string.ajantacavesdes),
                    App.getResourses().getString(R.string.ajantacaveslong),
                    R.drawable.ajanta,new LatLng(20.5519, 75.7033),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.periyarnationalpark),
                    App.getResourses().getString(R.string.periyarnationalparkdes),
                    App.getResourses().getString(R.string.periyarnationalparklong),
                    R.drawable.periyar,new LatLng(9.4622, 77.2368),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.meenakshiammantemple),
                    App.getResourses().getString(R.string.meenakshiammantempledes),
                    App.getResourses().getString(R.string.meenakshiammantemplelong),
                    R.drawable.meenakshi
                    ,new LatLng(9.9195, 78.1193),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.lotustemple),
                    App.getResourses().getString(R.string.lotustempledes),
                    App.getResourses().getString(R.string.lotustemplelong),
                    R.drawable.lotus,new LatLng(28.5535, 77.2588),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.jalmahal),
                    App.getResourses().getString(R.string.jalmahaldes),
                    App.getResourses().getString(R.string.jalmahallong),
                    R.drawable.jal_mahal_jaipur,new LatLng(26.9535, 75.8462),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.elephantacaves),
                    App.getResourses().getString(R.string.elephantacavesdes),
                    App.getResourses().getString(R.string.elephantacaveslong),
                    R.drawable.elephanta
                    ,new LatLng(18.9633, 72.9315),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.tombofitimādudDaulah),
                    App.getResourses().getString(R.string.tombofitimādudDaulahdes),
                    App.getResourses().getString(R.string.tombofitimādudDaulahlong),
                    R.drawable.tomb_of_i
                    ,new LatLng(27.1929, 78.0310),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.jaisalmerfort),
                    App.getResourses().getString(R.string.jaisalmerfortdes),
                    App.getResourses().getString(R.string.jaisalmerfortlong),
                    R.drawable.jaisalmer_fort,new LatLng(26.9128, 70.9131),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.jaigarhfort),
                    App.getResourses().getString(R.string.jaigarhfortdes),
                    App.getResourses().getString(R.string.jaigarhfortlong),
                    R.drawable.jaigarh,new LatLng(26.9851, 75.8456),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.dudhsagarfalls),
                    App.getResourses().getString(R.string.dudhsagarfallsdes),
                    App.getResourses().getString(R.string.dudhsagarfallslong),
                    R.drawable.dudhsagar,
                    new LatLng(15.3144, 74.3143),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.valleyofflowersnationalpark),
                    App.getResourses().getString(R.string.valleyofflowersnationalparkdes),
                    App.getResourses().getString(R.string.valleyofflowersnationalparklong),
                    R.drawable.valley_flowers,new LatLng(30.7280, 79.6053),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.kumbhalgarh),
                    App.getResourses().getString(R.string.kumbhalgarhdes),
                    App.getResourses().getString(R.string.kumbhalgarhlong),
                    R.drawable.kumbhalgarh,
                    new LatLng(25.1528, 73.5870),
                    CITY_India
            ));
            add(new Attraction(App.getResourses().getString(R.string.konarksuntemple),
                    App.getResourses().getString(R.string.konarksuntempledes),
                    App.getResourses().getString(R.string.konarksuntemplelong),
                    R.drawable.konark
                    ,new LatLng(19.8876, 86.0945),
                    CITY_India
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
        for (Map.Entry<String, LatLng> entry : CITY_LOCATIONS.entrySet()) {
            double distance = SphericalUtil.computeDistanceBetween(curLatLng, entry.getValue());
            if (minDistance == 0 || distance < minDistance) {
                minDistance = distance;
                closestCity = entry.getKey();
            }
        }
        return closestCity;
    }
}
