package com.casasolutions.mapsapptour;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {


    private ZXingScannerView mScannerView;
    public String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startScanner();

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
        /*Do anything with result here :D
        Log.w("handleResult",result.getText( ));
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        */
        Log.w("handleResult",result.getText( ));
        url = result.getText();
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);

        //Give url to new webActivity
        Bundle b = new Bundle();
        b.putString("url", url);
        intent.putExtras(b); //Put your url to your next Intent

        startActivity(intent);



        //Resume scanning uncomment below
        //mScannerView.resumeCameraPreview(this);
    }

    public String getUrl() {
        return url;
    }
}
