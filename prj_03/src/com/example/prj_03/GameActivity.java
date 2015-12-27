package com.example.prj_03;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * @author vidik43
 */

public class GameActivity extends Activity implements View.OnClickListener{

    private static final int REQUEST_START_GAME = 0;
    private static final int REQUEST_ABOUT_GAME = 1;

    private Button BPlay;
    private Button BAbout;
    private Button BExit;

    protected void startGame() {
        Intent intent = new Intent(this, PlayActivity.class);
        this.startActivityForResult(intent, REQUEST_START_GAME);
    }

    protected void aboutGame() {
        Intent intent = new Intent(this, AuthorActivity.class);
        this.startActivityForResult(intent, REQUEST_ABOUT_GAME);
    }

    protected void exitGame() {
        this.finish();
        System.exit(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.exitGame();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);
        this.BPlay = (Button) this.findViewById(R.id.BPlay);
        this.BPlay.setOnClickListener(this);

        this.BAbout = (Button) this.findViewById(R.id.BAbout);
        this.BAbout.setOnClickListener(this);

        this.BExit = (Button) this.findViewById(R.id.BExit);
        this.BExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BPlay:
                this.startGame();
                break;
            case R.id.BAbout:
                this.aboutGame();
                break;
            case R.id.BExit:
                this.exitGame();
                break;
        }
    }
}
