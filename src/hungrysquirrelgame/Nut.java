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
public abstract class Nut extends Entity {
    
    private static final int TOTAL_NUTS = 5;
    private final int nutritionPoints;
    private final String name;

    public Nut(int points, String name,
            char symbol, int newRow, int newColumn) {
        super(symbol, newRow, newColumn);
        
        this.nutritionPoints = points;
        this.name = name;
    }

    public int getNutritionPoints() {
        return this.nutritionPoints;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static int getTotalNuts() {
        return TOTAL_NUTS;
    }
    
    public static void generatedNuts(int total) {
        Nut[] nuts = new Nut[total];
        
        int i = 0; 
        while (i < total) {
           
            int row, col; 
           
            do {
                
                row = Utils.randomRow();
                col = Utils.randomColumn();
                
            } while (!Maze.available(row, col));
            
            Nut nut = i % 2 == 0 
                    ? new Almond(row, col) 
                    : new Peanut(row, col);
            nuts[i] = nut;
            nut.create();

            i++;
        }
    }
}
