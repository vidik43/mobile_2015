package com.example.prj_03;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author vidik43
 */
public class GameThread extends Thread{
    GameView gameView;
    public GameThread(GameView gameView) {
        this.gameView = gameView;
    }
    @Override
    public void run(){
        Canvas canvas;
        while (true){
            canvas = gameView.getHolder().lockCanvas();

            canvas.drawRect(0,0,canvas.getWidth(), canvas.getHeight(), new Paint());

            gameView.transform();
            gameView.render(canvas);


            gameView.getHolder().unlockCanvasAndPost(canvas);
            try {
                this.sleep(1000 / 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

