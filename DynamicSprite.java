import java.awt.*;

public class DynamicSprite extends SolidSprite {
    private boolean isWalking = true;
    private double speed = 5;
    private final int spriteSheetNumberOfColumn = 10;
    private int timeBetweenFrame = 200;
    private Direction direction;
    public DynamicSprite(Image image, double x, double y, double width, double height, Direction direction) {
        super(image, x, y, width, height);
        this.direction = direction;
    }
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getTimeBetweenFrame() {
        return timeBetweenFrame;
    }

    public void setTimeBetweenFrame(int timeBetweenFrame) {
        this.timeBetweenFrame = timeBetweenFrame;
    }

    public boolean isWalking() {
        return isWalking;
    }

    public void setWalking(boolean walking) {
        isWalking = walking;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getSpriteSheetNumberOfColumn() {
        return spriteSheetNumberOfColumn;
    }

    @Override
    public void draw(Graphics g) {
        if (direction == null) {
            return;
        }

        int frameLine = direction.getFrameLineNumber();
        int frameColumn = (int) ((System.currentTimeMillis() / timeBetweenFrame) % spriteSheetNumberOfColumn);

        int frameWidth = (int) getWidth();
        int frameHeight = (int) getHeight();

        g.drawImage(
                getImage(),
                (int) getX(),
                (int) getY(),
                (int) (getX() + frameWidth),
                (int) (getY() + frameHeight),
                frameColumn * frameWidth,
                frameLine * frameHeight,
                (frameColumn + 1) * frameWidth,
                (frameLine + 1) * frameHeight,
                null
        );
}
