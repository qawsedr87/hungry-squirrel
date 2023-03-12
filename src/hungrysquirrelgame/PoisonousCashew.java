/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hungrysquirrelgame;

import hungrysquirrelgame.helpers.Utils;

/**
 *
 * @author louise
 */
public class PoisonousCashew extends Entity {

    private static final int TOTAL_POISON_COUNT = 5;
    private static final int NEGATIVE_NUTRITION_POINTS = -15;
    private static final String NAME = "Poisonous Cashew";
    
    

    public PoisonousCashew(int row, int col) {
        super('?', row, col);
    }
    
    public static int getTotalPoisons() {
        return TOTAL_POISON_COUNT;
    }
    
    public int getNutritionPoints() {
        return NEGATIVE_NUTRITION_POINTS;
    } 
    
    public String getName() {
        return NAME;
    }
    
    @Override
    public void create() {
        int row = getRow() - 1;
        int col = getColumn() - 1;
        
        Maze.getMaze()[row][col] = this;
        
    }
    
    public static void generatedPoisons(int total) {
        PoisonousCashew[] poisonous = new PoisonousCashew[total];
        
        int count = 0;
        
        while (count < total) {
            int row, col; 
           
            do {
                
                row = Utils.randomRow();
                col = Utils.randomColumn();
                
            } while (!Maze.available(row, col));
            
            var p = new PoisonousCashew(row, col);
            poisonous[count] = p;

            p.create();
            
            count++;
        }
    }
    
}
