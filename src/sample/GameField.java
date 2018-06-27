package sample;

import javafx.scene.control.Cell;

import java.awt.*;
import java.util.Random;

public class GameField {

    private final int SIZE_CELL 64;
    private final int FIELD_SIZE 50;

    private static Cell[][] cells;

    private Point[] snake;
    private Point applePosition;

    public GameField() {

    }

    public void newRound() {
        Random random = new Random();
        applePosition = new Point();
        applePosition.x = random.nextInt(FIELD_SIZE);
        applePosition.y = random.nextInt(FIELD_SIZE);
    }

    public void update(Controller.Key currentKey) {

        for (int i = snake.length; i > 0; i--) {
            snake[i].x = snake[i-1].x;
            snake[i].y = snake[i - 1].y;
        }

        switch (currentKey) {
            case Left:
                snake[0].x--;
                break;
            case Right:
                snake[0].x++;
                break;
            case Up:
                snake[0].y--;
                break;
            case Down:
                snake[0].y++;
                break;
        }

        checkApple();
        checkCollisions();
    }

    private void checkCollisions() {

        if (snake[0].x < 0 || snake[0].x >= FIELD_SIZE || snake[0].y < 0 || snake[0].y >= FIELD_SIZE) {
            //System.exit(1);
        }
    }

    private void checkApple() {

    }


}
