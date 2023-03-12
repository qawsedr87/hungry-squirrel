package hungrysquirrelgame.helpers;


import hungrysquirrelgame.Maze;
import java.util.Scanner;

/**
 *
 * @author louise
 */
public class ScannerHelper {
    public static int[] scannerSquirrelCreate() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(CONST.ENTER_SQUIRREL_SPOT);

        while(keyboard.hasNextLine()) {
            String input = keyboard.nextLine();
         
            String[] positions = input.split(",");
            
            // check format
            if (positions.length != 2 
                    || !Character.isDigit(positions[0].charAt(0))
                    || !Character.isDigit(positions[1].charAt(0))
            ) {
                System.out.println(CONST.ERROR_MSG_FORMAT);
                
                System.out.print(CONST.ENTER_SQUIRREL_SPOT);
        
                continue;
            } 
            
            int row = Integer.parseInt(positions[0].trim());
            int col = Integer.parseInt(positions[1].trim());

            // check the position
            if (row > CONST.MAX_MAZE_ROW
                || row <= 0 
                || col > CONST.MAX_MAZE_COLUMN
                || col <= 0
                || !Maze.available(row, col)) {
                
                System.out.println(CONST.ERROR_MSG_NOT_AVAILABLE_SPOT);
                
                System.out.print(CONST.ENTER_SQUIRREL_SPOT);

            } else {
                System.out.println(CONST.SPOT_AVAILABLE);
                return new int[] { row, col };
            }
        }
        
        keyboard.close();
        
        return new int[] {};
    }
    
}
