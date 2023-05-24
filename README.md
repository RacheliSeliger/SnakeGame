# SnakeGame
A simple implementation of the classic Snake Game in the console, designed using object-oriented programming principles.
Control a snake to eat food and grow longer while avoiding collisions with walls and itself.

## How To Play
1. Run the program to display the game board in the console.
2. Use arrow keys to control the snake's movement.
*  ``` W ``` or ``` w ```: Move the snake up
*  ``` S ``` or ``` s ```: Move the snake down
*  ``` A ``` or ``` a ```: Move the snake left
* ``` D ``` or ``` d ```: Move the snake right
 After each navigation, press ```Enter``` to confirm the movement.
4. Eat the food ('$' symbol) to grow longer and increase your score.
5.The game ends if the snake collides with a wall or itself.

## How to Run
1. Download or clone the repository.
2. Open a console or terminal and navigate to the project directory.
3. Compile the source files:
``` java 
javac SnakeGame.java
```

4. Run the game:
``` java
java SnakeGame
```

##  Object-Oriented Design

The game is composed of the following components:

* SnakeGame: Controls the game flow and user input. It starts the game and manages the interactions between the board, snake, and food.
* Board: Represents the game board and handles collisions. It implements the IGraphic interface for custom graphics display.
* Snake: Represents the snake entity with movement and growth. It implements the IPlayer interface for customizable behavior.
* Apple: Represents the food entity with random position generation. It implements the IFood interface for custom food types.

By implementing the below interfaces, you can change the behavior and appearance of the game components.
