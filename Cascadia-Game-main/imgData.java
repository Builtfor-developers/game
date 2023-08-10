/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.gameView;

import javafx.scene.image.Image;
import java.util.Objects;

//Class to Store Image data of the wildLife Tokens
public class imgData {
    public Image hawkImage, BearImage, ElkImage, FoxImage,SalmonImage;
    //Data of Hawk Image
    public Image getHawkImage(){

        hawkImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Bird.png")));

        return hawkImage;
    }
    //Data of Bear Image
    public Image getBear(){

        BearImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Bear.png")));

        return BearImage;
    }
    //Data of Elk Image
    public Image getElk(){

        ElkImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/ELK.png")));

        return ElkImage;
    }
    //Data of Fox Image
    public Image getFox(){

        FoxImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Fox.png")));

        return FoxImage;
    }
    //Data of Salmon Image
    public Image getSalmon(){

        SalmonImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Salmon.png")));

        return SalmonImage;
    }
}
