package hungrysquirrelgame;

import hungrysquirrelgame.helpers.CONST;


/**
 *
 * @author louise
 */
public class Squirrel extends Entity implements Moveable {

    private int pointsCollected;
    private int totalNutsEaten; // Max is 5
    
    private int totalPoisonsEaten;
    
    
    public Squirrel(int newRow, int newColumn) {
        
        super('@', newRow, newColumn);
        
        this.pointsCollected = 0;
        this.totalNutsEaten = 0;
        this.totalPoisonsEaten = 0;
    }
    
    public int getPointsCollected() {
        return pointsCollected;
    }
    
    public int getTotalNutsEaten() {
        return totalNutsEaten;
    }

    public int getTotalPoisonsEaten() {
        return totalPoisonsEaten;
    }
    
    @Override
    public void create() {
        int row = getRow() - 1;
        int col = getColumn() - 1;
        
        setRow(row);
        setColumn(col);
        Maze.getMaze()[row][col] = this;
    }

    @Override
    public void move(char direction) {

        int row = getRow();
        int col = getColumn();
        
//        System.out.println("Current...." + row + " " + col + "\n");
        
        Entity entity = Maze.getMaze()[row][col] = this;
        
        switch (direction) {
            case 'u' -> row--;
            case 'd' -> row++;
            case 'l' -> col--;
            case 'r' -> col++;
            default -> {
                System.out.println(CONST.ERROR_MSG_DIRECTION);
                System.out.print(CONST.ENTER_COMMAND);
            }
        }
        
        if (Maze.getMaze()[row][col] instanceof Wall) {
            System.out.println(CONST.ERROR_MSG_MOVE_TO_WALL);
            
            
            // change back because go to the wrong way
            switch (direction) {
                case 'u' -> row++;
                case 'd' -> row--;
                case 'l' -> col++;
                case 'r' -> col--;
                default -> {
                    // doesn't happen
                    System.out.println(CONST.ERROR_MSG_DIRECTION);
                    System.out.print(CONST.ENTER_COMMAND);
                }
            }
//            System.out.println("Change: Current...." + row + " " + col + "\n");
            
        } else {
            Entity nextEntity = Maze.getMaze()[row][col];

            if (nextEntity instanceof Nut) {
                int gained = ((Nut) nextEntity).getNutritionPoints();

                pointsCollected += gained;
                totalNutsEaten++;

                System.out.printf(CONST.GET_POINTS,
                        ((Nut) nextEntity).getName(),
                        gained,
                        pointsCollected);
//                System.out.printf("!!! Got %d nuts !!!\n",
//                        totalNutsEaten);
                
            } else if (nextEntity instanceof PoisonousCashew) {
                
                pointsCollected *= -1;
                totalPoisonsEaten++;
                
//                System.out.println(Consts.LOST_POINTS + pointsCollected);
            }
            
            entity.put(row, col);
            
        }
        
        Maze.display();
        
        if (totalNutsEaten != 5 && totalPoisonsEaten == 0) 
            System.out.print(CONST.ENTER_COMMAND); 
       
    }
    
    @Override
    public String toString() {
        return String.format(CONST.PRINT_SQUIRREL, 
                getSymbol(),
                getRow(),
                getColumn(),
                pointsCollected);
    }
    
}
