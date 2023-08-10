/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.gameView;

import com.cascadia.demo.Buttons;
import com.cascadia.demo.ViewLauncher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

import static com.cascadia.demo.subScene.Store;

// Launcher class for main game Stage and displaying all the Elements(wild life tokens, Tiles, Player/Grid)
public class GameViewLauncher {
    public static AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private Label name;
    public static Buttons next;
    private static Label natureToken;

    public static ArrayList<Tiles> displayTiles;
    public static ArrayList<wildlife_Tokens> displayWildToken, removeWildTokens,pickAnyTokenArray;
    public tileBag tBag;
    public Random rand;
    public wTokenBag wBag;
    public  static int player_num = 1;
    private int numturns = 0;

    public static void setPlayer_num(int player_num) {
        GameViewLauncher.player_num = player_num;
    }

    public static int getPlayer_num() {
        return player_num;
    }

    private static final int width = 1450;
    private static final int height = 900;
    private static Buttons overPopulation, useNaturetokenButton,pickAnyTileWildButton, removeWildButton,notNowButton,removeButton;



    public GameViewLauncher() {

        initialise();

        //Initial display of random order of players and number of players
        System.out.println("Number Of PLayers : "+Store.size());
        System.out.println("Order of Players");
        for (int i = 1; i <= Store.size(); i++) {

            System.out.println(Store.get(i).getName());

        }

    }

    public void initialise() {
        //Establishing game playing field's Stage, Scene and Pane.
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane,width,height);
        gameStage = new Stage();
        gameStage.setScene(gameScene);

