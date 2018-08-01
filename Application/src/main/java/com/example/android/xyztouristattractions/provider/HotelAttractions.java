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
                    add(new HotelConstruction("Dudhsagar Falls",
                            "3-streamed waterfall, named for its milky waters, with swimming pools surrounded by forest.",
                            "Dudhsagar Falls is a four-tiered waterfall located on the Mandovi River in the Indian state of Goa. It is 60 km from Panaji by road and is located on the Madgaon-Belgavi rail route about 46 km east of Madgaon and 80 km south of Belgavi.",
                            Uri.parse("https://lh3.googleusercontent.com/hnSntJsEP3PjYvmMM3D-FVeTQKxAKS3QUP5ComynT41VScEw8rT3WIqH3K7qcq5ze8l2MjC3krIcFncdCB8amgYE34PHkhfWk-Rf8XIW7J4A9PfXIS6JJ-ll9vqhyAdDwHB4p8IQo3j8OBHOG1r5Ku0bwiFyCKWgUjOLUtIqjoRhA2Gwg4evEcCPChTbbM-LNUxA1fzUNCwfXeshZvROCReXjBzKYo7HBJn3Eq-2CDK8O_Sbm0SEOW2qJ2v46ARPWBqQEZJCEuKSnq3kdqhNGT9zspaVPHKCfPzbgqzYgWUBEFzsPfwpal9mjvK_JYGqPBoa9itpuXKknozq-Czjzj_0aEcOjCg_KE-5tCMRhkAiC05CEsvDi7klf4XX2VvV5nCSunKD8T7AkMWPgsbyoJWg7qxu2UrLGrPtRPz4OK2tPZGYstlXedR8X2dQ3nZHSexm2DJYdrMAhNm4HTolvSv4NlUOXd2EihriMnWUHqsqygXOLdf6xoHumZbhuzTttOGrkvtDXoa7IwY5Fa5mgA-VJodS52XDPYMrIJcCGdJ0ZLPFxG5LqmLWI9Eq2HFch-_p0EureRDBLgc2ZJjPzTpp2YLGkfc25de370E=w247-h296-no"),
                            Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
                            new LatLng(15.3144, 74.3143),
                            CITY_India
                    ));
                    add(new HotelConstruction("Valley of Flowers National Park",
                            "Hiking trails cross this lush Himalayan valley, known for its bright alpine flora and rare animals.",
                            "Valley of Flowers National Park is an Indian national park, located in West Himalaya, in the state of Uttarakhand and is known for its meadows of endemic alpine flowers and the variety of flora.",
                            Uri.parse("https://lh3.googleusercontent.com/CgjlgMqgL9DvCZocoA1KqHweznixpfDE5Zvo3A8F9p20ERLlKm9yYr60xix2iUc6Cx-tFs3YcXlqpVdg31MEjR61Uf-1mWWZec1xB6mRquEWIH5pBYoX5A_yhLW9YsMSzMg0WOJSdtrfZb3wF-f-qfTrmlv5b6pg7jDTFOHatepWHDrDgfH_hJyFEGeAN5kwLN1MA_9ZwQJEagYBAWC6VIIIdfhV_MtTCwNsoIjgSCRLL3O6lDR_I1it8ml6WYJI0r2vq6a13HcdGxohnsNzO4u7Nixkmiq76QheLLSUhkt6D3v1dl0O6TTN2hBNqza24uETA_8xFH6rOXJsiW1kMohzBhmhZmNvqH6rJvCjPhXhUokULIXW8xPqo7Px_lOsBe7TZ5dRTsHipATPcs26nXC6xv3MVHDrIEQf1GroyhvJ4tzPoyPT9lhte5OR1YFNGRN9rVCERuSqKAo-QEHh8IkoAODiCz5sa9s0nQlATZ5aNuBKZIJ-tosmE-pLsf8kilF24w6z2Ea0SusSLlREKObmU8_varPgtq-L3rWL52L9agF-REQFJ2BurYvc8Xa074OHSCB47bgeEFy96LBtES1H36AVLIBE5lruX7Q=w500-h281-no"),
                            Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
                            new LatLng(30.7280, 79.6053),
                            CITY_India
                    ));
                    add(new HotelConstruction("Kumbhalgarh",
                            "15th-century, hilltop fort and UNESCO-listed site surrounded by a massive, 36km-long perimeter wall.",
                            "Kumbhalgarh fort is a Mewar fortress on the westerly range of Aravalli Hills, in the Rajsamand district near Udaipur of Rajasthan state in western India. It is a World Heritage Site included in Hill Forts of Rajasthan.",
                            Uri.parse("https://lh3.googleusercontent.com/oNcm58F9NLueIEzB_g7s2ZvbGbG_sWQ5LWhlR2xMrju6pvE2v_ej00-BGw0Xg9kNqERA8YYZIwQn239vUNLknvG9sGKzS9LXLWoieETom-o3elgb4GypG5SYoMQq0xtW5K9f9fWQ71_0wMiuo25jNxlrIDcNnA9QzsiTlleGxCvarFtfMCJOHLdKp9oXmihAfTW3Rh2UAnjra4i4ZX9rdSbmLzDQu-HpVdyC6zlmZk61L4HoLwgvKqhj3UJFLUUTObNGx8nbp72Cd-wlp41UsCunAf64rxA3jiJyxupzNWkJqKIA3aWU3SGbsYqjfR4n0auvElt-j2waTfFDODznG39AL-i5CubwSWLVrmHWJeSEjQe6aH9A0E-MW9JM0ZVUYlL-g9wTRsgccRULm3lcLtBn1vv9Cx90RuC5DjDNEjTgJbXTG6-SQu1eVxt9enDRaoSTAFouHrcMgbtPEYfiqTiyvWXW3vInECOlQZ6YP8OqOD2GHEhNffrK4-qoxd7KoIyNotDt-v3GCQTwHZBS5sFigoftwqdJrsFe31vlzmjmEjNSSJzJ1OBgPGdvJUWDy-Wwi-XbADxcsMYwyTg2glTgF4rFJbE_UZWwD88=w500-h262-no"),
                            Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
                            new LatLng(25.1528, 73.5870),
                            CITY_India
                    ));
                    add(new HotelConstruction("Konark Sun Temple",
                            "Ornately sculpted, 13th-century Hindu place of worship depicting the vast chariot of sun god, Surya.",
                            "Konark Sun Temple is a 13th-century CE sun temple at Konark about 35 kilometres northeast from Puri on the coastline of Odisha, India. The temple is attributed to king Narasimhadeva I of the Eastern Ganga Dynasty about 1250 CE.",
                            Uri.parse("https://lh3.googleusercontent.com/q3_N-LZrkPCSFIpRtyA_QeHjclXY4mVS-1Vpl-fPdWVEvF2fkXrfHpjteIQF0nwBfLE_oSKxMvDiM33W2reFKsbuVVV10H_0KKKzp1eZ2KSK85v8zNwxo_Fok5yrVhp0_sRELO7SIPRRf9K0hcMKDa5Zz55db9CzftryccS1KgyQfb6_Oe1aIOjA-AI9vIFFPJZgBGYY9ZCSn2yVPKpZNTcnppyiJD0J2suN87ub4xb9t-0u3SO0drQuJ8wYepA3kvwvvt1UxtKkz9Ff5u8H_gSIpPU1zvzMbeE29E1T5xmDlrn6VyniBlpfCrI3LAsVAQpkC3CPWOB_XCDkcfx5x1SRwB7UYVlVzcDv75FygtcK3lWywt_lX4xfDD8auKNasTAD2sZJodiHFnLCZhzlQ4EdCtDHqOnWnidhmoVGJUcWZzyOMbY9k2a9PzmMa5yt44ACFSAvvZSWUrm99rSUocal84CGCHte4F-UY_h0VHihxZkQlja0DqfEXFWMvZlY8dD_NJr1TYwyYwLqMqF_gDWHSAQJ_xzzRt7RvhBn6D1dN2RlpxPmoxWj99JADjtKMYzHNOS1fZdZ6NjoevejscP4Sv8AVyEhCAev-Mc=w444-h296-no"),
                            Uri.parse("https://lh3.googleusercontent.com/GofeZs8vybume2q6VanKX-FyeRR3uBwqA1N2uH1C6Tsqo5n-jYHnGrJf2B7jYopTmuyXK6-Uz7QgwE1gw722_W8vXQ9tsLbBFscOjPpbsYgOu-2UoK1kPDlK4zVeeQNKVMFzRJAKaX_F8TJxSiJDk7lspirwMK5sW2c39N7BVg10usqj0kJDgUUmiiJn8yt58PTfUb33_EOsZlw08kNxYTklWY8KMUt_3ykvfD0DbVIsYM7gZJNf5ZVhUuznPViXpMmPpjbLh2PrYRWIz2NefSEFfenqvMA_6PQOR__073pDTPXeGzVEQqAwaP2bIwqpahqvCFoOY-K1FMF4S1E5iQCUYrY1s2TqCrH4dh-301_cRpxtjbxqZC145k37wSyLOhpiL7feEHY49jUZoAEikShjmYAfX_UlFHzh2WQjB3QSVU1B2pSD4ukBNemZhoRJaBr8xlfknOZP4sEHdfFGxfbyCI321QmDfstQOhuDPsCYwlo-JNzteU8ojYel_l23JTuvD120_Q-NeJ3pfgY5sOIcdz3gcUTIUN6sCc_t_EMJLj_yX9Wsmmi99S8Q5u1TaidGLDy_GpimtlwBaWPKoUrOOKlKIv0Qr5ZnCIU=w284-h178-no"),
                            new LatLng(19.8876, 86.0945),
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
