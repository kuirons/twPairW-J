package io.github.ji01.gameoflife;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GameViewSuffer extends SurfaceView {
    public SurfaceHolder holder;

    public GameViewSuffer(Context context) {
        super(context);
        holder = getHolder();
    }

    public GameViewSuffer(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = getHolder();
    }

    public GameViewSuffer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        holder = getHolder();
    }

}
