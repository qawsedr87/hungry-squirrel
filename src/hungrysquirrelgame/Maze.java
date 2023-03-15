package hungrysquirrelgame;


import hungrysquirrelgame.exception.ResourceException;
import hungrysquirrelgame.helpers.CONST;
import hungrysquirrelgame.helpers.FileResource;


/**
 *
 * @author louise
 */
public class Maze {

    public static Entity[][] maze = new Entity[CONST.MAX_MAZE_ROW][CONST.MAX_MAZE_COLUMN];
    
    public static void create(String filename) {
        FileResource fr = new FileResource(filename);
        String initMazes = fr.asString();
        
        if (initMazes.isEmpty()) 
            throw new ResourceException(CONST.ERROR_MSG_FILERESOURCE + filename);
            
        String[] mazes = initMazes.split("\n");

        int row = 0;
        
        // 20 
        while(row < mazes.length) {
            // 50 
            String line = mazes[row];
            if (mazes.length != 20 || line.length() != 50) 
                throw new ResourceException(CONST.ERROR_MSG_FILERESOURCE + filename);
        
            
            for (int c = 0; c < line.length(); c++) {
                if (line.charAt(c) == '*') {
                    // build the wall
                    Wall wall = new Wall(row, c);
                    wall.create();
                    
                    maze[row][c] = wall;
                } else {
                    maze[row][c] = null;
                }
            }
            row++;
            
        }
    }
    
    
    public static void display() {

        for (int r = 0; r < CONST.MAX_MAZE_ROW; r++) {
            for (int c = 0; c < CONST.MAX_MAZE_COLUMN; c++) {
                Entity entity = maze[r][c];
                
                if (entity == null) 
                    System.out.print(" ");
                else System.out.print(entity.getSymbol());
                
            }
            
            System.out.println();
        }
        System.out.println();
    }

    public static boolean available(int row, int col) {
        row -= 1;
        col -= 1;
        
//        System.out.println("Check Spot...." + row + " " + col + "\n");
     
        if (maze[row][col] != null) {
//            System.out.println(String.format("Maze available: symbol %s, row %d, col %d", 
//                maze[row][col].getSymbol(),
//                maze[row][col].getRow(),
//                maze[row][col].getColumn()));
            
            return false;
        }
        
        return maze[row][col] == null;
        
    }
    
    public static Entity[][] getMaze() {
        return maze;
    }
    
}
