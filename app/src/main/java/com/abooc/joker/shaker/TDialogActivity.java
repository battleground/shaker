package com.abooc.joker.shaker;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import com.abooc.util.Debug;

public class TDialogActivity extends Activity {

    public static void launch(Activity context) {
        Intent intent = new Intent(context, TDialogActivity.class);
        context.startActivity(intent);
        context.overridePendingTransition(android.R.anim.slide_in_left, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Debug.anchor();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joker_dialog_shake);


        sound(this);
        playSound();
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

    private SoundPool mSoundPool;
    private int mSoundID;

    void sound(Context context) {
        mSoundPool = new SoundPool(5, AudioManager.STREAM_RING, 0);
        mSoundID = mSoundPool.load(context.getApplicationContext(), R.raw.shake_sound_male, 1);
    }

    private void playSound() {
        mSoundPool.play(
                mSoundID,
                1.0f,      //左耳道音量【0~1】
                1.0f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }

    public void onPlay(View view) {
        playSound();
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
        mSoundPool.release();
    }
}
