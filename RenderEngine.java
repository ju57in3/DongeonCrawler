import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class RenderEngine extends JPanel implements Engine {
    private List<Displayable> renderList;

    public RenderEngine() {
        super();
        renderList = new ArrayList<>();
    }

    public void setRenderList(List<Displayable> renderList) {
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable) {
        renderList.add(displayable);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Displayable displayable : renderList) {
            displayable.draw(g);
        }
    }

    @Override
    public void update() {
        repaint();
    }
}