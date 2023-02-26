import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class game_frame extends JFrame implements KeyListener{

    static int movement_speed = 10;
    Player player;
    Player enemy;
    Player player2;

    ball ball;
    game_panel panel;
    Graphics graphics;
/*
    public static int DELAY = 1000/60;
    Timer timer = new Timer(DELAY, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ball.right();
            check_collision();
            repaint();

        }

    });
*/

    public game_frame(){

        setTitle("Game Frame");
        setDefaultCloseOperation(3);
        setSize(300, 300);
        panel = new game_panel();
        add(panel);
/*        player = new Player(130,150,20,20, Color.blue);*/
/*
        enemy = new Player(60, 60, 30, 80, Color.red);
*/
/*        player2 = new Player(150, 150, 60, 60, Color.white);
        ball = new ball(150, 150, 20, 20, Color.red);*/
        setVisible(true);
        addKeyListener(this);
/*        timer.setRepeats(true);
        timer.start();*/
    }

/*    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0, getWidth(), getHeight());
*//*
        enemy.draw(g);
*//*
        player2.draw(g);
        player.draw(g);
        ball.draw(g);

    }*/
/*
    public void check_collision(){

        if (player.intersects(ball)){
            System.out.println("Nice");
            player.color = Color.GREEN;
            if(ball.right){ ball.right = false; }
            else{ ball.right = true; }
        }

    }*/



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        panel.keyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