        //Quit Button to end and leave game at any point of time and display score at that particular time.
        Buttons quit = new Buttons("Quit Game");
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (int i = 1; i <= Store.size(); i++) {//for loop to interate among all the players
                    System.out.println("Score of Player Name : "+Store.get(i).getName());
                    scoringWildlife score = new scoringWildlife(Store.get(i).wildlifeArray);//scoring wild life arrangement of specific player.
                    System.out.println("Number of Nature Token Left : "+Store.get(i).getNumOfNatureToken());
                    int finalScore=score.finalWildLifeScore + Store.get(i).getNumOfNatureToken();
                    System.out.println("Final Score is : "+finalScore);
                }
                //Closing all Stages
                ViewLauncher.primaryStage.close();
                gameStage.close();
            }
        });
        quit.setLayoutX(10);
        quit.setLayoutY(700);
        gamePane.getChildren().add(quit);

        BackgroundFill backColor = new BackgroundFill(Color.BEIGE, null, null);//BackGround Color
        gamePane.setBackground(new Background(backColor));

        //Calling each player grid.
        for (int i = 1; i <= Store.size(); i++) {
            gamePane.getChildren().add(Store.get(i).getGrid());
            if (i != 1){
                Store.get(i).getGrid().nextSubScene();
            }
        }

        //Display name of the player whose grid is in play according to the order of play.
        displayName();
        displayNatureToken();//Display number of Nature Token of particular player in play.
        tBag = new tileBag();// Adding common Tile bag for all the players.
        displayTiles = new ArrayList<>();
        //display random tiles from the tile bag.
        rand = new Random();
        for (int i = 0; i < 4; i++){
            Tiles currentTile = randomTile();
            displayTiles.add(currentTile);
        }

        addTilesToPane();

        //Display random Wild Life Token from Bag
        wBag = new wTokenBag();
        displayWildToken = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wildlife_Tokens currentWToken = randomWildToken();
            displayWildToken.add(currentWToken);
        }
        addWildTokenToPane();
        checkCulling();//checking culling options

        //"Next" button to change PLayer turn.
        next = new Buttons("Next");
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeNatureToken();//remove nature token value of current player
                if (getPlayer_num() > Store.size()) {//to cycle player turns in a circle
                    setPlayer_num(1);
                }
                else {
                    Store.get(getPlayer_num()).getGrid().nextSubScene();//move grid of current player
                    gamePane.getChildren().remove(name);

                    setPlayer_num(getPlayer_num() + 1);//next player
                    if (getPlayer_num() > Store.size()){
                        setPlayer_num(1);
                    }
                    Store.get(getPlayer_num()).getGrid().callSubScene();//call next players grid
                    displayName();//display next players name
                    useNatureToken();
                    displayNatureToken();//Nature Token of next player.
                }

                //updating common Tiles and wildlife tokens after used in previous turn
                addTilesToPane();
                addWildTokenToPane();
                checkCulling();
                numturns += 1;//keeping count of number of turns played.

                //After completing 20 turns per player game ends automatically and displays score result
                if(numturns == Store.size() * 20){
                    for (int i = 1; i <= Store.size(); i++) {
                        System.out.println(Store.get(i).getName());
                        scoringWildlife score = new scoringWildlife(Store.get(i).wildlifeArray);
                        System.out.println("Number of Nature Token Left : "+Store.get(i).getNumOfNatureToken());
                        System.out.println("Final Score is : "+score.finalWildLifeScore+Store.get(i).getNumOfNatureToken());
                    }
                    ViewLauncher.primaryStage.close();
                    gameStage.close();
                }
                gamePane.getChildren().remove(next);
            }
        });
        next.setLayoutX(210);
        next.setLayoutY(700);

        gameStage.show();

    }

    //Function to display Name of current player
    public void displayName(){
        name = new Label("Player : " + Store.get(player_num).getName());
        name.setTextFill(Color.RED);
        name.setFont(Font.font("Arial", FontWeight.BOLD, 23));
        name.setLayoutX(20);
        name.setLayoutY(25);
        gamePane.getChildren().add(name);
    }

    //randomly generating tiles
    public Tiles randomTile(){
        rand = new Random();
        int randomIndex = rand.nextInt(tBag.tileBagArray.size());
        Tiles randomTile = tBag.tileBagArray.get(randomIndex);
        tBag.tileBagArray.remove(randomIndex);
        return randomTile;
    }
    //Adding randomly generated tiles to the arraylist of tiles
    public void displayRandomTiles() {
        for (int i = 0; i < 4; i++) {
            if (displayTiles.get(i) == null) {//only adding tiles to index of arraylist(displayTiles) which is null
                Tiles currentTile = randomTile();
                currentTile.dragTile(currentTile);
                displayTiles.set(i, currentTile);
            }
        }
    }

    //Displaying tiles on the gamePane.
    public void addTilesToPane() {
        displayRandomTiles();
        for (int i = 0; i < 4; i++) {
            if (!gamePane.getChildren().contains(displayTiles.get(i))){
                displayTiles.get(i).setLayoutY(((i + 1) * 100) + 100);
                displayTiles.get(i).setLayoutX(100);
                displayTiles.get(i).dragTile(displayTiles.get(i));
                gamePane.getChildren().add(displayTiles.get(i));
            }
        }
    }

    //Function to randomly generate wildLife Token
    public wildlife_Tokens randomWildToken(){
        rand = new Random();
        int randomIndex = rand.nextInt(wBag.wildBag.size());
        wildlife_Tokens randomWToken = wBag.wildBag.get(randomIndex);
        wBag.wildBag.remove(randomIndex);
        return randomWToken;
    }

    //Adding randomly generated wildLife Tokens to the arraylist of wildLife tokens
    public void displayRandomWildToken() {
        for (int i = 0; i < 4; i++) {
            if (displayWildToken.get(i) == null) {
                wildlife_Tokens currentWToken = randomWildToken();
                displayWildToken.set(i,currentWToken);
            }
        }
    }
    //Displaying wildLife Tokens on the gamePane.
    public void addWildTokenToPane() {
        displayRandomWildToken();
        for (int i = 0; i < 4; i++) {
            if (!gamePane.getChildren().contains(displayWildToken.get(i))) {
                displayWildToken.get(i).setLayoutY((((i + 1) * 100) + 100));
                displayWildToken.get(i).setLayoutX(200);
                gamePane.getChildren().add(displayWildToken.get(i));
            }
        }
    }

    //Function to check Culling and asking PLayer
    public void checkCulling(){
        for (int i = 0; i<displayWildToken.size() - 2; i++) {

            for (int j = i + 1; j < displayWildToken.size() - 1; j++) {
                for(int k = j + 1; k < displayWildToken.size(); k++) {

                    if (displayWildToken.get(i).getType() == displayWildToken.get(j).getType() && (displayWildToken.get(j).getType() == displayWildToken.get(k).getType())) {//comparing
                        overPopulation = new Buttons("Over Population");
                        int finalI = i;
                        int finalJ = j;
                        int finalK = k;
                        overPopulation.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                gamePane.getChildren().remove(displayWildToken.get(finalI));
                                gamePane.getChildren().remove(displayWildToken.get(finalJ));
                                gamePane.getChildren().remove(displayWildToken.get(finalK));
                                displayWildToken.set(displayWildToken.indexOf(displayWildToken.get(finalI)),null);
                                displayWildToken.set(displayWildToken.indexOf(displayWildToken.get(finalJ)),null);
                                displayWildToken.set(displayWildToken.indexOf(displayWildToken.get(finalK)),null);
                                addWildTokenToPane();
                                gamePane.getChildren().remove(overPopulation);
                                checkCulling();

                            }
                        });
                        overPopulation.setLayoutY(550);
                        overPopulation.setLayoutX(150);
                        gamePane.getChildren().add(overPopulation);
                    }
                    else {
                        gamePane.getChildren().remove(overPopulation);
                    }
                }
            }
        }
    }

    //Function to display nature token of current player
    public static void displayNatureToken(){
        natureToken = new Label("Nature Tokens: " + Store.get(getPlayer_num()).getNumOfNatureToken());
        natureToken.setTextFill(Color.RED);
        natureToken.setFont(Font.font("Arial", FontWeight.BOLD, 23));
        natureToken.setLayoutX(200);
        natureToken.setLayoutY(25);
        gamePane.getChildren().add(natureToken);
    }

    public static void removeNatureToken(){
        gamePane.getChildren().remove(natureToken);
    }

    //Using Nature Tokens
    public void useNatureToken(){
        if(Store.get(getPlayer_num()).getNumOfNatureToken()>0){
            // Button to use Nature token
            useNaturetokenButton = new Buttons("Use 1 Nature Token");
            useNaturetokenButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    gamePane.getChildren().remove(useNaturetokenButton);
                    gamePane.getChildren().add(removeWildButton);
                    gamePane.getChildren().add(pickAnyTileWildButton);
                    gamePane.getChildren().add(notNowButton);
                }
            });

            useNaturetokenButton.setLayoutX(200);
            useNaturetokenButton.setLayoutY(50);
            gamePane.getChildren().add(useNaturetokenButton);

            //Option 1 to use Nature Token as to select and clear any number of tokens and display other random wildLife tokens
            removeWildButton = new Buttons("Select and clear Tokens");
            removeWildButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Store.get(getPlayer_num()).setNumOfNatureToken(Store.get(getPlayer_num()).getNumOfNatureToken() - 1);
                    gamePane.getChildren().remove(pickAnyTileWildButton);
                    gamePane.getChildren().remove(notNowButton);
                    removeNatureToken();
                    displayNatureToken();
                    removeWildTokens = new ArrayList<>();
                    for (int i = 0; i < displayWildToken.size(); i++) {
                        wildlife_Tokens.selectToken(displayWildToken.get(i));
                    }
                    removeButton = new Buttons("Remove Selected");
                    removeButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int size = removeWildTokens.size();
                            for (int i =0; i<size;i++){
                                displayWildToken.set(displayWildToken.indexOf(removeWildTokens.get(i)),null);
                                gamePane.getChildren().remove(removeWildTokens.get(i));
                            }

                            addWildTokenToPane();
                            gamePane.getChildren().remove(removeButton);
                            checkCulling();
                        }
                    });
                    removeButton.setLayoutX(150);
                    removeButton.setLayoutY(550);
                    gamePane.getChildren().add(removeButton);
                    gamePane.getChildren().remove(removeWildButton);
                }
            });
            removeWildButton.setLayoutX(70);
            removeWildButton.setLayoutY(75);

            //Option 2 to use Nature Token as to select any tile and wildLife Token and place on the grid
            pickAnyTileWildButton = new Buttons("Pick any Tile/Token");
            pickAnyTileWildButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Store.get(getPlayer_num()).setNumOfNatureToken(Store.get(getPlayer_num()).getNumOfNatureToken()-1);
                    pickAnyTokenArray = new ArrayList<>();
                    for (int i = 0; i < displayWildToken.size(); i++) {
                        wildlife_Tokens tempWildToken = new wildlife_Tokens(displayWildToken.get(i).getType());
                        pickAnyTokenArray.add(tempWildToken);
                        wildlife_Tokens.dragToken(tempWildToken);
                        tempWildToken.setLayoutY((((i + 1) * 100) + 100));
                        tempWildToken.setLayoutX(200);
                        gamePane.getChildren().add(tempWildToken);
                        gamePane.getChildren().remove(displayWildToken.get(i));

                    }
                    gamePane.getChildren().remove(removeWildButton);
                    gamePane.getChildren().remove(notNowButton);
                    removeNatureToken();
                    displayNatureToken();
                    gamePane.getChildren().remove(pickAnyTileWildButton);
                }
            });
            pickAnyTileWildButton.setLayoutX(220);
            pickAnyTileWildButton.setLayoutY(75);

            //Button to not use Nature token.
            notNowButton = new Buttons("Not Now");
            notNowButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    gamePane.getChildren().add(useNaturetokenButton);
                    gamePane.getChildren().remove(pickAnyTileWildButton);
                    gamePane.getChildren().remove(removeWildButton);
                    gamePane.getChildren().remove(notNowButton);
                }
            });
            notNowButton.setLayoutX(200);
            notNowButton.setLayoutY(100);

        }
    }
}
