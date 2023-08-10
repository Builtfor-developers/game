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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import static com.cascadia.demo.subScene.Store;
import static com.gameView.GameViewLauncher.*;

import static com.gameView.Tiles.round;

public class wildlife_Tokens extends Circle {
    private static double newtX, newtY;

    private static int  arrayCoordinateX, arrayCoordinateY;
    public boolean tokenChecked = false;

    private static Tiles type;

    public enum wildlife_Type {
        Bear, Hawk, Elk, Salmon, Fox, empty
    }
    public wildlife_Type wildType;

    public void setType(wildlife_Type wildType) {
        this.wildType = wildType;
    }

    public wildlife_Type getType() {
        return wildType;
    }

    public imgData hawk, Fox, Elk, Bear, Salmon;
    public wildlife_Tokens(wildlife_Type wild_t) {
        createWildlife_Tokens(wild_t);
    }

    public static Buttons saveToken;
    //creating wild life token for specific type
    public void createWildlife_Tokens(wildlife_Type wild_t) {
        //creating token and adding image to it
        setType(wild_t);
        if (wild_t == wildlife_Type.Hawk) {
            hawk = new imgData();
            setFill(new ImagePattern(hawk.getHawkImage()));

        }

        if (wild_t == wildlife_Type.Bear) {
            Bear = new imgData();
            setFill(new ImagePattern(Bear.getBear()));

        }

        if (wild_t == wildlife_Type.Salmon) {
            Salmon = new imgData();
            setFill(new ImagePattern(Salmon.getSalmon()));

        }

        if (wild_t == wildlife_Type.Fox) {
            Fox = new imgData();
            setFill(new ImagePattern(Fox.getFox()));

        }

        if (wild_t == wildlife_Type.Elk) {
            Elk = new imgData();
            setFill(new ImagePattern(Elk.getElk()));

        }
        setRadius(20);
        setStroke(Color.BLACK);
    }

