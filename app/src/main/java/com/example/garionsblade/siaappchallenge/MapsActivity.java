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
        LatLng unitedstates = new LatLng(37.1176, -95.9846);
        LatLng china = new LatLng(36.93815, 104.1279);
        LatLng germany = new LatLng(51.0982, 10.4183);

        GroundOverlayOptions australiaMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.australia)).position(australia, 4000000f, 3730000f);
        GroundOverlayOptions franceMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.france)).position(france, 1000000f, 973000f);
        GroundOverlayOptions unitedkingdomMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.unitedkingdom)).position(unitedkingdom, 600000f, 1051700f);
        GroundOverlayOptions unitedstatesMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.unitedstates)).position(unitedstates, 5200000f, 2732700f);
        GroundOverlayOptions chinaMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.china)).position(china, 5500000f, 3755300f);
        GroundOverlayOptions germanyMap = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.germany)).position(germany, 663000f, 855084f);

        GroundOverlayOptions australiaFree = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.australia_free)).position(australia, 4000000f, 3730000f);
        GroundOverlayOptions franceFree = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.france_free)).position(france, 1000000f, 973000f);
        GroundOverlayOptions unitedkingdomFree = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.unitedkingdom_free)).position(unitedkingdom, 600000f, 1051700f);
        GroundOverlayOptions unitedstatesFree = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.unitedstates_free)).position(unitedstates, 5200000f, 2732700f);
        GroundOverlayOptions chinaFree = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.china_free)).position(china, 5500000f, 3755300f);
        GroundOverlayOptions germanyFree = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.germany_free)).position(germany, 663000f, 855084f);

        mMap.addGroundOverlay(australiaFree);
        mMap.addGroundOverlay(franceMap);
        mMap.addGroundOverlay(unitedkingdomMap);
        mMap.addGroundOverlay(unitedstatesMap);
        mMap.addGroundOverlay(chinaMap);
        mMap.addGroundOverlay(germanyMap);

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

        mMap.moveCamera(CameraUpdateFactory.newLatLng(germany));

    }
}
