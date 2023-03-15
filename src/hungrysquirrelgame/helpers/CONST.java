/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hungrysquirrelgame.helpers;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author louise
 */
public class CONST {
    
    // VALUES
    public static final HashSet<Character> SQUIRREL_MOVE_COMMANDS = new HashSet<>(
            Arrays.asList('u', 'd', 'l', 'r')
    );
    public static final int MAX_MAZE_ROW = 20;
    public static final int MAX_MAZE_COLUMN = 50;
    
    
    
    // Steps Messages
    public static final String ENTER_COMMAND = "Enter command: ";
    public static final String ENTER_SQUIRREL_SPOT = "Enter the Squirrel position (row, column): ";
    public static final String ENTER_MOVE_COMMAND = "Enter commands u,d,l,r to move Up, Down, Left, and Right:";
    
    // Commands
    public static final String QUIT = "quit";
    
    
    // Error Messages 
    public static final String ERROR_MSG_MOVE_COMMAND = "Invaild command, only accept one of { u, d, l, r }, try again...";
    public static final String ERROR_MSG_FORMAT = "Invaild format, try again...";
    public static final String ERROR_MSG_NOT_AVAILABLE_SPOT = "Position not available. Try again!";
    public static final String ERROR_MSG_DIRECTION = "Invalid direction.";
    public static final String ERROR_MSG_MOVE_TO_WALL = "Cannot move over a wall.";
    public static final String ERROR_MSG_FILERESOURCE = "FileResource: error encountered reading ";
    
    // Messages 
    public static final String SPOT_AVAILABLE = "User input accepted.";
    
    public static final String END_SUCCESSFUL = """
                                  \nSquirrel successfully collected all the nuts. Total points %d.
                                  Thank you for playing this game
                                  """;
    public static final String END_FAILED = """
                                  \nSquirrel ate a poisonous cashew and total points became negative %d.
                                  The squirrel dies and the game is over. 
                                  Thank you for playing this game
                                  """;

    public static final String GET_POINTS = "!!! Squirrel ate %s and gained %d points (Total %d points) !!!\n";
    public static final String LOST_POINTS = "Eat a poisonous cashew..., points: ";
    
    public static final String PRINT_SQUIRREL = "Squirrel: symbol %s, row %d, col %d, collected %d";
}
