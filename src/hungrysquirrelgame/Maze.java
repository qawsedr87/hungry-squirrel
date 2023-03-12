package hungrysquirrelgame;


import hungrysquirrelgame.helpers.CONST;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author louise
 */
public class Maze {

    public static Entity[][] maze = new Entity[CONST.MAX_MAZE_ROW][CONST.MAX_MAZE_COLUMN];
    
    
    public static void create(String filename) throws IOException {
        
        // read file: Maze.txt
        
        try {
            String path = String.format("%s/%s", System.getProperty("user.dir"), filename);
            
            File file = new File(path);
            Scanner in = new Scanner(file); 
            
            int row = 0;
            
            
            while(in.hasNextLine() && row < CONST.MAX_MAZE_ROW) {
                String line = in.nextLine();
                
                for (int c = 0; c < CONST.MAX_MAZE_COLUMN; c++) {
                    if (line.charAt(c) == '*') {
                        var w = new Wall(row, c);
                        maze[row][c] = w;
                        
                        w.create();
                        
                    } else maze[row][c] = null;
                }
                row++;
            }
            
            in.close();
            
        } catch (IOException e) {
            
            throw new IOException(String.format(
                    CONST.ERROR_MSG_READ_FILE, 
                    e.getMessage())
            ); 
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
