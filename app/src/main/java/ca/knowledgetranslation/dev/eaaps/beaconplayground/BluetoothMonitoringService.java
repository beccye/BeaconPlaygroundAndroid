package ca.knowledgetranslation.dev.eaaps.beaconplayground;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
/**
 * Created by nikolas on 14-11-21.
 */
public class BluetoothMonitoringService extends Service {
    private static final String TAG = "estimote";
    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onCreate() {
        // Configure BeaconManager.
        Log.d(TAG, "Bluetooth changed");
        Toast.makeText(this, "Bluetooth changed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Bluetooth destroyed");
        Toast.makeText(this, "Bluetooth destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Bluetooth monitoring");
        Toast.makeText(this, "Bluetooth monitoring", Toast.LENGTH_SHORT).show();

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

}
