package com.casasolutions.mapsapptour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.ActionBar;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{

    /*Combobox for choosing question type
    * ID1 = "Historie"
    * ID2= "Cultuur"
    * ID3= "Natuur"
    */
    private Spinner infoTypeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add items,
        addItemsOnSpinner();
        addListenerOnSpinnerItemSelection();
    }

    public void buttonClickFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    public void buttonScanClickFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ScannerActivity.class);
        startActivity(intent);
    }
    public void buttonRecorderClickFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(), RecorderActivity.class);
        startActivity(intent);
    }

    /* Fill combobox spinner with values*/
    public void addItemsOnSpinner() {
        infoTypeSpinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Historie");
        list.add("Cultuur");
        list.add("Natuur");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infoTypeSpinner.setAdapter(dataAdapter);
}

    public void addListenerOnSpinnerItemSelection() {
        infoTypeSpinner = (Spinner) findViewById(R.id.spinner);
        infoTypeSpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }




}