    //Adding drag method to token when called
    public static void dragToken(wildlife_Tokens w_t) {
        final double originalX = w_t.getLayoutX();
        final double originalY = w_t.getLayoutY();
        //when mouse is pressed on the token
        w_t.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                w_t.setStroke(Color.BLACK);
                w_t.setStrokeWidth(5);

            }
        });
        //when mouse is dragged while pressed on the token
        w_t.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //token moves along with the mouse co-ordinates
                w_t.setLayoutX(w_t.getLayoutX() + mouseEvent.getX());
                w_t.setLayoutY(w_t.getLayoutY() + mouseEvent.getY());
                w_t.createWildlife_Tokens(w_t.getType());
                mouseEvent.consume();
            }
        });
        //when mouse is released it stay where dropped
        w_t.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (w_t.getLayoutX() >= 435) {
                    if (w_t.getLayoutX() >= 435) {
                        w_t.setStrokeWidth(1);
                        double newx = round(w_t.getLayoutX()-400,35);

                        w_t.setLayoutX(400+newx);
                        System.out.println(w_t.getLayoutX() + " , " + w_t.getLayoutY());

                        double x_loc = w_t.getLayoutX()-400+35;
                        double y_loc = w_t.getLayoutY()+40;
                        wildlife_Tokens new_w_t = new wildlife_Tokens(w_t.getType());

                        if (x_loc%35==0 && x_loc%70==0){
                            arrayCoordinateX = (int) ((x_loc-70)/70);
                        }
                        else {
                            arrayCoordinateX = (int) ((x_loc-35)/70);
                        }


                        arrayCoordinateY = (int) Math.round((y_loc-80)/60);

                        //check if it allowed to place token over there (if the tile allows that token)
                        type = Store.get(player_num).getGrid().tileArray[arrayCoordinateY][arrayCoordinateX];
                        if (type.getWildlife_type().toString().contains(w_t.getType().toString())){
                            saveButtonFunction(w_t);
                        }
                        //else returns it to its original co-ordinates
                        else {
                            w_t.setStrokeWidth(1);
                            w_t.setLayoutX(originalX);
                            w_t.setLayoutY(originalY);
                            gamePane.getChildren().remove(saveToken);
                        }

                    }
                    //else returns it to its original co-ordinates and state
                    else {
                        w_t.setStrokeWidth(1);
                        w_t.setLayoutX(originalX);
                        w_t.setLayoutY(originalY);
                    }

                }
                //else returns it to its original co-ordinates and state
                else {
                    w_t.setStrokeWidth(1);
                    w_t.setLayoutX(originalX);
                    w_t.setLayoutY(originalY);
                }

            }
        });
    }
    //Save token button to add placed token in the matrix of wildlife Tokens 2D array
    public static void saveButtonFunction(wildlife_Tokens w_t){
        saveToken = new Buttons("saveToken");
        saveToken.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double x_loc = w_t.getLayoutX()-400+35;
                double y_loc = w_t.getLayoutY()+40;
                wildlife_Tokens new_w_t = new wildlife_Tokens(w_t.getType());
                new_w_t.setLayoutX(x_loc);
                new_w_t.setLayoutY(y_loc);
                //calculating array location using co-ordinates of token on pane.
                if (x_loc%35==0 && x_loc%70==0){
                    arrayCoordinateX = (int) ((x_loc-70)/70);
                    newtX = (arrayCoordinateX*70+35);
                }
                else {

                    arrayCoordinateX = (int) ((x_loc-35)/70);
                    newtX = (arrayCoordinateX*70);
                }

                arrayCoordinateY = (int) Math.round((y_loc-80)/60);
                newtY = (arrayCoordinateY*60)+80;

                // add nature token point after checking if the tiles is keystone or not
                if (Store.get(getPlayer_num()).getGrid().tileArray[arrayCoordinateY][arrayCoordinateX].keyStoneTile){
                    Store.get(getPlayer_num()).setNumOfNatureToken((Store.get(getPlayer_num()).getNumOfNatureToken())+1);

                    removeNatureToken();
                    displayNatureToken();

                }
                new_w_t.setLayoutY(newtY-40);
                new_w_t.setLayoutX(newtX);
                Store.get(player_num).wildlifeArray[arrayCoordinateY][arrayCoordinateX]= new_w_t;
                Store.get(player_num).grid.root1.getChildren().add(new_w_t);

                //after using nature token and picking any array adding new tokens to the Pane
                if ( pickAnyTokenArray!=null){
                    displayWildToken.set(pickAnyTokenArray.indexOf(w_t), null);
                    for (int i = 0;i<pickAnyTokenArray.size();i++){
                        gamePane.getChildren().remove(pickAnyTokenArray.get(i));
                    }

                    for (int i = 0;i<4;i++){
                        if (!gamePane.getChildren().contains(displayWildToken.get(i))){
                            if (displayWildToken.get(i)!=null){
                                gamePane.getChildren().add(displayWildToken.get(i));
                            }


                        }

                    }
                    pickAnyTokenArray=null;
                }

                gamePane.getChildren().remove(w_t);
                gamePane.getChildren().remove(saveToken);
                //setting index location of token in array as null to add new token later.
                if (displayWildToken.contains(w_t)){
                    displayWildToken.set(displayWildToken.indexOf(w_t),null);

                }
                gamePane.getChildren().add(GameViewLauncher.next);


            }
        });
        saveToken.setLayoutX(100);
        saveToken.setLayoutY(700);
        gamePane.getChildren().add(saveToken);
    }
    //Function to help remove any number of wildlife tokens when a nature token is used
    public static void selectToken(wildlife_Tokens w_t){
        w_t.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                w_t.setStroke(Color.BLACK);
                w_t.setStrokeWidth(5);
                removeWildTokens.add(w_t);

                w_t.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        w_t.setStrokeWidth(1);
                        removeWildTokens.remove(w_t);
                        selectToken(w_t);
                        for (int i =0; i<removeWildTokens.size();i++){
                            System.out.println(removeWildTokens.get(i).getType());
                        }
                    }
                });
            }

        });
    }

}
