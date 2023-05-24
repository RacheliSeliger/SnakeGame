//package il.co.lird.FS133.WS;


import static java.lang.Thread.sleep;

public class SnakeGame {
    private static final int WIDTH = 10;  // Width of the game grid
    private static final int HEIGHT = 10; // Height of the game grid
    static boolean isRunning = true;

    private int score;
    private int level;
    private IPlayer snake;
    private IFood food;
     private IGraphic board;

    public SnakeGame() {
        score = 0;
        level = 1;
        snake = new Snake();
        food = new Apple();
        board = new Board(snake, food);
    }

    public void startGame() throws InterruptedException {
        board.welcomeMessage();
        snake.initialize(WIDTH, HEIGHT);
        board.randomPlaceFood();

        while (isRunning) {
            board.printGameBoard();
            System.out.println("Score: " + score + " Level: " + level);
            String input = board.readKeyInput();
            sleep(400);
            if (input.equals("q")) {
                gameOver();
            }
            if (snake.isValidDirection(input)) {
                snake.setDirection(input);
            }

            snake.move();

            if (snake.collidesWith(food)) {
                snake.updateEatenFood();
                increaseScore(10);
                if (score % 50 == 0) {
                    levelUp();
                }
                board.randomPlaceFood();
            }
        }

    }

    private void gameOver(){
        System.out.println("Game Over!");
        isRunning = false;
        System.exit(0);
    }
    private void increaseScore(int points) {
        score += points;
    }

    private void levelUp() {
        level++;
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        try {
            game.startGame();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


