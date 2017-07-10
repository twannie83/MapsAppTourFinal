package com.casasolutions.mapsapptour;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    /*Method gets value from combobox and changes public value infoType
    * ID1= "Historie" Default
    * ID2= "Cultuur"
    * ID3= "Natuur"
    */
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        MainActivity mainActivity = new MainActivity();
        if ( pos == 1){
            mainActivity.setInfoType("id2");
        }else if(pos == 2){
            mainActivity.setInfoType("id3");
        }else {
            mainActivity.setInfoType("id1");
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