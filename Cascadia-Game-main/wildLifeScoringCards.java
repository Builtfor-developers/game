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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

//Class to Display randomly generated Wild Life Scoring cards on different Scene and Stage.
public class wildLifeScoringCards {
    private AnchorPane scoringCardPane;
    private Scene scoringCardScene;
    private Stage scoringCardStage;
    public Image bearAImg,bearBImg,bearCImg, salmonAImg,salmonBImg,salmonCImg, elkAImg,elkBImg,elkCImg, hawkAImg,hawkBImg,hawkCImg,
            foxAImg,foxBImg,foxCImg;
    public ArrayList<Image> bearImgArray, salmonImgArray, elkImgArray, hawkImgArray, foxImgArray;
    public wildLifeScoringCards(){
        initialise();
    }
    public void initialise(){

        scoringCardPane = new AnchorPane();
        scoringCardScene = new Scene(scoringCardPane,950,600);
        scoringCardStage = new Stage();
        scoringCardStage.setScene(scoringCardScene);

        BackgroundFill backColor = new BackgroundFill(Color.BEIGE, null, null);//BackGround Color
        scoringCardPane.setBackground(new Background(backColor));

        //Heading of the wildLifeScoringCards Stage
        Label label = new Label("Wild Life Scoring Cards");
        label.setFont(Font.font("Arial",32));
        label.setLayoutX(300);
        label.setLayoutY(10);
        scoringCardPane.getChildren().add(label);

        //Adding Image address of respective wild Life Scoring Cards (Grouped as wildLifeA,B,C).
        //Bear
        bearImgArray = new ArrayList<>();
        bearImgArray.add(bearAImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/bear/bear-a.png"))));
        bearImgArray.add(bearBImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/bear/bear-b.png"))));
        bearImgArray.add(bearCImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/bear/bear-c.png"))));

        //Salmon
        salmonImgArray = new ArrayList<>();
        salmonImgArray.add(salmonAImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/salmon/salmon-a.png"))));
        salmonImgArray.add(salmonBImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/salmon/salmon-b.png"))));
        salmonImgArray.add(salmonCImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/salmon/salmon-c.png"))));

        //Elk
        elkImgArray = new ArrayList<>();
        elkImgArray.add(elkAImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/elk/elk-a.png"))));
        elkImgArray.add(elkBImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/elk/elk-b.png"))));
        elkImgArray.add(elkCImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/elk/elk-c.png"))));

        //Hawk
        hawkImgArray = new ArrayList<>();
        hawkImgArray.add(hawkAImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/hawk/hawk-a.png"))));
        hawkImgArray.add(hawkBImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/hawk/hawk-b.png"))));
        hawkImgArray.add(hawkCImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/hawk/hawk-c.png"))));

        //Fox
        foxImgArray = new ArrayList<>();
        foxImgArray.add(foxAImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/fox/fox-a.png"))));
        foxImgArray.add(foxBImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/fox/fox-b.png"))));
        foxImgArray.add(foxCImg = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Scoring Cards/fox/fox-c.png"))));

        //Randomly generated and picked from arraylist of image address.
        Random rand = new Random();
        int randomIndex = rand.nextInt(bearImgArray.size());

        //Bear
        Rectangle bearScoreCard = new Rectangle();
        bearScoreCard.setFill(new ImagePattern(bearImgArray.get(randomIndex)));
        bearScoreCard.setHeight(200);
        bearScoreCard.setWidth(150);
        bearScoreCard.setLayoutX(50);
        bearScoreCard.setLayoutY(100);

        //Salmon
        Rectangle salmonScoreCard = new Rectangle();
        salmonScoreCard.setFill(new ImagePattern(salmonImgArray.get(randomIndex)));
        salmonScoreCard.setHeight(200);
        salmonScoreCard.setWidth(150);
        salmonScoreCard.setLayoutX(225);
        salmonScoreCard.setLayoutY(100);

        //Elk
        Rectangle elkScoreCard = new Rectangle();
        elkScoreCard.setFill(new ImagePattern(elkImgArray.get(randomIndex)));
        elkScoreCard.setHeight(200);
        elkScoreCard.setWidth(150);
        elkScoreCard.setLayoutX(400);
        elkScoreCard.setLayoutY(100);

        //Hawk
        Rectangle hawkScoreCard = new Rectangle();
        hawkScoreCard.setFill(new ImagePattern(hawkImgArray.get(randomIndex)));
        hawkScoreCard.setHeight(200);
        hawkScoreCard.setWidth(150);
        hawkScoreCard.setLayoutX(575);
        hawkScoreCard.setLayoutY(100);

        //Fox
        Rectangle foxScoreCard = new Rectangle();
        foxScoreCard.setFill(new ImagePattern(foxImgArray.get(randomIndex)));
        foxScoreCard.setHeight(200);
        foxScoreCard.setWidth(150);
        foxScoreCard.setLayoutX(750);
        foxScoreCard.setLayoutY(100);

        //Adding All the Scoring Card to the Pane (Grouped together).
        scoringCardPane.getChildren().add(bearScoreCard);
        scoringCardPane.getChildren().add(salmonScoreCard);
        scoringCardPane.getChildren().add(elkScoreCard);
        scoringCardPane.getChildren().add(hawkScoreCard);
        scoringCardPane.getChildren().add(foxScoreCard);

        //Button to Close the Stage and continue to play Game.
        Buttons close = new Buttons("OK");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scoringCardStage.close();
            }// Command to close Stage
        });
        close.setLayoutY(350);
        close.setLayoutX(475);
        scoringCardPane.getChildren().add(close);

        scoringCardStage.show();

    }
}
