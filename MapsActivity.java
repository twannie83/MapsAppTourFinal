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
                LatLng Dorpsbongerd= new LatLng(52.275549, 6.269021);mMap.addMarker(new MarkerOptions().position(Dorpsbongerd).title("Dorpsbongerd").snippet("Op 20 november 2015 hebben kinderen van basisschool Sancta Maria hier 21 hoogstamfruitbomen geplant. Het zijn 11 appelbomen, 7 perenbomen, 2 pruimenbomen en 1 kersenboom. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Bramenstruiken= new LatLng(52.275562, 6.279344);mMap.addMarker(new MarkerOptions().position(Bramenstruiken).title("Bramenstruiken").snippet("De gewone braam (Rubus fruticosus) is een in heel Europa inheemse plant die met name voorkomt op voedselarme, lichtvochtige grond en dan vooral in overgangssituaties").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Vistrap= new LatLng(52.276032, 6.279504);mMap.addMarker(new MarkerOptions().position(Vistrap).title("Vistrap").snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Volkstuintjes= new LatLng(52.279781, 6.275426);mMap.addMarker(new MarkerOptions().position(Volkstuintjes).title("Volkstuintjes").snippet("De volkstuinen van lettele bestaan uit 15 velden van 180 vierkante meter").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Oostermaet= new LatLng(52.278886, 6.283190);mMap.addMarker(new MarkerOptions().position(Oostermaet).title("Oostermaet").snippet("De Hottingerkaart uit ca. 1785 toont het gebied als de ‘Bathmenerheyde’, een nog niet in cultuur gebracht gebied. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng Leide= new LatLng(52.276730, 6.270416);mMap.addMarker(new MarkerOptions().position(Leide).title("Leide").snippet("In 2005 werd als onderdeel van de dorpswandeling ‘Krange op de weg’, een prachtige waterpartij bij de kerk aangelegd. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                break;

            case "Historie":
                LatLng  Spikker= new LatLng(52.278594, 6.272405);mMap.addMarker(new MarkerOptions().position( Spikker).title("Spikker").snippet("Op deze locatie is in 1842 een boerderij gebouwd , behalve de kapel was er nog geen bebouwing in Lettele.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Oude_Looischuur= new LatLng(52.277521, 6.270299);mMap.addMarker(new MarkerOptions().position(Oude_Looischuur).title("Oude_Looischuur").snippet("Hier ziet u aan de overkant van de Letteler Leide een schuur die tot eind 1800 dienstdeed als leerlooierij. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Begraafplaats= new LatLng(52.277842, 6.270640);mMap.addMarker(new MarkerOptions().position(Begraafplaats).title("Begraafplaats").snippet("Na de bouw van de kapel in 1820 ontstond er de wens om de overledenen bij de eigen kapel te begraven. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Kerk= new LatLng(52.277035, 6.270767);mMap.addMarker(new MarkerOptions().position(Kerk).title("Kerk").snippet("In eerste instantie is het misschien vreemd dat de ingang van de kerk zich aan de achterkant van het gebouw bevindt, maar daar is een bijzondere reden voor. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Dierenweide= new LatLng(52.276451, 6.270456);mMap.addMarker(new MarkerOptions().position(Dierenweide).title("Dierenweide").snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Zitplekje_Oerdijk= new LatLng(52.275734, 6.269141);mMap.addMarker(new MarkerOptions().position(Zitplekje_Oerdijk).title("Zitplekje_Oerdijk").snippet("Dit zithoekje in aan de hoek Oerdijk/Schotwillemsweg, wordt ommuurd door brokken ijzeroer, die tijdens de ruilverkaveling in de jaren zeventig van de vorige eeuw uit de grond zijn gehaald.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng De_Enk= new LatLng(52.273197, 6.271733);mMap.addMarker(new MarkerOptions().position(De_Enk).title("De_Enk").snippet("Tijdens de laatste ijstijd kwam het landijs niet verder dan Denemarken en Noord Duitsland. Wel was hier het klimaat in die periode erg koud. In de extreem koude periode van 21000 tot 18000 jaar geleden was hier een poolwoestijn waarin de wind vrij spel had. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Dennen= new LatLng(52.273881, 6.276170);mMap.addMarker(new MarkerOptions().position(Dennen).title("Dennen").snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                LatLng Gemeenteschool= new LatLng(52.276915, 6.278221);mMap.addMarker(new MarkerOptions().position(Gemeenteschool).title("Gemeenteschool").snippet("Dit Gemeentelijke monument (Oerdijk 186-188) is gebouwd als basisschool voor alle gezindten (1882), in opdracht van de gemeente Diepenveen.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                break;

            case "Cultuur":
                LatLng Kulturhus= new LatLng(52.280114, 6.274648);mMap.addMarker(new MarkerOptions().position(Kulturhus).title("Kulturhus").snippet("Het Kulturhus is met vereende krachten tot stand gekomen en is op 15 oktober 2016 door de Lettelenaar van het jaar officieel geopend. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                LatLng Stoelendans= new LatLng(52.279404, 6.272666);mMap.addMarker(new MarkerOptions().position(Stoelendans).title("Stoelendans").snippet("Ter ere van het 100 jarig bestaan van de Stichting Evenementen Commissie Lettele (SECL) werd op vrijdag 6 augustus 1999, een jaar later dan de bedoeling was, het beeld De Stoelendans onthuld.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                LatLng Kapelweide= new LatLng(52.278853, 6.272507);mMap.addMarker(new MarkerOptions().position(Kapelweide).title("Kapelweide").snippet("Naast de eerste kapel (1820) bestond Lettele uit een handvol boerderijen, waar nevenberoepen werden uitgevoerd om de inkomsten te verhogen.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                LatLng  Eerste_Kapel= new LatLng(52.278197, 6.270588);mMap.addMarker(new MarkerOptions().position( Eerste_Kapel).title(" Eerste_Kapel").snippet("In 1809 werd Andreas van de Vondervoort de laatste pastoor van de Statie Kolmschate. Hij was iemand die van aanpakken wist.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                LatLng Canadees= new LatLng(52.277998, 6.272048);mMap.addMarker(new MarkerOptions().position(Canadees).title("Canadees").snippet("Op 10 april 1945 werd aan pastoor Dröge van de parochie Lettele gevraagd of er een Canadese militair op het kerkhof begraven mocht worden. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

                break;

            default:
                Dorpsbongerd= new LatLng(52.275549, 6.269021);mMap.addMarker(new MarkerOptions().position(Dorpsbongerd).title("Dorpsbongerd").snippet("Op 20 november 2015 hebben kinderen van basisschool Sancta Maria hier 21 hoogstamfruitbomen geplant. Het zijn 11 appelbomen, 7 perenbomen, 2 pruimenbomen en 1 kersenboom. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Bramenstruiken= new LatLng(52.275562, 6.279344);mMap.addMarker(new MarkerOptions().position(Bramenstruiken).title("Bramenstruiken").snippet("De gewone braam (Rubus fruticosus) is een in heel Europa inheemse plant die met name voorkomt op voedselarme, lichtvochtige grond en dan vooral in overgangssituaties").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Vistrap= new LatLng(52.276032, 6.279504);mMap.addMarker(new MarkerOptions().position(Vistrap).title("Vistrap").snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Volkstuintjes= new LatLng(52.279781, 6.275426);mMap.addMarker(new MarkerOptions().position(Volkstuintjes).title("Volkstuintjes").snippet("De volkstuinen van lettele bestaan uit 15 velden van 180 vierkante meter").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Oostermaet= new LatLng(52.278886, 6.283190);mMap.addMarker(new MarkerOptions().position(Oostermaet).title("Oostermaet").snippet("De Hottingerkaart uit ca. 1785 toont het gebied als de ‘Bathmenerheyde’, een nog niet in cultuur gebracht gebied. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Leide= new LatLng(52.276730, 6.270416);mMap.addMarker(new MarkerOptions().position(Leide).title("Leide").snippet("In 2005 werd als onderdeel van de dorpswandeling ‘Krange op de weg’, een prachtige waterpartij bij de kerk aangelegd. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                Spikker= new LatLng(52.278594, 6.272405);mMap.addMarker(new MarkerOptions().position( Spikker).title("Spikker").snippet("Op deze locatie is in 1842 een boerderij gebouwd , behalve de kapel was er nog geen bebouwing in Lettele.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Oude_Looischuur= new LatLng(52.277521, 6.270299);mMap.addMarker(new MarkerOptions().position(Oude_Looischuur).title("Oude_Looischuur").snippet("Hier ziet u aan de overkant van de Letteler Leide een schuur die tot eind 1800 dienstdeed als leerlooierij. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Begraafplaats= new LatLng(52.277842, 6.270640);mMap.addMarker(new MarkerOptions().position(Begraafplaats).title("Begraafplaats").snippet("Na de bouw van de kapel in 1820 ontstond er de wens om de overledenen bij de eigen kapel te begraven. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Kerk= new LatLng(52.277035, 6.270767);mMap.addMarker(new MarkerOptions().position(Kerk).title("Kerk").snippet("In eerste instantie is het misschien vreemd dat de ingang van de kerk zich aan de achterkant van het gebouw bevindt, maar daar is een bijzondere reden voor. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Dierenweide= new LatLng(52.276451, 6.270456);mMap.addMarker(new MarkerOptions().position(Dierenweide).title("Dierenweide").snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Zitplekje_Oerdijk= new LatLng(52.275734, 6.269141);mMap.addMarker(new MarkerOptions().position(Zitplekje_Oerdijk).title("Zitplekje_Oerdijk").snippet("Dit zithoekje in aan de hoek Oerdijk/Schotwillemsweg, wordt ommuurd door brokken ijzeroer, die tijdens de ruilverkaveling in de jaren zeventig van de vorige eeuw uit de grond zijn gehaald.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                De_Enk= new LatLng(52.273197, 6.271733);mMap.addMarker(new MarkerOptions().position(De_Enk).title("De_Enk").snippet("Tijdens de laatste ijstijd kwam het landijs niet verder dan Denemarken en Noord Duitsland. Wel was hier het klimaat in die periode erg koud. In de extreem koude periode van 21000 tot 18000 jaar geleden was hier een poolwoestijn waarin de wind vrij spel had. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Dennen= new LatLng(52.273881, 6.276170);mMap.addMarker(new MarkerOptions().position(Dennen).title("Dennen").snippet("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Gemeenteschool= new LatLng(52.276915, 6.278221);mMap.addMarker(new MarkerOptions().position(Gemeenteschool).title("Gemeenteschool").snippet("Dit Gemeentelijke monument (Oerdijk 186-188) is gebouwd als basisschool voor alle gezindten (1882), in opdracht van de gemeente Diepenveen.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Kulturhus= new LatLng(52.280114, 6.274648);mMap.addMarker(new MarkerOptions().position(Kulturhus).title("Kulturhus").snippet("Het Kulturhus is met vereende krachten tot stand gekomen en is op 15 oktober 2016 door de Lettelenaar van het jaar officieel geopend. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Stoelendans= new LatLng(52.279404, 6.272666);mMap.addMarker(new MarkerOptions().position(Stoelendans).title("Stoelendans").snippet("Ter ere van het 100 jarig bestaan van de Stichting Evenementen Commissie Lettele (SECL) werd op vrijdag 6 augustus 1999, een jaar later dan de bedoeling was, het beeld De Stoelendans onthuld.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Kapelweide= new LatLng(52.278853, 6.272507);mMap.addMarker(new MarkerOptions().position(Kapelweide).title("Kapelweide").snippet("Naast de eerste kapel (1820) bestond Lettele uit een handvol boerderijen, waar nevenberoepen werden uitgevoerd om de inkomsten te verhogen.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Eerste_Kapel= new LatLng(52.278197, 6.270588);mMap.addMarker(new MarkerOptions().position( Eerste_Kapel).title(" Eerste_Kapel").snippet("In 1809 werd Andreas van de Vondervoort de laatste pastoor van de Statie Kolmschate. Hij was iemand die van aanpakken wist.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                Canadees= new LatLng(52.277998, 6.272048);mMap.addMarker(new MarkerOptions().position(Canadees).title("Canadees").snippet("Op 10 april 1945 werd aan pastoor Dröge van de parochie Lettele gevraagd of er een Canadese militair op het kerkhof begraven mocht worden. ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
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
