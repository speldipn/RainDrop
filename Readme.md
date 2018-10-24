# RainDrop

### 동작 시현
![](/screenshot/raindrop.gif)

* 비가내리는 효과를 나타내기 위해 설계하고 구현한 예제
* Thread와 View를 사용하여 구현

#### RainDrop 클래스

* 하나의 물방울을 하나의 스레드로 설계하였다.
* 난수를 사용하여 물방울의 둘레, 그리고 좌표값과 속도를 조절한다.

````java
public RainDrop(int cx, int cy)
private void setRadius()
private void setSpeed()
private void setY(int cy)
private void setX(int cx)
public int getY()
public int getX()
````

#### Stage 클래스

* 물방울을 갖고 있으면서 화면에 그려주기 위해 설계된 클래스이다.
* 물방울은 스레드 단위로 동작하기 때문에 프로그램이 동작하고 값은 자동으로 변경된다.
* 원을 그리기 위해 필요한 정보들을 물방울 인스턴스로부터 가져와 화면에 그려준다.

````java
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
````

