import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class Main {
    JFrame displayZoneFrame;
    //GameRender renderEngine;
    RenderEngine renderEngine;
    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        renderEngine = new RenderEngine();
        displayZoneFrame.getContentPane().add(renderEngine);
        BufferedImage treeImage = ImageIO.read(new File("img/tree.png"));
        Sprite tree = new SolidSprite(treeImage, 200, 300, 64, 64);
        renderEngine.addToRenderList(tree);
        BufferedImage rockImage = ImageIO.read(new File("img/rock.png"));
        SolidSprite rock = new SolidSprite(rockImage, 100, 150, 50, 50);
        renderEngine.addToRenderList(rock);
        BufferedImage heroImage = ImageIO.read(new File("img/heroTileSheet.png"));
        DynamicSprite hero = new DynamicSprite(heroImage, 100, 100, 64, 64, Direction.EAST);
        hero.setDirection(Direction.WEST);
        System.out.println("Direction actuelle : " + hero.getDirection());
        System.out.println("Ligne de la frame associée : " + hero.getDirection().getFrameLineNumber());
        Sprite testDynamicSprite = new DynamicSprite(
                ImageIO.read(new File("img/heroTileSheet.png")),
                200, 300,
                64, 64,
                Direction.SOUTH
        );
        renderEngine.addToRenderList(testDynamicSprite);
        Timer renderTimer = new Timer(50, (time) -> renderEngine.update());
        renderTimer.start();
        displayZoneFrame.setVisible(true);
    }
    public static void main (String[] args) throws Exception {
        Main main = new Main();
    }

}
