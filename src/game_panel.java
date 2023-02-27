import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class game_panel extends JPanel implements KeyListener {
    static int movement_speed = 10;
    Player player;
    Player enemy;
    Random random;
    Player player2;
    Player wallUp;
    Player wallDown;
    private Set<Integer> pressedKeysP1;
    private Set<Integer> pressedKeysP2;

    ball ball;
    Graphics graphics;


   // UPDATER WITH FPS
    public static int FPS = 1000/60;


    Timer timer = new Timer(FPS, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ball.right();
            check_collision();
            repaint();
            if (pressedKeysP1.contains(KeyEvent.VK_W)) {
                player.moveUp();
            }
            else if (pressedKeysP1.contains(KeyEvent.VK_S)) {
                player.moveDown();
            }
            if (pressedKeysP2.contains(KeyEvent.VK_UP)) {
                player2.moveUp();
            }
            else if (pressedKeysP2.contains(KeyEvent.VK_DOWN)) {
                player2.moveDown();
            }
        }

    });


    public game_panel(){
        pressedKeysP1 = new HashSet<>();
        pressedKeysP2 = new HashSet<>();
        setSize(300, 300);
        JPanel panel = new JPanel();

        player = new Player(0,120,20,50, Color.white);
        player2 = new Player(260, 120, 20, 50, Color.white);
        ball = new ball(150, 150, 20, 20, Color.red);
        wallUp = new Player(getX(), getY(), getWidth(), 10, Color.YELLOW);
        wallDown = new Player(0,260, getWidth(), 10, Color.YELLOW);

        setVisible(true);
        addKeyListener(this);
        timer.setRepeats(true);
        timer.start();
        random = new Random();



    }

    @Override
    public void paint(Graphics g) {
       //background color!
        g.fillRect(0,0, getWidth(), getHeight());
       // drawing players!
        player2.draw(g);
        player.draw(g);
        // drawing ball!
        ball.draw(g);
        wallUp.draw(g);
        wallDown.draw(g);

    }

    public void check_collision(){

        //Wall Collision
        if (wallDown.intersects(ball)){
            ball.up = false;
        }
        else if (ball.intersects(wallUp)){
            ball.up = true;
        }
        // Player Collision
        if (player.intersects(ball) || player2.intersects(ball)){
            boolean random_up_down = random.nextBoolean();

            System.out.println(random_up_down);

            if(ball.right){
                ball.right = false;
                ball.up = random_up_down;
                ball.fall_speed = random.nextInt(3, 6);
            }
            else{ ball.right = true; ball.up = random_up_down;
                ball.fall_speed = random.nextInt(3, 6);

            }
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("test");
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            pressedKeysP1.remove(keyCode);
        }
        if (keyCode == KeyEvent.VK_S) {
            pressedKeysP1.remove(keyCode);
        }
        if (keyCode == KeyEvent.VK_UP) {
            pressedKeysP2.remove(keyCode);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            pressedKeysP2.remove(keyCode);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            pressedKeysP1.add(keyCode);
        }
        if (keyCode == KeyEvent.VK_S) {
            pressedKeysP1.add(keyCode);
        }
        if (keyCode == KeyEvent.VK_UP) {
            pressedKeysP2.add(keyCode);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            pressedKeysP2.add(keyCode);
        }

    }

}
