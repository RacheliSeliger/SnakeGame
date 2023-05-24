//package il.co.lird.FS133.WS;

public interface IPlayer {
     void initialize(int width, int height);
     void move();
     void setLastDirection();
     boolean containsPositionInBoard(int x, int y) ;
     boolean collidesWith(IFood food);
     void updateEatenFood();
     void setDirection(String newDirection) ;
     boolean isValidDirection(String newDirection);

}
