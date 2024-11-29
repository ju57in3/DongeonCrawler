import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameRender extends JPanel implements Engine {
    private List<Sprite> sprites;
    public GameRender() {
        super();
        sprites = new ArrayList<>();
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }
    @Override
    public void update() {
        System.out.println("GameRender update called");

        repaint();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        for (Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }
}
