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
                    add(new HotelConstruction("Regenta Antarim",
                            "Free breakfast   \n" +
                                    "Air-conditioned   \n" +
                                    "Laundry service   \n" +
                                    "Business centre   \n" +
                                    "Pet-friendly   \n" +
                                    "Room service ","Dudhsagar Falls is a four-tiered waterfall located on the Mandovi River in the Indian state of Goa. It is 60 km from Panaji by road and is located on the Madgaon-Belgavi rail route about 46 km east of Madgaon and 80 km south of Belgavi.",
                            Uri.parse("https://lh3.googleusercontent.com/HZPkUYTvLIQYT1gbIP2yKNvE6i9Qiqi9-UWOBY4WbwqvUD-FvtUIFr18VgEkXj-Xgv_652fAiKLNbpOjg3KL9R9ICpnBGWp7AiezlC0CGUtMHCP_LICeIBEOjsICoERzqLAI8qtKaZLk1-Ce3YvOWxwSxWhjhGA2Ram94mW6tBlWsnMaltTxxvmYocQ6Ae5M7LjwaTWBvQGkBW4t8UWA5Jv5ECntsCBVdIBbKS4cDNLNZNOZlOh5_GJzMcMP1Loc_Uhu0vh3hdgs3ELnkH1DKAYSg5upFHrPUP-Zat6Zea__fV4y92JwtR-_6WUvpLjd811JW54dYbRMmnBI8qygiFeMaXsPPrwSkKqqhdoWLsz13IA30Utd8-m2f6ffPr2vb4AxuV6-oxYSqvJm9cneL8edy_7gpOLiPLjgSd2_TiVfJhdDx66rQBu83ovyDx0oEzRpPooPYNpKPxyX6kmaQpi8Cfno9GBQTwGY2IZz6jW6yhkgmaU45slBoERqVd0df2AB5CETcqs-L2vJyM0LYdxDY7EczrMGz6qZnApeLWJy_7Nfhg_-vI-C9TzeUNjz3x868wVbNunTvbgc2Yq49RH8-mytJ6tTwEzgJa4=w603-h730-no"),Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
                            new LatLng(23.0332706,72.4868186),
                            CITY_India,"4.3","₹3316"
                    ));
                    add(new HotelConstruction("Ramada Plaza Palm",
                            "Free breakfast   \n" +
                                    "Outdoor pool   \n" +
                                    "Air-conditioned   \n" +
                                    "Laundry service","Dudhsagar Falls is a four-tiered waterfall located on the Mandovi River in the Indian state of Goa. It is 60 km from Panaji by road and is located on the Madgaon-Belgavi rail route about 46 km east of Madgaon and 80 km south of Belgavi.",
                            Uri.parse("https://lh3.googleusercontent.com/Rs6DliFdfDtBltXVgNqyVvouzdSl4iaS061kEMTgwNSEu33hFIXDmoZ_RJchkeXqU1p4wOppjTOHO9Sf3LOfzRRVDIlQXsf-HO1Xu4S0N-nccGokDTKAe7TSIuLU8WReKarQeK1RySmgVlfHeDrgCVGZDG-SGba3hphX6UbKaxaemmBXIw78pPXVuOskxbHZtBBEO6eMW_Md93VGDJySrTRwZAyKu2_dVww5FKvR9WLqXFZHSjViu1WkLK9ZRS-JMwC4UjH0mDXsPeiCW7YValav7nENRzjI-tqTcfj5BO0Wg9FppE_VD8GvSqz6BNQ_vCueZWUiJ40wWVGeUQoD-R3b3Kfyy7AAZJdUIZVWT4Isa_mLxxcMfyyNZut163fSYHq9RqTS0U495utPSrVo8AortVUuKYQYptiUyaXv6krtuURZb8XfM019hglKbRvAC9DlOSfGm6cEXWgEhF56axy7ZaDzTcagDylv50g6DZaXfpxvAdS6NaeOT7A2mGcEeDuEA9Ozwutb0pjal_cBlU8f6gw-YaGuEgjEPkqxBHwDgFrdPqp6VlUWwD886H-7rHKTi2XJCglRSu18N_ksfZa1B0ml120zkKMTmWc=w550-h321-no"),
                            Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
                            new LatLng(19.0986, 72.8268),
                            CITY_India,"4.1","₹8769"
                    ));

                    add(new HotelConstruction("Rajasthan Palace",
                            "Laundry service   \n" +
                                    "Business centre   \n" +
                                    "Room service   \n" +
                                    "Child friendly","Dudhsagar Falls is a four-tiered waterfall located on the Mandovi River in the Indian state of Goa. It is 60 km from Panaji by road and is located on the Madgaon-Belgavi rail route about 46 km east of Madgaon and 80 km south of Belgavi.",
                            Uri.parse("https://lh3.googleusercontent.com/xIVdBi4Dx8sV3JrQ35hId6tzMxDHbYTlKoB7npyGk3a68BHTe_9SDp_2WTLUelrsnqb6G3HYnOYkKbvDG_YA_miAuGaPcOkzlcX8htUHUc8r1l2Um7cmR2OjyEsF6ac_4kBzOT1eEUccHCn7qzJUANEPwYYr0yiy66bPcvIgt1sQHJ3-3Lym2-8OEjcFcaMadhBNGcdQyWzhOpYI_0y5Egy1KwSWndV6XFsBqN4Pey0Zhk-1xaLwsU0eT61zGZoNProAuMwBSSmt2EXhbE4yG_RUU0c_dW5_uCzGXrgI0zaeQUd6AVwzXmgCbUX8eSgVxYNxWI-gda7NjkVOz1Luf08RyTdo6UPIa9BBHCfKmpZgwAoGpkEfDZj9r3hKv5_u6nyQ2nsQ1Xjt2qfbNLspRlxxHwoASST8cGrSxq_7Nl6N6VZGuFTQ05B6cumHwdPUrwDEYIEZvRfuvxNCtQ-CdDQrl093gccoeLB2JAZs05C7o0rpwa8Y8sFLvIIcGQbt3HaQAIuUlUjNH7BGu0W78NOK1_bk-oQAGkg8sQ3928uERmJWQQY7fi64WICGb-31wEeoo0zeq34wq6h2O1r3kbCvN1kVEVJQsy0v_RA=w408-h272-no"),
                            Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
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
