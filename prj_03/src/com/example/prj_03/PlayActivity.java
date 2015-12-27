package com.example.prj_03;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author vidik43
 */
public class PlayActivity extends Activity {

    private GameView gameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.gameView = new GameView(this);
        this.setContentView(this.gameView);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}