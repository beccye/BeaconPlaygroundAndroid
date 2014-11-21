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
         Log.d(TAG, "Received start id " + startId + ": " + intent);

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
                    //beaconManager.startRanging(ALL_ESTIMOTE_BEACONS);
                    beaconManager.startMonitoring(ALL_ESTIMOTE_BEACONS);
                } catch (RemoteException e) {
                    Log.e(TAG, "Cannot start ranging", e);
                }
            }
        });
        /*
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override public void onEnteredRegion(Region region, List<Beacon> beacons) {
                Log.d(TAG, "entered");
                Toast.makeText(BackgroundService.this, "Entered", Toast.LENGTH_LONG).show();
                Notification noti = new Notification.Builder(BackgroundService.this)
                        .setContentTitle("Entered")
                        .setContentText("You're home!")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .build();

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.cancel(2);
                mNotificationManager.notify(1, noti);
            }
            @Override public void onExitedRegion(Region region) {
                Log.d(TAG, "exited");
                Toast.makeText(BackgroundService.this, "Exited", Toast.LENGTH_LONG).show();
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.cancel(1);

                Notification noti = new Notification.Builder(BackgroundService.this)
                        .setContentTitle("Exited")
                        .setContentText("See you!")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .build();

                mNotificationManager.notify(2, noti);
            }
        });
        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> beacons) {
                Log.d(TAG, "beacons discovered");
                //Toast.makeText(BackgroundService.this, "Beacons Discovered", Toast.LENGTH_LONG).show();
                if (beacons.size() != 0) {
                    String contentText = "Power "
                            + beacons.get(0).getMeasuredPower()
                            + " distance "
                            + Utils.computeProximity(
                            beacons.get(0)).name();
                    if (!lastText.equals(contentText)) {
                        Notification noti = new Notification.Builder(BackgroundService.this)
                                .setContentTitle("Beacon found!")
                                .setContentText(contentText)
                                .setSmallIcon(R.drawable.ic_launcher)
                                .build();

                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        mNotificationManager.notify(1, noti);
                    }
                } else {
                    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    mNotificationManager.cancel(1);
                }
            }
        });
        */
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
        Log.d(TAG, "Ok here goes");
        Toast.makeText(this, "Here Goes", Toast.LENGTH_LONG).show();
        /*

        Notification noti = new Notification.Builder(BackgroundService.this)
                .setContentTitle("Search beacon...")
                .setContentText("Search beacon...")
                .setSmallIcon(R.drawable.ic_launcher)
                .build();
		
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, noti);
		*/
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		try {
			//beaconManager.stopRanging(ALL_ESTIMOTE_BEACONS);
		} catch (Error e) {
			Log.e(TAG, "Cannot stop but it does not matter now", e);
		}
	}
}