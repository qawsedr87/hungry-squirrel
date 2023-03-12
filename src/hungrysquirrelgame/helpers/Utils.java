package hungrysquirrelgame.helpers;

/**
 *
 * @author louise
 */
public class Utils {
    public static int randomRow() {
        return (int) (Math.random() * CONST.MAX_MAZE_ROW) + 1;
    }
    
    public static int randomColumn() {
        return (int) (Math.random() * CONST.MAX_MAZE_COLUMN) + 1;
    }
}
