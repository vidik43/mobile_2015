package com.example.prj_03;

import android.app.Activity;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Vlad on 24.12.2015.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {
    GameThread gameThread;
    Character player;
    List<GameObject> gameObjects;

    public GameView(Activity context) {
        super(context);

        gameObjects = new ArrayList<>();

        this.getHolder().addCallback(this);
        this.setOnTouchListener(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        player = new Character(this.getContext(), this);
        gameObjects.add(player);
        gameThread = new GameThread(this);
        gameThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    public void transform() {
        for(GameObject obj : gameObjects){
            obj.transform();
        }
    }

    public void render(Canvas canvas){
        for(GameObject obj : gameObjects) {
            obj.render(canvas);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX()-this.getWidth() / 2.0f;
        float y = motionEvent.getY()-this.getHeight() / 2.0f;

        if(x>=Math.abs(y))
            player.setAction(Character.Actions.WALK, Character.Directions.RIGHT);
        else if(x<-Math.abs(y))
            player.setAction(Character.Actions.WALK, Character.Directions.LEFT);
        else if(y<=Math.abs(x))
            player.setAction(Character.Actions.WALK, Character.Directions.UP);
        else if(y>=Math.abs(x))
            player.setAction(Character.Actions.WALK, Character.Directions.DOWN);

        return false;
    }
}

