/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.gameView;

import java.util.ArrayList;

//Wild Life Token Bag to Store wild Life tokens in an Arraylist.
public class wTokenBag {
    //Arraylist to store wild life tokens
    public ArrayList<wildlife_Tokens> wildBag;
    public wTokenBag(){
        createWildBag();
    }
    public void createWildBag(){
        wildBag = new ArrayList<>();
        //for loop to add 20 instances of 5 different wild life tokens
        for (int i=1;i<=20;i++){
            wildlife_Tokens elk = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Elk);
            wildlife_Tokens bear = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Bear);
            wildlife_Tokens Hawk = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Hawk);
            wildlife_Tokens salmon = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Salmon);
            wildlife_Tokens fox = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.Fox);

            wildBag.add(bear);
            wildBag.add(elk);
            wildBag.add(Hawk);
            wildBag.add(salmon);
            wildBag.add(fox);
        }
    }


}
