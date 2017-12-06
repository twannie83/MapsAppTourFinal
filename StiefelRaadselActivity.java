package com.casasolutions.mapsapptour;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class StiefelRaadselActivity extends AppCompatActivity {

    private String answer;
    private ImageView diplomaView;
    private Resources res;
    private String stiefelanswer_array[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiefel_raadsel);

        //fill stiefelanswer_array
        stiefelanswer_array = Variables.getStiefelAnswer_Array();
        res = getResources();
        fillEditBoxesFromArray();
    }

    public void buttonCheckAnswerFunction(View v)
    {

        //clean answer string
        answer = "";
        for(int x=1; x<21; x++) {
            String idName = "editText" + x;
            EditText mEdit = (EditText) findViewById(res.getIdentifier(idName, "id", getPackageName()));
            answer = answer + mEdit.getText().toString();

            //push editbox values to array
            stiefelanswer_array[x] = mEdit.getText().toString();
        }
        Toast.makeText(this, " Antwoord ingevuld is: " + answer, Toast.LENGTH_LONG).show();

        //If answer is correct show Diploma
        if (answer.toUpperCase().equals("STIEFELTOCHTDIPLOMA!")){
            Toast.makeText(this, " Antwoord correct!!, je hebt een diploma verdiend!", Toast.LENGTH_LONG).show();
            diplomaView = (ImageView) findViewById(R.id.diplomaView);
            diplomaView.setVisibility(View.VISIBLE);
        }else{
            Toast.makeText(this, " Antwoord: " + answer + " is fout, probeer het nog een keer", Toast.LENGTH_LONG).show();
        }
    }

    public void goHomeFunction(View v)
    {
        //save all values to array
        for(int x=1; x<21; x++) {
            String idName = "editText" + x;
            EditText mEdit = (EditText) findViewById(res.getIdentifier(idName, "id", getPackageName()));
            //push editbox values to array
            stiefelanswer_array[x] = mEdit.getText().toString();
        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    //This function prefills all edit boxes with value from stiefelanswer_array
    private void fillEditBoxesFromArray()
    {
        for(int x=1; x<21; x++) {
            String idName = "editText" + x;
            EditText mEdit = (EditText) findViewById(res.getIdentifier(idName, "id", getPackageName()));
            if(mEdit != null) {
                mEdit.setText(stiefelanswer_array[x]);
            }
        }
    }
}

