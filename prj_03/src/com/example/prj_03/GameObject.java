package com.example.prj_03;

import android.graphics.Canvas;

/**
 * Created by Vlad on 24.12.2015.
 */
public abstract class GameObject {
    abstract void transform();
    abstract void render(Canvas canvas);
}
