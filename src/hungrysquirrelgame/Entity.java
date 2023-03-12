package hungrysquirrelgame;

/**
 *
 * @author louise
 */
public abstract class Entity {
    private final char symbol;
    private int row;
    private int column;
    
    public Entity(char s, int r, int c) {
        this.symbol = s;
        this.row = r;
        this.column = c;
    }
    
    public abstract void create();
    
    // replaced
    public Entity put(int newRow, int newColumn) {
        Entity newLocation = this;

        // eliminate previous location
        Maze.getMaze()[getRow()][getColumn()] = null;

        newLocation.setRow(newRow);
        newLocation.setColumn(newColumn);

        // replace to new location
        Maze.getMaze()[newRow][newColumn] = newLocation;

        return newLocation;
    }

    public char getSymbol() {
        return symbol;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getColumn() {
        return column;
    }
    
    public void setRow(int newRow) {
        row = newRow;
    }
    
    public void setColumn(int newColumn) {
        column = newColumn;
    }
    
}
