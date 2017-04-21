package com.abooc.joker.shaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.abooc.util.Debug;

public class SettingsActivity extends AppCompatActivity implements
        SensorEventBuilder.EventListener {

    public static void launch(Activity context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }

    private SensorEventBuilder mSensorBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSensorBuilder = new SensorEventBuilder(this).builder(this);

        setContentView(R.layout.activity_settings);
    }

    @Override
    protected void onResume() {
        Debug.anchor();
        super.onResume();
        mSensorBuilder.turnOn();
    }

    @Override
    protected void onPause() {
        Debug.anchor();
        super.onPause();
        mSensorBuilder.turnOff();
    }

    @Override
    public void onShake() {
        Debug.anchor();
        onShowDialog(null);
    }

    public void onPlay(View view) {
    }

    public void onShowDialog(View view) {
//        showDialog();
        TDialog.launch(this);
        TDialog.launch(this);
    }

    private void showDialog() {
        ShakeDialog shakeDialog = new ShakeDialog(getApplicationContext());
        shakeDialog.show();
    }

    @Override
    protected void onDestroy() {
        Debug.anchor();
        super.onDestroy();
        mSensorBuilder.destroy();
    }

}
