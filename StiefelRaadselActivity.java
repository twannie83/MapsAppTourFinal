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
    private EditText mEditView;
    private TextView mTextView;
    private String editTextValue;
    private String TEXT_VIEW_KEY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stiefel_raadsel);


        if(savedInstanceState != null){
            mTextView = (TextView) findViewById(R.id.editText1);
        }
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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mEditView != null) {
            editTextValue = mEditView.getText().toString();
            mTextView.setText(editTextValue);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mTextView.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mTextView != null) {
            outState.putString(TEXT_VIEW_KEY, mTextView.getText().toString());
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}

