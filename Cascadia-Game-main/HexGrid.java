/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */

package com.gameView;

import javafx.scene.paint.Color;

public class HexGrid extends Tiles {

    public static final double Hex_WIDTH = 70;
    public static final double Hex_HEIGHT = 80;

    public HexGrid(){

    }

    //Special Tile to create Hexgride
    public  void createHexGrid() {
        getPoints().setAll(
                0d,-Hex_HEIGHT/4,
                0d,-3*Hex_HEIGHT/4,
                -Hex_WIDTH/2,-Hex_HEIGHT,
                -Hex_WIDTH,-3*Hex_HEIGHT/4,
                -Hex_WIDTH,-Hex_HEIGHT/4,
                -Hex_WIDTH/2,0d);

        setStroke(Color.BLACK);
        setStrokeWidth(2);
        setFill(Color.WHITE);

    }

    public void hexGrid_Tile(){
        createHexGrid();
    }
}

