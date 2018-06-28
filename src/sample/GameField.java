package sample;

import javafx.scene.control.Cell;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameField {

    public final int SIZE_CELL 64;
    public final int FIELD_SIZE 50;

    private static Cell[][] cells;

    private ArrayList<Point> snake;
    private Point applePosition;

    public GameField() {
        snake = new ArrayList<>();
    }

    public void newRound() {
        Random random = new Random();

        Point newPosition = new Point();
        snake.clear();
        applePosition = new Point();
        applePosition.x = random.nextInt(FIELD_SIZE);
        applePosition.y = random.nextInt(FIELD_SIZE);
        newPosition.x = random.nextInt(FIELD_SIZE);
        newPosition.y = random.nextInt(FIELD_SIZE);
        snake.add(newPosition);
    }

    public void update(Controller.Key currentKey) {

        if (snake.size() > 1) {
            for (int i = snake.size(); i > 0; i--) {
                Point last = snake.get(i);
                Point first = snake.get(i - 1);
                last.x = first.x;
                last.y = first.y;
            }
        }

        switch (currentKey) {
            case Left:
                snake.get(0).x--;
                break;
            case Right:
                snake.get(0).x++;
                break;
            case Up:
                snake.get(0).y--;
                break;
            case Down:
                snake.get(0).y++;
                break;
        }

        checkApple();
        checkCollisions();
    }

    private void checkCollisions() {
        Point head = snake.get(0);

        Boolean collision = false;
        for (int i = 1; i < snake.size(); i++) {
            Point p = snake.get(i);
            if (p.x == head.x && p.y == head.y) {
                collision = true;
                break;
            }
        }

        if (collision || head.x < 0 || head.x >= FIELD_SIZE || head.y < 0 || head.y >= FIELD_SIZE) {
            System.out.printf("GAME OVER");
        }
    }

    private void checkApple() {
        Point head = snake.get(0);
        if (head.x == applePosition.x && head.y == applePosition.y) {
            snake.add(applePosition);

            Random random = new Random();
            applePosition = new Point();
            applePosition.x = random.nextInt(FIELD_SIZE);
            applePosition.y = random.nextInt(FIELD_SIZE);
        }
    }


}
