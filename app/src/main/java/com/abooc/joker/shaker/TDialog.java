package com.abooc.joker.shaker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abooc.util.Debug;

public class TDialog extends Activity {

    public static void launch(Activity context) {
        Intent intent = new Intent(context, TDialog.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
        context.overridePendingTransition(android.R.anim.slide_in_left, 0);
    }

    private SoundRing mSoundRing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Debug.anchor();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joker_dialog_shake);


        mSoundRing = new SoundRing(this);
        mSoundRing.playSound();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    boolean isShowing;

    public void onPlay(View view) {
        mSoundRing.playSound();
    }

    public void onShowDialog(View view) {
        isShowing = true;

        ShakeDialog shakeDialog = new ShakeDialog(getApplicationContext());
        shakeDialog.show();
        shakeDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                isShowing = false;
            }
        });
    }

    public void onBack(View view) {
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        Debug.anchor();
        super.onDestroy();
        mSoundRing.release();
    }
}
