/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.gameView;

import com.cascadia.demo.Buttons;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import java.util.Objects;

import static com.cascadia.demo.subScene.Store;
import static com.gameView.GameViewLauncher.*;
import static com.gameView.wildlife_Tokens.dragToken;

public class Tiles extends Polygon {//Tiles Class to make Tiles and give specific features
    public Buttons save,rotate;

    public static final double Tiles_WIDTH = 70;
    public static final double Tiles_HEIGHT = 80;
    public enum Tiles_Type{
        Lake,Swamp,Mountain,Forest,Desert,Desert_and_Lake, Desert_and_Swamp, Forest_and_Desert, Forest_and_Lake, Forest_and_Swamp,
        Lake_and_Mountain, Mountain_and_Swamp, Mountain_and_Forest,Mountain_and_Desert,Swamp_and_Lake
    }
    public enum wildlife_Type{
        Bear, Hawk, Elk, Salmon, Fox, Elk_and_Hawk, Elk_and_Salmon, Fox_and_Hawk,
        Fox_and_Bear, Fox_and_Hawk_and_Bear, Fox_and_Salmon_and_Bear, Fox_and_Elk, Fox_and_Elk_and_Salmon,
        Fox_and_Hawk_and_Salmon, Hawk_and_Salmon, Fox_and_Salmon, Bear_and_Salmon, Bear_and_Elk,Hawk_and_Fox_and_Elk,
        Hawk_and_Salmon_and_Elk, Bear_and_Hawk, Hawk_and_Salmon_and_Bear, Fox_and_Elk_and_Bear, Elk_and_Hawk_and_Bear,
        Elk_and_Salmon_and_Bear,Hawk_and_Elk,Salmon_Bear_Fox
    }
    private double newtX;
    private int  arrayCoordinateX, arrayCoordinateY;
    public Tiles_Type T_type;

    public void setTiles_Type(Tiles_Type type){
        this.T_type=type;
    }
    public Tiles_Type getTiles_Type(){
        return T_type;
    }

    public wildlife_Type w_type;

    public void setWildlife_type(wildlife_Type w_type) {
        this.w_type = w_type;
    }


    public wildlife_Type getWildlife_type() {
        return w_type;
    }

    public boolean keyStoneTile=false;

    public String imgSource;

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public Tiles(){
    }
    //Creating tiles
    public void create_Tile(Tiles_Type t_type,wildlife_Type w_type,String imgSource){
        getPoints().setAll(
                0.00,-Tiles_HEIGHT/4,
                0.00,-3*Tiles_HEIGHT/4,
                -Tiles_WIDTH/2,-Tiles_HEIGHT,
                -Tiles_WIDTH,-3*Tiles_HEIGHT/4,
                -Tiles_WIDTH,-Tiles_HEIGHT/4,
                -Tiles_WIDTH/2,0.00);

        setStroke(Color.BLACK);
        setWildlife_type(w_type);
        setTiles_Type(t_type);

        setImgSource(imgSource);
        //setting image used in the tile
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imgSource)));
        setFill(new ImagePattern(img));

    }
    //function to help round the location to dropped tile and place it according to the grid
    public static double round(double num, int multipleOf) {
        return Math.floor((num +  (double)multipleOf / 2) / multipleOf) * multipleOf;
    }

    //Adding drag method to tiles when called
    public void dragTile(Tiles t){
        final double originalX = t.getLayoutX();
        final double originalY = t.getLayoutY();
        //when mouse is pressed on the tiles
        t.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                t.setStroke(Color.BLACK);
                t.setStrokeWidth(5);

                gamePane.getChildren().remove(save);
                gamePane.getChildren().remove(rotate);

            }
        });
        //when mouse is dragged while pressed on the token
        t.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                t.setLayoutX(t.getLayoutX()+mouseEvent.getX());
                t.setLayoutY(t.getLayoutY()+mouseEvent.getY());
                t.create_Tile(t.getTiles_Type(),t.getWildlife_type(),t.getImgSource());
                mouseEvent.consume();

            }
        });
        //when mouse is released it stay where dropped
        t.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (getLayoutX()>=435){
                    t.setStrokeWidth(1);
                    double newx = round(t.getLayoutX()-400,35);

                    t.setLayoutX(400+newx);

                    //Button to add tile to the matrix of TilesArray adn hexGrid of the player also to snap it into the hexGrid space allowed
                    save = new Buttons("Save");
                    save.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            double x_loc = t.getLayoutX()-400;
                            double y_loc = t.getLayoutY();

                            Tiles newt = new Tiles();
                            newt.create_Tile(t.getTiles_Type(),t.getWildlife_type(),t.getImgSource());
                            newt.keyStoneTile=t.keyStoneTile;

                            if (x_loc%35==0 && x_loc%70==0){
                                arrayCoordinateX = (int) ((x_loc-70)/70);
                                newtX = (arrayCoordinateX*70)+70;
                            }
                            else {
                                arrayCoordinateX = (int) ((x_loc-35)/70);
                                newtX = (arrayCoordinateX*70)+35;
                            }

                            arrayCoordinateY = (int) Math.round((y_loc-80)/60);
                            double newtY = (arrayCoordinateY*60)+80;
                            newt.setRotate(t.getRotate());

                            Store.get(player_num).getGrid().tileArray[arrayCoordinateY][arrayCoordinateX]=newt;
                            newt.setLayoutY(newtY);
                            newt.setLayoutX(newtX);
                            Store.get(player_num).grid.root1.getChildren().add(newt);


                            // For Nature Token use
                            if (pickAnyTokenArray==null){
                                wildlife_Tokens toMove = checkToken(originalY);
                                assert toMove != null;
                                dragToken(toMove);
                            }

                            gamePane.getChildren().remove(t);
                            displayTiles.set(displayTiles.indexOf(t),null);
                            gamePane.getChildren().remove(save);
                            gamePane.getChildren().remove(rotate);


                        }
                    });
                    save.setLayoutX(100);
                    save.setLayoutY(700);
                    gamePane.getChildren().add(save);

                    rotate = new Buttons("Rotate");
                    rotate.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            t.setRotate(t.getRotate()+60);

                        }
                    });
                    rotate.setLayoutX(150);
                    rotate.setLayoutY(700);
                    gamePane.getChildren().add(rotate);




                }
                else {
                    t.setStrokeWidth(1);
                    t.setLayoutX(originalX);
                    t.setLayoutY(originalY);

                }

            }
        });



    }
    //Function to check which token is in front of Tile placed and allow that particular token to move
    public static wildlife_Tokens checkToken(double layoutY){


        for (int i = 0;i<4;i++){

            if (layoutY==displayWildToken.get(i).getLayoutY()){

                return displayWildToken.get(i);
            }
        }

        return null;
    }


}
