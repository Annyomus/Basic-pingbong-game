import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class game_panel extends JPanel implements KeyListener {
    static int movement_speed = 10;
    Player player;
    Player enemy;
    Random random;
    Player player2;
    Player wallUp;
    Player wallDown;

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

        }

    });


    public game_panel(){

        setSize(300, 300);
        JPanel panel = new JPanel();

        player = new Player(0,0,20,50, Color.white);
        player2 = new Player(260, 0, 20, 50, Color.white);
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
                ball.fall_speed = random.nextInt(1, 4);
            }
            else{ ball.right = true; ball.up = random_up_down;
                ball.fall_speed = random.nextInt(1, 4);

            }
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        player2.KeyPressed2(e);
        player.KeyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
