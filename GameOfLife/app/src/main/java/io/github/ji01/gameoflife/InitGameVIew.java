package io.github.ji01.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class InitGameVIew extends View {
    private static final float MIN_N = 1 / 3F;
    private Paint mPaintBack;
    private Paint mPaintCell;
    private int w;  //背景宽
    private int cellW;

    public InitGameVIew(Context context) {
        super(context);
        init();
    }

    public InitGameVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InitGameVIew(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setCellNW(float cellNW) {
        if (cellNW > MIN_N) {
            cellNW = MIN_N;
        }
        cellW = (int) (w * cellNW);
        invalidate();
    }

    private void init() {
        mPaintCell = new Paint();
        mPaintBack = new Paint();
        mPaintCell.setStyle(Paint.Style.FILL);
        mPaintBack.setStrokeWidth(5);
        mPaintBack.setStyle(Paint.Style.STROKE);
        mPaintCell.setStrokeWidth(cellW);
        mPaintCell.setColor(Color.RED);
        mPaintBack.setColor(Color.BLACK);
        w = 100;
        cellW = (int) (w * MIN_N);
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
        invalidate();
    }

    public int getCellW() {
        return cellW;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        cellW = (int) (w * MIN_N);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(50, 50, w, w, mPaintBack);
        canvas.drawRect(50 + mPaintBack.getStrokeWidth(),
                50 + mPaintBack.getStrokeWidth(),
                cellW,
                cellW,
                mPaintCell);
    }
}
