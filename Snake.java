//package il.co.lird.FS133.WS;


import java.util.ArrayList;
import java.util.List;

class Snake implements IPlayer {
    private int width;
    private int height;
    private int length;
    private String direction;
    private String lastDirection;
    private List<BodyPart> body;

    public Snake() {
        length = 1;
        direction = "a";
        lastDirection = direction;
        body = new ArrayList<>();
    }

    public void initialize(int width, int height) {
        this.width = width;
        this.height = height;
        int initialX = width / 2;
        int initialY = height / 2;
        body.clear();
        body.add(new BodyPart(initialX, initialY));
    }

    public void move() {
        int headX = body.get(0).getX();
        int headY = body.get(0).getY();
        if (direction.equals(" ")) {
            direction = lastDirection;
        }

        switch (direction) {

            case "w":
                headY--;
                break;
            case "s":
                headY++;
                break;
            case "a":
                headX--;
                break;
            case "d":
                headX++;
                break;
        }
        setLastDirection();

        // Check if the snake touches the wall or itself
        if (headX < 0 || headX >= width || headY < 0 || headY >= height || containsPositionInBoard(headX, headY)) {
            System.out.println("Game Over!");
            SnakeGame.isRunning = false;
            System.exit(0); // Terminate the program
        }

        // Update the positions of the snake's body parts
        for (int i = length - 1; i > 0; i--) {
            BodyPart currentPart = body.get(i);
            BodyPart previousPart = body.get(i - 1);
            currentPart.setX(previousPart.getX());
            currentPart.setY(previousPart.getY());
        }

        // Update the position of the snake's head
        body.get(0).setX(headX);
        body.get(0).setY(headY);
    }

    public void setLastDirection() {
        lastDirection = direction;
    }

    public boolean containsPositionInBoard(int x, int y) {
        for (BodyPart part : body) {
            if (part.getX() == x && part.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean collidesWith(IFood food) {
        int headX = body.get(0).getX();
        int headY = body.get(0).getY();
        return headX == food.getPositionX() && headY == food.getPositionY();
    }

    public void updateEatenFood() {
        length++;
        body.add(new BodyPart(-1, -1)); // Placeholder position, will be updated on the next move
    }

    public void setDirection(String newDirection) {
        direction = newDirection;

    }

     public boolean isValidDirection(String newDirection) {
        return newDirection.equals("w") || newDirection.equals("a")
                || newDirection.equals("s") || newDirection.equals("d");
    }
}