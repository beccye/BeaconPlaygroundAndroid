package ca.knowledgetranslation.dev.eaaps.beaconplayground;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MyActivity extends Activity {

    //private static final String ESTIMOTE_PROXIMITY_UUID = "B9407F30-F5F8-466E-AFF9-25556B57FE6D";
    //private static final String TAG = "estimote";
    //private static final Region ALL_ESTIMOTE_BEACONS = new Region("rid", ESTIMOTE_PROXIMITY_UUID, null, null);

    //BeaconManager beaconManager = new BeaconManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        /*
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override public void onServiceReady() {
                try {
                    beaconManager.startRanging(ALL_ESTIMOTE_BEACONS);
                    beaconManager.startMonitoring(ALL_ESTIMOTE_BEACONS);
                } catch (RemoteException e) {
                    Log.e(TAG, "Cannot start ranging", e);
                }
            }
        });
        // When no longer needed. Note that ranging will stop.
        beaconManager.disconnect();
        final TextView txtView = (TextView) findViewById(R.id.textView);

        txtView.setMovementMethod(new ScrollingMovementMethod());

        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override public void onEnteredRegion(Region region, List<Beacon> beacons) {
                txtView.append("Entered region: " + beacons + "\n\n" +
                        "\n");
            }
            @Override public void onExitedRegion(Region region) {
                txtView.append("Exited region: " + region + "\n\n" +
                        "\n");
            }
        });
        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, final List beacons) {
                txtView.append("Ranged region: " + region + "\n");
                txtView.append("Ranged beacons: " + beacons + "\n\n\n");
            }
        });
        */
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            return rootView;
        }
    }
}
