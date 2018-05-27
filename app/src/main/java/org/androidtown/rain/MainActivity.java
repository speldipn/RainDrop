package org.androidtown.rain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

  FrameLayout frameLayout;
  Switch rainSwitch;
  Stage stage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    init();
  }

  private void init() {
    frameLayout = findViewById(R.id.frameLayout);
    rainSwitch = findViewById(R.id.rainSwitch);
    rainSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
          start();
        } else {
          stop();
        }
      }
    });

    DisplayMetrics metrics = getResources().getDisplayMetrics();
    int stageWidth = metrics.widthPixels;
    int stageHeight = stageWidth;
    stage = new Stage(this, stageWidth, stageHeight);
    frameLayout.addView(stage);
  }


  private void start() {
    stage.start();
  }

  private void stop() {
    stage.stop();
  }

}
