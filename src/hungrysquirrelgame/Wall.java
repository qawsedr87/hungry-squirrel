/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hungrysquirrelgame;

/**
 *
 * @author louise
 */
public class Wall extends Entity {

    public Wall(int newRow, int newColumn) {
        super('*', newRow, newColumn);
    }
    
    @Override
    public void create() {
        int row = getRow();
        int col = getColumn();
        
        Maze.getMaze()[row][col] = this;
    }
    
}
