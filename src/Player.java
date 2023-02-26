import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Player extends Rectangle {
    Color color;


    public Player(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics g) {

        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);

    }
    public void moveUp(){
        this.y = y - 10;
    }
    public void moveDown(){
        this.y = y + 10;
    }


}

