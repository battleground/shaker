package com.abooc.joker.shaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.abooc.util.Debug;

public class ShakerMainActivity extends AppCompatActivity implements
        SensorEventBuilder.EventListener {

    private SensorEventBuilder mSensorBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Debug.anchor();
        super.onCreate(savedInstanceState);
        mSensorBuilder = new SensorEventBuilder(this).builder(this);

        setContentView(R.layout.activity_shaker);
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

    public void onOpenSettings(View view) {
        SettingsActivity.launch(this);
    }

    public void onShowDialog(View view) {
//        showDialog();
        TDialog.launch(this);

        TDialog.launch(this); // TODO 测试强制启动两次
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
