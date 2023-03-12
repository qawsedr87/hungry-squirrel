/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hungrysquirrelgame;

/**
 *
 * @author louise
 */
public class Peanut extends Nut {
    
    private static final int NUTRITION_POINTS = 10;
    
    public Peanut(int row, int col) {
        super(NUTRITION_POINTS, "Peanut", 'P', row, col);

    }

    @Override
    public void create() {
        int row = getRow() - 1;
        int col = getColumn() - 1;
        
        Maze.getMaze()[row][col] = this;
    }
}
