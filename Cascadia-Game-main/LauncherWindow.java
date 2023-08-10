package com.cascadia.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/*
Main file to launch game cascadia
 */
public class LauncherWindow extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ViewLauncher view = new ViewLauncher();
        stage = view.getPrimaryStage();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
