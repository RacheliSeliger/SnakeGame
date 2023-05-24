//package il.co.lird.FS133.WS;

import java.util.Random;
import java.util.Scanner;

public class Board implements IGraphic {
    private static final int WIDTH = 10;  // Width of the game grid
    private static final int HEIGHT = 10; // Height of the game grid

    IPlayer snake = null;
    IFood food = null;

    public Board(IPlayer snake, IFood food)
    {
        this.snake = snake;
        this.food = food;
    }

    public void welcomeMessage() {
        System.out.println("\u001B[31m Welcome to Snake Game! \u001B[0m");
        System.out.println("Use [A] + enter to move left, [D] + enter to move right, press [Q] to quit. \n");
        System.out.println("Press Enter to play. \n");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public String readKeyInput() {
        try {
            if (System.in.available() > 0) {
                byte[] bytes = new byte[System.in.available()];
                System.in.read(bytes);
                return new String(bytes).trim().toLowerCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return " ";
    }

     public void printGameBoard() {
        clearConsole();
        // Print the top border
        for (int i = 0; i < WIDTH + 2; i++) {
            System.out.print("# ");
        }
        System.out.println();

        // Print the game board
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print("# "); // Left border
            for (int j = 0; j < WIDTH; j++) {
                if (snake.containsPositionInBoard(j, i)) {
                    System.out.print("\u001B[33m* \u001B[0m"); //  snake
                } else if (food.getPositionX() == j && food.getPositionY() == i) {
                    System.out.print("\u001B[32m$ \u001B[0m"); //  food
                } else {
                    System.out.print("\u001B[31m  \u001B[0m"); //  wall
                }
            }
            System.out.print("#"); // Right border
            System.out.println();
        }

        // Print the bottom border
        for (int i = 0; i < WIDTH + 2; i++) {
            System.out.print("# ");
        }
        System.out.println();
    }

     public void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();

        } catch (Exception ignored) {

        }
    }

    public void randomPlaceFood() {
        Random random = new Random();
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);
        food.setPosition(x, y);
    }
}
