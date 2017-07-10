package com.casasolutions.mapsapptour;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {


    private ZXingScannerView mScannerView;
    public String url;
    private String infoTypeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startScanner();
        showUserAlertBox("Instructie voor het scannen", "Beweeg camera naar de pokkelpoal en houd QR plaatje enkele seconde stil in het vierkant, totdat informatie wordt opgehaald");

    }

    public void startScanner(){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        //Do anything with result here :D
        Log.w("handleResult",result.getText( ));
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Pokkelpoal succesvol gescand!");
        builder.setMessage("U wordt nu doorgestuurd naar de Stiefeltoch informatie bij deze pokkelpoal");
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Log.w("handleResult",result.getText( ));
        url = result.getText();


        //Add ID to URL
        infoTypeId = MainActivity.infoType;
        url = url + "-"+ infoTypeId;

        /* Debug builder.setTitle("Url met ID: ");
        builder.setMessage(url);
        alertDialog = builder.create();
        alertDialog.show();*/


        Intent intent = new Intent(getApplicationContext(), WebActivity.class);

        //Give url to new webActivity
        Bundle b = new Bundle();
        b.putString("url", url);
        intent.putExtras(b); //Put your url to your next Intent

        startActivity(intent);



        //Resume scanning uncomment below
        //mScannerView.resumeCameraPreview(this);
    }

    private void showUserAlertBox(String title, String text){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(text);
        AlertDialog alertDialog = builder.create();

        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);

        alertDialog.show();
    }

    public String getUrl() {
        return url;
    }
}
