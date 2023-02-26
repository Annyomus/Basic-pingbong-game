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

    public void KeyPressed(KeyEvent e) {
        char key_pressed = e.getKeyChar();

        if (key_pressed == 'w') {
            this.y = y - 10;
        }
        if (key_pressed == 's') {
            this.y = y + 10;
        }
/*        if (key_pressed == 'd'){
            this.x = x + 10;
        }
        if (key_pressed == 'a'){
            this.x = x - 10;
        }*/

    }
    public void KeyPressed2(KeyEvent e){

        if (e.getKeyCode() == KeyEvent.VK_UP){
            this.y = y - 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.y = y + 10;
        }
/*        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.x = x + 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.x = x - 10;*/
        }
}

