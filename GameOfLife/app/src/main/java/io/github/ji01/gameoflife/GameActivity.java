package io.github.ji01.gameoflife;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;


public class GameActivity extends AppCompatActivity {
    GameViewSuffer gameView;
    GameOfLife gameOfLife;
    SurfaceHolder surfaceHolder;
    private boolean isGaming = false;
    private Paint[][] paints;
    private int backW;
    private int cellW;
    private int cellsCount;
    private Paint linePaint;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Intent intent = getIntent();
        backW = intent.getIntExtra("w", 100);
        cellW = intent.getIntExtra("cell", 20);
        cellsCount = backW / cellW;
        gameOfLife = new GameOfLife();
        gameOfLife.setVar(cellsCount, cellsCount);
        linePaint = new Paint();
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setStrokeWidth(2);
        linePaint.setColor(Color.GREEN);
        paints = new Paint[cellsCount][cellsCount];
        for (int i = 0; i < cellsCount; i++) {
            for (int j = 0; j < cellsCount; j++) {
                paints[i][j] = new Paint();
                paints[i][j].setStyle(Paint.Style.FILL);
                paints[i][j].setStrokeWidth(cellW - 5);
                paints[i][j].setColor(Color.TRANSPARENT);
            }
        }
        isGaming = true;
        gameView = new GameViewSuffer(GameActivity.this);
        gameView.setLayoutParams(new FrameLayout.LayoutParams(backW,
                backW));
        surfaceHolder = gameView.holder;
        surfaceHolder.addCallback(new CallBack());
        ((FrameLayout) findViewById(R.id.game_view)).addView(gameView);
        findViewById(R.id.stop_game).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void allDead() {
        Log.i("TAG", "all dead");
    }

    private class CallBack implements SurfaceHolder.Callback {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (isGaming) {
                        Log.i("TAG", "RUN");
                        Canvas canvas = surfaceHolder.lockCanvas();
                        int liveCount = 0;
                        for (int i = 0; i < cellsCount; i++) {
                            for (int j = 0; j < cellsCount; j++) {
                                int l = i * cellW;
                                int t = j * cellW;
                                if (gameOfLife.newStatus[i][j] == 1) {
                                    liveCount++;
                                    paints[i][j].setColor(Color.RED);
                                } else {
                                    paints[i][j].setColor(Color.BLACK);
                                }
                                canvas.drawRect(l, t, l + cellW, t + cellW, paints[i][j]);
                            }

                        }
                        if (liveCount == 0) {
                            isGaming = false;
                        }
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        gameOfLife.refreshAllCellStatus();
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            isGaming = false;
            gameView = null;
            surfaceHolder = null;
        }
    }
}
