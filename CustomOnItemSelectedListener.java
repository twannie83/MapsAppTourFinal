package com.casasolutions.mapsapptour;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    /*Method gets value from combobox and changes public value infoType
    * ID0= "Alle" Default
    * ID1= "Natuur"
    * ID2= "Historie"
    * ID3= "Cultuur"
    */
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        MainActivity mainActivity = new MainActivity();
        if ( pos == 1){
            mainActivity.setInfoType("Natuur");
        }else if(pos == 2){
            mainActivity.setInfoType("Historie");
        }else if(pos == 3){
            mainActivity.setInfoType("Cultuur");
        }else {
            mainActivity.setInfoType("Alle");
        }

        //report to user info type has changed
        Toast.makeText(parent.getContext(),
                "Informatie voorkeur: " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}