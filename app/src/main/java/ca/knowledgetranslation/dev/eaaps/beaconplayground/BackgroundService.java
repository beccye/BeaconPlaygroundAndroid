package ca.knowledgetranslation.dev.eaaps.beaconplayground;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

public class BackgroundService extends IntentService {
    private static final String ESTIMOTE_PROXIMITY_UUID = "B9407F30-F5F8-466E-AFF9-25556B57FE6D";
    private static final String TAG = "estimote";
    private static final Region ALL_ESTIMOTE_BEACONS = new Region("rid", ESTIMOTE_PROXIMITY_UUID, null, null);
    private BeaconManager beaconManager;
    private String lastText = "";

    public BackgroundService() {
        super("BackgroundService");
    }

	 public int onStartCommand(Intent intent, int flags, int startId) 
	 {
	     super.onStartCommand(intent,flags,startId);
         return START_STICKY;
	 }

	@Override
	protected void onHandleIntent(Intent intent) {


        AndroidWorkshopApplication app = (AndroidWorkshopApplication)getApplication();
        beaconManager = app.getBeaconManager();

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override public void onServiceReady() {
                try {
                    Log.d(TAG, "serviceReady");
                    beaconManager.startMonitoring(ALL_ESTIMOTE_BEACONS);
                } catch (RemoteException e) {
                    Log.e(TAG, "Cannot start ranging", e);
                }
            }
        });
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
        Log.d(TAG, "Ok here goes");
        Toast.makeText(this, "Here Goes", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}