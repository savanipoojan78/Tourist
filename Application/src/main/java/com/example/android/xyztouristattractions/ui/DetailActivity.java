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

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.android.xyztouristattractions.Constants;
import com.example.android.xyztouristattractions.HotelConstruction;
import com.example.android.xyztouristattractions.R;

import java.util.List;
import java.util.Map;

import static com.example.android.xyztouristattractions.provider.HotelAttractions.HotelATTRACTIONS;

/**
 * The tourist attraction detail activity screen which contains the details of
 * a single attraction.
 */
public class DetailActivity extends AppCompatActivity {
    private BottomNavigationView nav;
    private Hotel hotel;
    private static final String EXTRA_ATTRACTION = "attraction";

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void launch(Activity activity, String attraction, View heroView) {
        Intent intent = getLaunchIntent(activity, attraction);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, heroView, heroView.getTransitionName());
        ActivityCompat.startActivity(activity, intent, options.toBundle());

    }

    public static Intent getLaunchIntent(Context context, String attraction) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_ATTRACTION, attraction);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotel = new Hotel();
        nav = (BottomNavigationView) findViewById(R.id.bottomnav);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_place:
                        Intent i = new Intent(DetailActivity.this, AttractionListActivity.class);
                        startActivity(i);
                        return true;
                    case R.id.menu_hotel:
                        Intent j = new Intent(DetailActivity.this, AttractionListActivity.class);
                        startActivity(j);
                        return true;
                    case R.id.menu_restaurent:
                        Intent k = new Intent(DetailActivity.this, AttractionListActivity.class);
                        startActivity(k);
                        return true;
                    default:
                        return false;
                }
            }
        });

        String attraction = getIntent().getStringExtra(EXTRA_ATTRACTION);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, DetailFragment.createInstance(attraction))
                    .commit();
        }
    }

}

