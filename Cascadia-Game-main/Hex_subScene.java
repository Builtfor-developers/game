/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */

package com.gameView;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.Random;

import static com.gameView.startingTiles.collectionStarterTiles;

//Creating Grid for Players class
public class Hex_subScene extends SubScene {//Calling grid as subscene of main gameView
    public AnchorPane root1;

    public int rows = 20, cols = 20;
    public Tiles[][] tileArray;

    public Hex_subScene() {
        super(new AnchorPane(), 1450, 900);
        root1 = (AnchorPane) this.getRoot();
        root1.setLayoutX(400);
        root1.setLayoutY(0);

        BackgroundFill c = new BackgroundFill(Color.BEIGE,null,null);
        root1.setBackground(new Background(c));

        Random rand = new Random();
        int randomIndex = rand.nextInt(collectionStarterTiles.size()); //to randomly generate starter habitate tiles
        tileArray = new Tiles[rows][cols];
        //Creating Grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 == 0) {//Different location of particular hexgrid tile according to the adjacent row(Different for even rows and odd rows)
                    HexGrid h1 = new HexGrid();
                    h1.hexGrid_Tile();
                    h1.setLayoutY(80 + (i * 60));
                    h1.setLayoutX(70 + (j * 70));
                    tileArray[i][j] = h1;

                    root1.getChildren().add(h1);
                    if (i == 6 && j == 7) {//Adding Starter Tile to the Hexgrid of the player which is randomly generated
                        collectionStarterTiles.get(randomIndex).get(0).setLayoutX(70 + (j * 70));
                        collectionStarterTiles.get(randomIndex).get(0).setLayoutY(80 + (i * 60));
                        tileArray[i][j]=collectionStarterTiles.get(randomIndex).get(0);
                        root1.getChildren().add(collectionStarterTiles.get(randomIndex).get(0));
                    }
                }
                else{// For odd rows
                    HexGrid h1 = new HexGrid();
                    h1.hexGrid_Tile();
                    h1.setLayoutY(80 + (i * 60));
                    h1.setLayoutX((70 / 2) + (j * 70));
                    tileArray[i][j] = h1;
                    root1.getChildren().add(h1);

                    if (i == 7) {//Adding Starter Tile to the Hexgrid of the player which is randomly generated
                        if (j == 7) {
                            collectionStarterTiles.get(randomIndex).get(1).setLayoutX((70 / 2) + (j * 70));
                            collectionStarterTiles.get(randomIndex).get(1).setLayoutY(80 + (i * 60));
                            tileArray[i][j]=collectionStarterTiles.get(randomIndex).get(1);
                            root1.getChildren().add(collectionStarterTiles.get(randomIndex).get(1));
                        } else if (j == 8) {
                            collectionStarterTiles.get(randomIndex).get(2).setLayoutX((70 / 2) + (j * 70));
                            collectionStarterTiles.get(randomIndex).get(2).setLayoutY(80 + (i * 60));
                            tileArray[i][j]=collectionStarterTiles.get(randomIndex).get(2);
                            root1.getChildren().add(collectionStarterTiles.get(randomIndex).get(2));
                        }
                    }
                }
            }
        }
        collectionStarterTiles.remove(randomIndex);
    }

    //Function to move current Grid/subScene outside the playing area
    public void nextSubScene() {
        TranslateTransition right = new TranslateTransition();
        right.setDuration(Duration.seconds(0.01));
        right.setNode(this);
        right.setToX(1080);
        right.play();
    }
    //Function to move current Grid/subScene inside the playing area
    public void callSubScene() {
        TranslateTransition left = new TranslateTransition();
        left.setDuration(Duration.seconds(1));
        left.setNode(this);
        left.setToX(0);
        left.play();
    }

    //Print Grid with tiles in console
    public void printGrid(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols;j++) {
                if (tileArray[i][j].getTiles_Type() == null){
                    System.out.print("  " + null + "  ");
                }
                System.out.print("  " + tileArray[i][j].getTiles_Type() + "  ");
            }
            System.out.println(" ");
        }
    }
}
