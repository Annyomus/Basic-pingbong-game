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

    public game_frame(){

        setTitle("Ping Bong");
        setDefaultCloseOperation(3);
        setSize(300, 300);
        panel = new game_panel();
        add(panel);

        setVisible(true);
        addKeyListener(this);

    }





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
