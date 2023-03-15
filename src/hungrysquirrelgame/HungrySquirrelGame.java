
package hungrysquirrelgame;


import hungrysquirrelgame.helpers.CONST;
import hungrysquirrelgame.helpers.ScannerHelper;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author louise
 */
public class HungrySquirrelGame {
    public static void main(String[] args) throws IOException {
        
        // maze
        Maze.create("Maze.txt");
        Maze.display();
        
        // squirrel
        int[] squirrelInput = ScannerHelper.scannerSquirrelCreate();
        
        Squirrel squirrel = new Squirrel(squirrelInput[0], squirrelInput[1]);
        squirrel.create();
        
        // nuts and poisons
        Nut.generatedNuts(Nut.getTotalNuts());
  
        PoisonousCashew.generatedPoisons(PoisonousCashew.getTotalPoisons());
        
        System.out.println(CONST.ENTER_MOVE_COMMAND); 
        
        Maze.display();
        
        // move
        Scanner keyboard = new Scanner(System.in);
        System.out.print(CONST.ENTER_COMMAND);
        
        while(keyboard.hasNextLine()) {
            String input = keyboard.nextLine();
            
            if (input.equalsIgnoreCase(CONST.QUIT)) break;
            
            
            if (input.isEmpty() 
                    || input.trim().isEmpty()
                    || !CONST.SQUIRREL_MOVE_COMMANDS.contains(
                            input.toLowerCase().charAt(0)
                    )) {
                System.out.println(CONST.ERROR_MSG_MOVE_COMMAND);
                
                System.out.print(CONST.ENTER_COMMAND);
        
                continue;
            } 
          
            
            squirrel.move(input.toLowerCase().charAt(0));
            
            if (squirrel.getTotalPoisonsEaten() > 0) {
                System.out.printf(CONST.END_FAILED,
                        squirrel.getPointsCollected());
                break;
            }
            
            if (squirrel.getTotalNutsEaten() == 5) {
                System.out.printf(CONST.END_SUCCESSFUL,
                    squirrel.getPointsCollected());
                break;
            }
            
        }
        
        keyboard.close();
       
    }
    
}
