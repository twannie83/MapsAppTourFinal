package com.casasolutions.mapsapptour;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StiefelRaadselActivity extends AppCompatActivity {

    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiefel_raadsel);

    }

    public void buttonCheckAnswerFunction(View v)
    {
        Resources res = getResources();
        //clean answer string
        answer = "";
        for(int x=1; x<21; x++) {
            String idName = "editText" + x;
            EditText mEdit = (EditText) findViewById(res.getIdentifier(idName, "id", getPackageName()));
            answer = answer + mEdit.getText().toString();
        }
        Toast.makeText(this, " Antwoord ingevuld is: " + answer, Toast.LENGTH_LONG).show();
    }
}

