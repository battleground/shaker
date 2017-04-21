package com.abooc.joker.shaker;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by dayu on 2017/4/21.
 */

public class SoundRing {

    private SoundPool mSoundPool;
    private int mSoundID;

    public SoundRing(Context context) {
        mSoundPool = new SoundPool(5, AudioManager.STREAM_RING, 0);
        mSoundID = mSoundPool.load(context.getApplicationContext(), R.raw.shake_sound_male, 1);
    }

    public void playSound() {
        mSoundPool.play(
                mSoundID,
                1.0f,      //左耳道音量【0~1】
                1.0f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }

    public void release() {
        mSoundPool.release();
    }

}
