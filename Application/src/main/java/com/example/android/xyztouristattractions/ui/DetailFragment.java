/*
 * Copyright 2015 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.xyztouristattractions.ui;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.android.xyztouristattractions.HotelConstruction;
import com.example.android.xyztouristattractions.R;
import com.example.android.xyztouristattractions.Attraction;
import com.example.android.xyztouristattractions.Constants;
import com.example.android.xyztouristattractions.Utils;
import com.example.android.xyztouristattractions.splash_screen;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.example.android.xyztouristattractions.provider.TouristAttractions.ATTRACTIONS;
import static com.example.android.xyztouristattractions.provider.HotelAttractions.HotelATTRACTIONS;

/**
 * The tourist attraction detail fragment which contains the details of a
 * a single attraction (contained inside
 * {@link com.example.android.xyztouristattractions.ui.DetailActivity}).
 */
public class DetailFragment extends Fragment {

    private static final String EXTRA_ATTRACTION = "attraction";
    private static final String EXTRA_HOTEL = "hotel";
    private Attraction mAttraction;
    private TextToSpeech tts;


    public static DetailFragment createInstance(String attractionName) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_ATTRACTION, attractionName);
        detailFragment.setArguments(bundle);
        return detailFragment;

    }

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        String attractionName = getArguments().getString(EXTRA_ATTRACTION);

        mAttraction = findAttraction(attractionName);


        if (mAttraction == null) {
            getActivity().finish();
            return null;
        }


        TextView nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        TextView descTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        TextView distanceTextView = (TextView) view.findViewById(R.id.distanceTextView);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        FloatingActionButton mapFab = (FloatingActionButton) view.findViewById(R.id.mapFab);
        ImageView play = (ImageView) view.findViewById(R.id.play);

        LatLng location = Utils.getLocation(getActivity());
        String distance = Utils.formatDistanceBetween(location, mAttraction.location);
        if (TextUtils.isEmpty(distance)) {
            distanceTextView.setVisibility(View.GONE);
        }

        nameTextView.setText(attractionName);
        distanceTextView.setText(distance);
        descTextView.setText(mAttraction.longDescription);

        int imageSize = getResources().getDimensionPixelSize(R.dimen.image_size)
                * Constants.IMAGE_ANIM_MULTIPLIER;
        Glide.with(getActivity())
                .load(mAttraction.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.lighter_gray)
                .override(imageSize, imageSize)
                .into(imageView);

        mapFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Constants.MAPS_INTENT_URI +
                        Uri.encode(mAttraction.name + ", " + mAttraction.city)));
                startActivity(intent);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {


                    @Override
                    public void onInit(int status) {


                        tts.setLanguage(new Locale("en", "IN"));
                        speak(mAttraction.longDescription);


                    }

                });

            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
//        if(tts==null)
//        {
//        }
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Some small additions to handle "up" navigation correctly
                Intent upIntent = NavUtils.getParentActivityIntent(getActivity());
                upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


                // Otherwise let the system handle navigating "up"
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Really hacky loop for finding attraction in our static content provider.
     * Obviously would not be used in a production app.
     */
    private Attraction findAttraction(String attractionName) {
        for (Map.Entry<String, List<Attraction>> attractionsList : ATTRACTIONS.entrySet()) {
            List<Attraction> attractions = attractionsList.getValue();
            for (Attraction attraction : attractions) {
                if (attractionName.equals(attraction.name)) {
                    return attraction;
                }
            }
        }
        return null;
    }


    private void speak(String s) {
        if (Build.VERSION.SDK_INT >= 21) {
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
        }
    }




}
