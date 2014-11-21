package ca.knowledgetranslation.dev.eaaps.beaconplayground;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by nikolas on 14-11-21.
 */
public class BluetoothStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
            if (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1) == BluetoothAdapter.STATE_OFF) {
                context.stopService(new Intent(context, BeaconsMonitoringService.class));
            } else {
                context.startService(new Intent(context, BeaconsMonitoringService.class));
            }
        }
    }
}
