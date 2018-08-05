package com.example.android.xyztouristattractions.provider;

import android.net.Uri;

import com.example.android.xyztouristattractions.Attraction;
import com.example.android.xyztouristattractions.HotelConstruction;
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
                    add(new HotelConstruction("Hotel Kanchan Palace",
                            "Hiii arsc sgxvdujcd ","Dudhsagar Falls is a four-tiered waterfall located on the Mandovi River in the Indian state of Goa. It is 60 km from Panaji by road and is located on the Madgaon-Belgavi rail route about 46 km east of Madgaon and 80 km south of Belgavi.",
                            Uri.parse("https://lh3.googleusercontent.com/hnSntJsEP3PjYvmMM3D-FVeTQKxAKS3QUP5ComynT41VScEw8rT3WIqH3K7qcq5ze8l2MjC3krIcFncdCB8amgYE34PHkhfWk-Rf8XIW7J4A9PfXIS6JJ-ll9vqhyAdDwHB4p8IQo3j8OBHOG1r5Ku0bwiFyCKWgUjOLUtIqjoRhA2Gwg4evEcCPChTbbM-LNUxA1fzUNCwfXeshZvROCReXjBzKYo7HBJn3Eq-2CDK8O_Sbm0SEOW2qJ2v46ARPWBqQEZJCEuKSnq3kdqhNGT9zspaVPHKCfPzbgqzYgWUBEFzsPfwpal9mjvK_JYGqPBoa9itpuXKknozq-Czjzj_0aEcOjCg_KE-5tCMRhkAiC05CEsvDi7klf4XX2VvV5nCSunKD8T7AkMWPgsbyoJWg7qxu2UrLGrPtRPz4OK2tPZGYstlXedR8X2dQ3nZHSexm2DJYdrMAhNm4HTolvSv4NlUOXd2EihriMnWUHqsqygXOLdf6xoHumZbhuzTttOGrkvtDXoa7IwY5Fa5mgA-VJodS52XDPYMrIJcCGdJ0ZLPFxG5LqmLWI9Eq2HFch-_p0EureRDBLgc2ZJjPzTpp2YLGkfc25de370E=w247-h296-no"),
                            Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
                            new LatLng(15.3144, 74.3143),
                            CITY_India,"3.5","₹4000"
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
