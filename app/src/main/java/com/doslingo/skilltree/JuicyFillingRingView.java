package com.doslingo.skilltree;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.doslingo.R;

public class JuicyFillingRingView extends View {
  private float progress;
  private boolean drawCap;
  private float diameterFraction;
  private int capWidth = 4;
  private int capLength = 5;

  private final RectF rect = new RectF();
  private final Paint greyPaint = new Paint();
  private final Paint ringFillPaint = new Paint();
  private final Paint capPaint3 = new Paint();

  public JuicyFillingRingView(Context context) {
    super(context);
    init(context, null, 0);
  }

  public JuicyFillingRingView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs, 0);
  }

  public JuicyFillingRingView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {
    greyPaint.setAntiAlias(true);
    greyPaint.setColor(context.getColor(R.color.juicySwan));
    greyPaint.setStrokeCap(Paint.Cap.ROUND);
    greyPaint.setStyle(Paint.Style.STROKE);

    capPaint3.setAntiAlias(true);
    capPaint3.setColor(context.getColor(R.color.juicySnow));
    capPaint3.setStrokeCap(Paint.Cap.ROUND);
    capPaint3.setStyle(Paint.Style.STROKE);

    ringFillPaint.setAntiAlias(true);
    ringFillPaint.setStrokeCap(Paint.Cap.ROUND);
    ringFillPaint.setStyle(Paint.Style.STROKE);

    final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.JuicyFillingRingView, defStyleAttr, 0);
    try {
      setRingFillColor(a.getColor(R.styleable.JuicyFillingRingView_ringFillColor, context.getColor(R.color.juicyFox)));
      progress = a.getFloat(R.styleable.JuicyFillingRingView_progress, 0);
      diameterFraction = a.getFloat(R.styleable.JuicyFillingRingView_diameterFraction, 0.07f);
      drawCap = a.getBoolean(R.styleable.JuicyFillingRingView_drawCap, true);
      capWidth = a.getInteger(R.styleable.JuicyFillingRingView_capWidth, 4);
      capLength = a.getInteger(R.styleable.JuicyFillingRingView_capLength, 5);
    } finally {
      a.recycle();
    }
  }


  public final void setRingFillColor(int i) {
    ringFillPaint.setColor(i);
  }

  public final int getRingFillColor() {
    return ringFillPaint.getColor();
  }

  public final float getProgress() {
    return progress;
  }

  public final void setProgress(float progress) {
    this.progress = progress;
    invalidate();
  }

  public final boolean getDrawCap() {
    return drawCap;
  }

  public final void setDrawCap(boolean drawCap) {
    this.drawCap = drawCap;
  }

  public final float getDiameterFraction() {
    return diameterFraction;
  }

  public final void setDiameterFraction(float diameterFraction) {
    this.diameterFraction = diameterFraction;
  }

  public int getCapWidth() {
    return capWidth;
  }

  public void setCapWidth(int capWidth) {
    this.capWidth = capWidth;
  }

  public int getCapLength() {
    return capLength;
  }

  public void setCapLength(int capLength) {
    this.capLength = capLength;
  }

  protected final void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (canvas != null) {
      float width = ((float) getWidth()) * this.diameterFraction;
      int i = (int) (width / 2.0f);
      this.greyPaint.setStrokeWidth(width);
      this.ringFillPaint.setStrokeWidth(width);
      this.capPaint3.setStrokeWidth(width + ((float) this.capWidth));
      float f = (float) i;
      this.rect.set(f, f, (float) (getWidth() - i), (float) (getHeight() - i));
      canvas.drawArc(this.rect, 0.0f, 360.0f, false, this.progress >= 1.0f ? this.ringFillPaint : this.greyPaint);
      if (this.progress > 0.0f) {
        if (this.drawCap) {
          canvas.drawArc(this.rect, 0.0f, ((this.progress * 360.0f) + ((float) this.capLength)) % 360.0f, false, this.capPaint3);
        }
        canvas.drawArc(this.rect, 0.0f, (this.progress * 360.0f) % 360.0f, false, this.ringFillPaint);
      }
    }
  }

}

