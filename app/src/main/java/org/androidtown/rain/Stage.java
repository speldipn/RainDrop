package org.androidtown.rain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Stage extends View {

  private final int RAINDROPS_MAX = 20;
  private boolean isStart = false;
  List<RainDrop> rainDrops;

  // 물방울 색
  Paint paint;

  public Stage(Context context, int cx, int cy) {
    super(context);
    rainDrops = new ArrayList<>();
    paint = new Paint();
    paint.setColor(Color.BLUE);
    for (int i = 0; i < RAINDROPS_MAX; ++i) {
      RainDrop rainDrop = new RainDrop(cx, cy);
      rainDrop.start();
      rainDrops.add(rainDrop);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if(isStart) {
      drawStage(canvas);
    }
  }

  private void drawStage(Canvas canvas) {
    for (int i = 0; i < rainDrops.size(); ++i) {
      RainDrop rainDrop = rainDrops.get(i);
      canvas.drawCircle(rainDrop.getX(), rainDrop.getY(), rainDrop.getRadius(), paint);
    }
    invalidate();
  }

  public void start() {
    if(!isStart)isStart = true;
    for (int i = 0; i < RAINDROPS_MAX; ++i) {
      RainDrop rainDrop = rainDrops.get(i);
      rainDrop.doRun(true);
    }
    invalidate();
  }

  public void stop() {
    for (int i = 0; i < RAINDROPS_MAX; ++i) {
      RainDrop rainDrop = rainDrops.get(i);
      rainDrop.doRun(false);
    }
  }
}
