package org.androidtown.rain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stage extends View {

  private final int RAINDROPS_MAX = 20;
  private boolean isStart = false;
  List<RainDrop> rainDrops;
  Random random;
  private boolean clickedStop = false;

  Paint[] paints = new Paint[]{
    new Paint(), new Paint(), new Paint(), new Paint(),
  };

  public Stage(Context context, int cx, int cy) {
    super(context);
    rainDrops = new ArrayList<>();
    random = new Random();
    paints[0].setColor(Color.RED);
    paints[1].setColor(Color.BLUE);
    paints[2].setColor(Color.GREEN);
    paints[3].setColor(Color.MAGENTA);
    for (int i = 0; i < RAINDROPS_MAX; ++i) {
      RainDrop rainDrop = new RainDrop(cx, cy);
      rainDrop.start();
      rainDrops.add(rainDrop);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (isStart) {
      drawStage(canvas);
    }
  }

  private void drawStage(Canvas canvas) {
    for (int i = 0; i < rainDrops.size(); ++i) {
      RainDrop rainDrop = rainDrops.get(i);
      if(!clickedStop) {
        rainDrop.paint = paints[random.nextInt(4)];
      }
      canvas.drawCircle(rainDrop.getX(), rainDrop.getY(), rainDrop.getRadius(), rainDrop.paint);
    }
    invalidate();
  }

  public void start() {
    if (!isStart) isStart = true;
    for (int i = 0; i < RAINDROPS_MAX; ++i) {
      RainDrop rainDrop = rainDrops.get(i);
      rainDrop.doRun(true);
    }
    clickedStop = false;
    invalidate();
  }

  public void stop() {
    for (int i = 0; i < RAINDROPS_MAX; ++i) {
      RainDrop rainDrop = rainDrops.get(i);
      rainDrop.doRun(false);
    }
    clickedStop = true;
  }
}
