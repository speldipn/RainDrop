package org.androidtown.rain;

import java.util.Random;

public class RainDrop extends Thread {

  private final float RADIUS_MIN = 10f;
  private final float RADIUS_MAX = 30f;
  private final int SPEED_MIN = 20;
  private final int SPEED_MAX = 30;

  private float radius;
  private int speed;
  private int x;
  private int y;
  private int cx;
  private int cy;
  private boolean isStop;

  public RainDrop(int cx, int cy) {
    Random random = new Random();
    this.cx = cx;
    this.cy = cy;
    this.x = random.nextInt(cx);
    this.y = 0;
    this.radius = RADIUS_MIN + (random.nextFloat() * RADIUS_MAX); // 0.x ~ 9.x
    this.speed = random.nextInt(SPEED_MAX) + SPEED_MIN;
    this.isStop = true;
  }

  @Override
  public void run() {
    while (true) {
      if (!isStop) {
        y += speed;
        sleep(100);
        if (this.y > cy) {
          y = 0;
        }
      }
      sleep(50);
    }
  }

  private void sleep(int msec) {
    try {
      Thread.sleep(msec);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public float getRadius() {
    return radius;
  }

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

  public void doRun(boolean b) {
    if (b) {
      isStop = false;
    } else {
      isStop = true;
    }
  }
}
