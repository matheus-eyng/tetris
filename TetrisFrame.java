import javax.swing.JFrame;

public class TetrisFrame extends JFrame {
    
    private Tetris game;
    
    public TetrisFrame() {
        super("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(12*26+10, 26*23+25);
        setVisible(true);

        add(game);
    }

    public void refresh() {
        game = new Tetris();
    }

    public void jogar() {
        game.init();
    }
}