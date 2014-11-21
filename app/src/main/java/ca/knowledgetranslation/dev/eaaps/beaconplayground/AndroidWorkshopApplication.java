package ca.knowledgetranslation.dev.eaaps.beaconplayground;

import android.app.Application;

import com.estimote.sdk.BeaconManager;

public class AndroidWorkshopApplication extends Application {

    private BeaconManager beaconManager = null;

    @Override
    public void onCreate() {
        super.onCreate();
        setBeaconManager(new BeaconManager(this));
    }

    public BeaconManager getBeaconManager() {
        if (beaconManager == null) {
            beaconManager = new BeaconManager(this);
        }
        return beaconManager;
    }

    public void setBeaconManager(BeaconManager beaconManager) {
        this.beaconManager = beaconManager;
    }

}