package ca.knowledgetranslation.dev.eaaps.beaconplayground;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "estimote";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "here we go");
        context.startService(new Intent(context, BeaconsMonitoringService.class));
        Log.d(TAG, "been called");
    }

}
