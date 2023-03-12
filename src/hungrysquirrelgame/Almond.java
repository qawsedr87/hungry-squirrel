/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hungrysquirrelgame;


/**
 *
 * @author louise
 */
public class Almond extends Nut {
    
    private static final int NUTRITION_POINTS = 5;
    
    public Almond(int row, int col) {
        super(NUTRITION_POINTS, "Almond", 'A', row, col);

    }

    @Override
    public void create() {
        int row = getRow() - 1;
        int col = getColumn() - 1;
        
        Maze.getMaze()[row][col] = this;
    }
}
