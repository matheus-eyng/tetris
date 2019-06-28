import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrisPanel extends JFrame {

    Tetris game;

    public TetrisPanel() {
        super("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(12*26+10, 26*23+25);
        game = new Tetris();
        /* game.init(); */
        add(game);
        

        
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    game.rotate(-1);
                    break;
                case KeyEvent.VK_DOWN:
                    game.rotate(+1);
                    break;
                case KeyEvent.VK_LEFT:
                    game.move(-1);
                    break;
                case KeyEvent.VK_RIGHT:
                    game.move(+1);
                    break;
                case KeyEvent.VK_SPACE:
                    game.dropDown();
                    game.addScore(1);
                    break;
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        // Make the falling piece drop every half-ssecond
        new Thread() {
            @Override
            public void run() {
                while (!game.getGameOver()) {
                    try {
                        Thread.sleep(500);
                        game.dropDown();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();
    }

    public void jogar() {
        this.game.init();
    }
}
