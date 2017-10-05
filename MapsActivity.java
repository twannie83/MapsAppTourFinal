package com.casasolutions.mapsapptour;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
        mMap.addMarker(new MarkerOptions().position(lettele).title("Lettele").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        /*LatLng punt1 =new LatLng(52.278159, 6.264606);
        mMap.addMarker(new MarkerOptions().position(punt1).title("Oaver de kamp").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        LatLng punt2 = new LatLng(52.283003, 6.281376);
        mMap.addMarker(new MarkerOptions().position(punt2).title("Deur de Buters").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng punt3 = new LatLng(52.279734, 6.277878);
        mMap.addMarker(new MarkerOptions().position(punt3).title("Deur de Negenhook").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng punt4 = new LatLng(52.277706, 6.281182);
        mMap.addMarker(new MarkerOptions().position(punt4).title("Langs de Slenk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        */

        //Based on user choice info type, select markers. default is "Alle"
        switch(MainActivity.infoType){
            case "Natuur":
                LatLng Bramenstruiken= new LatLng(52.275562, 6.279344);mMap.addMarker(new MarkerOptions().position(Bramenstruiken).title("Bramenstruiken").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Vistrap= new LatLng(52.276032, 6.279504);mMap.addMarker(new MarkerOptions().position(Vistrap).title("Vistrap").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Volkstuintjes= new LatLng(52.279781, 6.275426);mMap.addMarker(new MarkerOptions().position(Volkstuintjes).title("Volkstuintjes").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Oostermaet= new LatLng(52.278886, 6.283190);mMap.addMarker(new MarkerOptions().position(Oostermaet).title("Oostermaet").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Dorpsbongerd= new LatLng(52.275549, 6.269021);mMap.addMarker(new MarkerOptions().position(Dorpsbongerd).title("Dorpsbongerd").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                break;

            case "Historie":
                LatLng  Spikker= new LatLng(52.278594, 6.272405);mMap.addMarker(new MarkerOptions().position( Spikker).title(" Spikker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Oude_Looischuur= new LatLng(52.277521, 6.270299);mMap.addMarker(new MarkerOptions().position(Oude_Looischuur).title("Oude_Looischuur").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Begraafplaats= new LatLng(52.277842, 6.270640);mMap.addMarker(new MarkerOptions().position(Begraafplaats).title("Begraafplaats").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Kerk= new LatLng(52.277244, 6.270563);mMap.addMarker(new MarkerOptions().position(Kerk).title("Kerk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Dierenweide= new LatLng(52.277189, 6.270420);mMap.addMarker(new MarkerOptions().position(Dierenweide).title("Dierenweide").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng zitplekje_oerdijk= new LatLng(52.275734, 6.269141);mMap.addMarker(new MarkerOptions().position(zitplekje_oerdijk).title("zitplekje_oerdijk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng De_enk= new LatLng(52.273197, 6.271733);mMap.addMarker(new MarkerOptions().position(De_enk).title("De_enk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Grove_dennen= new LatLng(52.273881, 6.276170);mMap.addMarker(new MarkerOptions().position(Grove_dennen).title("Grove_dennen").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Gemeenteschool= new LatLng(52.276915, 6.278221);mMap.addMarker(new MarkerOptions().position(Gemeenteschool).title("Gemeenteschool").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                break;

            case "Cultuur":
                LatLng Kulturhus= new LatLng(52.280114, 6.274648);mMap.addMarker(new MarkerOptions().position(Kulturhus).title("Kulturhus").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                LatLng Stoelendans= new LatLng(52.279404, 6.272666);mMap.addMarker(new MarkerOptions().position(Stoelendans).title("Stoelendans").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                LatLng Kapelweide= new LatLng(52.278853, 6.272507);mMap.addMarker(new MarkerOptions().position(Kapelweide).title("Kapelweide").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                LatLng Eerste_Kapel= new LatLng(52.278197, 6.270588);mMap.addMarker(new MarkerOptions().position( Eerste_Kapel).title(" Eerste_Kapel").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                break;

            default:
                Kulturhus= new LatLng(52.280114, 6.274648);mMap.addMarker(new MarkerOptions().position(Kulturhus).title("Kulturhus").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Stoelendans= new LatLng(52.279404, 6.272666);mMap.addMarker(new MarkerOptions().position(Stoelendans).title("Stoelendans").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Kapelweide= new LatLng(52.278853, 6.272507);mMap.addMarker(new MarkerOptions().position(Kapelweide).title("Kapelweide").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Spikker= new LatLng(52.278594, 6.272405);mMap.addMarker(new MarkerOptions().position( Spikker).title(" Spikker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Eerste_Kapel= new LatLng(52.278197, 6.270588);mMap.addMarker(new MarkerOptions().position( Eerste_Kapel).title(" Eerste_Kapel").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                //LatLng Moestuin_project= new LatLng(52.278004, 6.270581);mMap.addMarker(new MarkerOptions().position(Moestuin_project).title("Moestuin_project").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Oude_Looischuur= new LatLng(52.277521, 6.270299);mMap.addMarker(new MarkerOptions().position(Oude_Looischuur).title("Oude_Looischuur").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Begraafplaats= new LatLng(52.277842, 6.270640);mMap.addMarker(new MarkerOptions().position(Begraafplaats).title("Begraafplaats").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Kerk= new LatLng(52.277244, 6.270563);mMap.addMarker(new MarkerOptions().position(Kerk).title("Kerk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Dierenweide= new LatLng(52.277189, 6.270420);mMap.addMarker(new MarkerOptions().position(Dierenweide).title("Dierenweide").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                zitplekje_oerdijk= new LatLng(52.275734, 6.269141);mMap.addMarker(new MarkerOptions().position(zitplekje_oerdijk).title("zitplekje_oerdijk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Dorpsbongerd= new LatLng(52.275549, 6.269021);mMap.addMarker(new MarkerOptions().position(Dorpsbongerd).title("Dorpsbongerd").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                De_enk= new LatLng(52.273197, 6.271733);mMap.addMarker(new MarkerOptions().position(De_enk).title("De_enk").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Grove_dennen= new LatLng(52.273881, 6.276170);mMap.addMarker(new MarkerOptions().position(Grove_dennen).title("Grove_dennen").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Bramenstruiken= new LatLng(52.275562, 6.279344);mMap.addMarker(new MarkerOptions().position(Bramenstruiken).title("Bramenstruiken").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Vistrap= new LatLng(52.276032, 6.279504);mMap.addMarker(new MarkerOptions().position(Vistrap).title("Vistrap").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Gemeenteschool= new LatLng(52.276915, 6.278221);mMap.addMarker(new MarkerOptions().position(Gemeenteschool).title("Gemeenteschool").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Volkstuintjes= new LatLng(52.279781, 6.275426);mMap.addMarker(new MarkerOptions().position(Volkstuintjes).title("Volkstuintjes").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Oostermaet= new LatLng(52.278886, 6.283190);mMap.addMarker(new MarkerOptions().position(Oostermaet).title("Oostermaet").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        }


        mMap.moveCamera(CameraUpdateFactory.newLatLng(lettele));

        // Zoom to Lettele
        LatLng centraalpunt =new LatLng(52.276702, 6.275418);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centraalpunt, 15));
        googleMap.setMapType(2);

    }

    public void goHomeFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
