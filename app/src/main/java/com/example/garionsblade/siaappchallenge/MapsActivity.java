package com.example.garionsblade.siaappchallenge;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static String TAG = "error";
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng australia = new LatLng(-27.1032, 133.4855);
        LatLng france = new LatLng(46.733, 1.66734);
        LatLng unitedkingdom = new LatLng (54.689, -2.9385);
        LatLng singapore = new LatLng(1.3518, 103.8198);

        GroundOverlayOptions australiaMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.australia)).position(australia, 4000000f, 3730000f);
        GroundOverlayOptions franceMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.france)).position(france, 1000000f, 973000f);
        GroundOverlayOptions unitedkingdomMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.unitedkingdom)).position(unitedkingdom, 600000f, 1051700f);

        mMap.addGroundOverlay(australiaMap);
        mMap.addGroundOverlay(franceMap);
        mMap.addGroundOverlay(unitedkingdomMap);


        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

                if (!success) {
                    Log.e(TAG, "Style parsing failed.");
                }
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Can't find style. Error: ", e);
        }

        // Add a marker in Sydney and move the camera

        mMap.moveCamera(CameraUpdateFactory.newLatLng(unitedkingdom));

    }
}
