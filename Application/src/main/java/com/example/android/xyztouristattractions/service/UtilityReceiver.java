

package com.example.android.xyztouristattractions.service;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class UtilityReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        intent.setClass(context, UtilityService.class);
        intent.setAction(UtilityService.ACTION_GEOFENCE_TRIGGERED);
        startWakefulService(context, intent);
    }

}
