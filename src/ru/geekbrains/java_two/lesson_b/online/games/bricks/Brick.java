package ru.geekbrains.java_two.lesson_b.online.games.bricks;

import ru.geekbrains.java_two.lesson_b.online.games.common.GameCanvas;
import ru.geekbrains.java_two.lesson_b.online.games.common.Sprite;

import java.awt.*;

public class Brick extends Sprite {
    private final Color color = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );
    private float vX = (float)(100f + (Math.random() * 200f));
    private float vY = (float)(100f + (Math.random() * 200f));

    Brick() {
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
    }

    Brick(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(GameCanvas canvas, float deltaTime) {

    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.drawRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
}
