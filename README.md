# BeaconPlaygroundAndroid

Based off code from [williamrijksen's](https://github.com/williamrijksen) [Estimote Beacons Android Workshop](https://github.com/williamrijksen/Workshop-Estimote-Beacons-Android) to setup a service that will monitor beacons as a background process, this example monitors the bluetooth state change system broadcast (android.bluetooth.adapter.action.STATE_CHANGED) to either start the service (when the phone boots and loads bluetooth, or when the user activates bluetooth) and stops the service (when the use deactivates bluetooth).

I found that attempts to start the service ON_BOOT_COMPLETED would fail, and my assumption is that Android would kill the process since it was spending too much time looking for a bluetooth signal that did not exist. 

## Note

This is my first Android app, let alone my first Beacon app. I've committed the working folder as is. I can't make any guarantees that this will work for someone cloning the repo, but if nothing else it should be easy to dig around and ensure that things are setup similarly.
