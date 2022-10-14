package com.davtyan.lights;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class TestSurfaceView extends SurfaceView implements Runnable  {
//public class TestSurfaceView  extends SurfaceView implements SurfaceHolder.Callback {

    Thread thread;
    SurfaceHolder holder;
    boolean drawing;
    enum COLORS {
        RED,
        YELLOW,
        GREEN
    }
    COLORS color = COLORS.RED;

    public TestSurfaceView(Context context) {
        super(context);
        holder = getHolder();

    }

    @Override
    public void run() {

        while (true) {
            if (holder.getSurface().isValid()) {
                Canvas canvas = holder.lockCanvas();
                paint(canvas);
                holder.unlockCanvasAndPost(canvas);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void paint(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        switch (color){
            case RED:
                canvas.drawColor(Color.RED);
                color = COLORS.GREEN;
                break;
            case GREEN:
                canvas.drawColor(Color.GREEN);
                color = COLORS.YELLOW;
                break;
            case YELLOW:
                canvas.drawColor(Color.YELLOW);
                color = COLORS.RED;
                break;

        }
    }

    public void pause() {
        drawing = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        drawing = true;
        thread = new Thread(this);
        thread.start();
    }

}
