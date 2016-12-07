package com.example.alex.rashtemirestaurant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Rares on 07.12.2016.
 */

public class TitleView extends View {

    Paint textPaint;
    boolean white = false;

    public TitleView(Context context) {
        super(context);
        textPaint = new Paint();
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        textPaint = new Paint();
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        textPaint = new Paint();
    }

    public void TriggerColorChange() {
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        ChangeColor();

        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(60);

        int xPos = (canvas.getWidth() / 2);
        int yPos = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2));

        canvas.drawText("Rashtemi Restaurant", xPos, yPos, textPaint);
    }

    private void ChangeColor() {
        if(white) {
            textPaint.setARGB(255, 255, 0, 0);
        } else {
            textPaint.setARGB(255, 255, 255, 255);
        }

        white = !white;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, 100);
    }
}
