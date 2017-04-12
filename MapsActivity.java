package com.casasolutions.mapsapptour;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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

        // Add a marker in Lettele
        LatLng lettele =new LatLng(52.276390, 6.271862);
        mMap.addMarker(new MarkerOptions().position(lettele).title("Lettele"));

        LatLng punt1 =new LatLng(52.278159, 6.264606);
        mMap.addMarker(new MarkerOptions().position(punt1).title("Oaver de kamp"));
        LatLng punt2 = new LatLng(52.283003, 6.281376);
        mMap.addMarker(new MarkerOptions().position(punt2).title("Deur de Buters"));
        LatLng punt3 = new LatLng(52.279734, 6.277878);
        mMap.addMarker(new MarkerOptions().position(punt3).title("Deur de Negenhook"));
        LatLng punt4 = new LatLng(52.277706, 6.281182);
        mMap.addMarker(new MarkerOptions().position(punt4).title("Langs de Slenk"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(lettele));

        // Zoom to Lettele
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(punt3, 14));
        googleMap.setMapType(2);

    }
}
