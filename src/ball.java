import java.awt.*;
import java.awt.Rectangle;
import java.util.Random;

public class ball extends Rectangle {
    Color color;
    boolean right;
    boolean up;
    Random random;
    int fall_speed;
    static int ball_speed = 3;
   public ball(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        random = new Random();

   }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void right(){
       if(right && up){
           x = x + ball_speed;
           y = y + fall_speed;
       }
       else if(right && !up) {
           x = x + ball_speed;
           y = y - fall_speed;
       }
       else if (!up){
           x = x - ball_speed;
           y = y - fall_speed;
           }
       else {
           x = x - ball_speed;
           y = y + fall_speed;
       }
    }

}
