/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.gameView;

import java.util.ArrayList;
import java.util.HashSet;


//Scoring WildLife
public class scoringWildlife {
    public ArrayList<wildlife_Tokens.wildlife_Type> tempArrayWildLife;
    public int numberHawk, numberBear;
    private static int numBear = 0, numElk = 0, numSalmon = 0, numFoxPairs = 0;
    public int elkScore,foxScore,salmonScore, finalWildLifeScore;

    public scoringWildlife(wildlife_Tokens[][] wildlifeArray) {//calculate and display score in console
        defineEmpty(wildlifeArray);
        //Moving through the wildLifeArraylist and checking every wildlife token placed
        for (int i = 0; i < wildlifeArray.length;i++){
            for (int j = 0; j < wildlifeArray[i].length; j++) {

                if (wildlifeArray[i][j] != null && !wildlifeArray[i][j].tokenChecked) {//only checking if it is not null and not check already.
                    foxScore += checkFoxA(wildlifeArray, i, j);//fox Score
                    numberHawk += checkHawkA(wildlifeArray, i, j);//hawk Score
                    numberBear += checkBearA(wildlifeArray, i, j);//Bear Score
                    if (checkElkAandB(wildlifeArray, i, j) != 0) {
                        elkScore += scoreElkA(checkElkAandB(wildlifeArray, i, j));//Elk Score
                        numElk = 0;
                    }
                    if (checkSalmonA(wildlifeArray, i, j) != 0) {
                        salmonScore+=scoreSalmonA(checkSalmonA(wildlifeArray, i, j));//salmon Score
                        numSalmon = 0;
                    }
                }
            }
        }

        System.out.println("SalmonA " + salmonScore + " end");
        System.out.println("FoxA " + foxScore + " end");
        System.out.println("ElkA " + elkScore + " end");
        System.out.println("hawksA " + scoreHawk(numberHawk) + " end");
        System.out.println("BearA " + scoreBearA(numBear) + " end");
        finalWildLifeScore = salmonScore+foxScore+elkScore+scoreHawk(numberHawk)+scoreBearA(numberBear);
        System.out.println("Final Wild Life Score is "+finalWildLifeScore);
    }

    //Checking For Hawk in thisn function we check only upcoming 3 surrounding tiles.
    /**
     * @param wildlifeArray
     * @param row
     * @param col
     * @return int
     */
    public static int checkHawkA(wildlife_Tokens[][] wildlifeArray, int row, int col) {
        if (wildlifeArray[row][col].getType() == wildlife_Tokens.wildlife_Type.Hawk) {
            int violation = 0;
            if(row % 2 == 0) {
                if (wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Hawk) {
                    checkHawkA(wildlifeArray, row + 1, col + 1);
                    wildlifeArray[row + 1][col + 1].tokenChecked = true;
                    violation += 1;
                }
            } else {
                if (col != 0){
                    if (wildlifeArray[row + 1][col - 1].getType() == wildlife_Tokens.wildlife_Type.Hawk){
                        checkHawkA(wildlifeArray, row + 1, col - 1);
                        wildlifeArray[row + 1][col - 1].tokenChecked = true;
                        violation += 1;
                    }
                }
            }

            if (wildlifeArray[row][col + 1].getType()== wildlife_Tokens.wildlife_Type.Hawk ) {
                checkHawkA(wildlifeArray,row,col + 1);
                wildlifeArray[row][col + 1].tokenChecked = true;
                violation += 1;
            }

            if(wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Hawk) {
                checkHawkA(wildlifeArray,row + 1,col);
                wildlifeArray[row + 1][col].tokenChecked = true;
                violation += 1;
            }

            if (violation == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        return 0;
    }

    //scoring hawk on number of valid hawks on the grid
    /**
     * @param numHawk
     * @return int
     */
    public int scoreHawk(int numHawk){
        if (numHawk == 1) {
            return 2;
        } else if (numHawk == 2) {
            return 5;
        } else if (numHawk == 3) {
            return 8;
        } else if (numHawk == 4) {
            return 11;
        } else if (numHawk == 5) {
            return 14;
        } else if (numHawk == 6) {
            return 18;
        } else if (numHawk == 7) {
            return 22;
        } else if (numHawk >= 8) {
            return 26;
        }
        else {
            return 0;
        }
    }

    //Checking Bear function first check if surrounding tiles have only one bear and call recursively there after adn makes pair more than 2 is inavlid
    /**
     * @param wildlifeArray
     * @param row
     * @param col
     * @return int
     */
    public static int checkBearA(wildlife_Tokens[][] wildlifeArray,int row, int col){

        if (wildlifeArray[row][col].getType()== wildlife_Tokens.wildlife_Type.Bear){
            if (row % 2 == 0) {
                if ((wildlifeArray[row][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear ^ wildlifeArray[row + 1][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear ^ wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear)
                        ^(wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear && wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear && wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear))
                {
                    if (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numBear+=checkBearA(wildlifeArray,row,col + 1);
                    }

                    if (wildlifeArray[row + 1][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col + 1].tokenChecked = true;
                        numBear += checkBearA(wildlifeArray, row + 1, col + 1);
                    }

                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numBear+=checkBearA(wildlifeArray, row + 1, col);
                    }
                    numBear += 1;
                    if(numBear <= 1){
                        return numBear;
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    if (wildlifeArray[row][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row][col + 1].tokenChecked = true;

                    }
                    if (wildlifeArray[row + 1][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col + 1].tokenChecked = true;
                    }
                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                    }
                    return 0;
                }
            }
            if (col != 0) {


                if ((wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear ^ wildlifeArray[row + 1][col-1].getType() == wildlife_Tokens.wildlife_Type.Bear ^ wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear)
                        ^ (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear && wildlifeArray[row + 1][col - 1].getType() == wildlife_Tokens.wildlife_Type.Bear && wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear))
                {
                    if (wildlifeArray[row][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numBear+=checkBearA(wildlifeArray,row,col+1);
                    }
                    if (wildlifeArray[row + 1][col - 1].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col - 1].tokenChecked = true;
                        numBear += checkBearA(wildlifeArray, row + 1, col - 1);
                    }
                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numBear+=checkBearA(wildlifeArray, row + 1, col);
                    }
                    numBear += 1;
                    if(numBear <= 1){
                        return numBear;
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    if (wildlifeArray[row][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row][col + 1].tokenChecked = true;

                    }
                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                    }
                    return 0;
                }
            }
        }
        else {
            return 0;
        }
        return 0;

    }
    // scoring Bear accoring to the pair of bear on the grid
    /**
     * @param numPairBear
     * @return int
     */
    public int scoreBearA(int numPairBear){
        if (numPairBear == 1){
            return 4;
        } else if (numPairBear == 2) {
            return 11;
        } else if (numPairBear == 3) {
            return 19;
        } else if (numPairBear == 4) {
            return 27;
        }
        else {
            return 0;
        }
    }

    //Checking Bear for B tyoe scoring card here they make group of three calling function recursively and checking surroundings
    /**
     * @param wildlifeArray
     * @param row
     * @param col
     * @return int
     */
    public int checkBearB(wildlife_Tokens[][] wildlifeArray,int row, int col){
        if(wildlifeArray[row][col].getType()== wildlife_Tokens.wildlife_Type.Bear){
            numBear += 1;

            if((wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear ^ wildlifeArray[row + 1][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear ^ wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear)
                    ^(wildlifeArray[row][col + 1].getType()== wildlife_Tokens.wildlife_Type.Bear && wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear && wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear)){
                if(row % 2 == 0) {
                    if (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numBear+=checkElkAandB(wildlifeArray, row, col + 1);
                    }
                    if (wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col + 1].tokenChecked = true;
                        numBear+=checkElkAandB(wildlifeArray, row + 1, col + 1);
                    }
                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numBear+=checkElkAandB(wildlifeArray, row + 1, col);
                    }
                    return numBear;
                }
                else {

                    if (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numBear+=checkElkAandB(wildlifeArray, row, col + 1);
                    }
                    if (col != 0) {
                        if (wildlifeArray[row + 1][col - 1].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                            wildlifeArray[row + 1][col - 1].tokenChecked = true;
                            numBear+=checkElkAandB(wildlifeArray, row + 1,col - 1);
                        }
                    }

                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Bear) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numBear+=checkElkAandB(wildlifeArray, row + 1, col);
                    }
                    return numBear;
                }
            }
            else {
                return 0;
            }
        }
        else{
            return numBear;
        }
    }
    //Scoring Type B
    /**
     * @param numBear
     * @return int
     */
    public int scoreBearB(int numBear){
        if(numBear == 3){
            return 10;
        }
        else {
            return 0;
        }
    }

    //Checking Elk by checking surrounding tokens and ensuring they have only one elk if any. Returing number of total elk in a row together. calling functoin recursively
    /**
     * @param wildlifeArray
     * @param row
     * @param col
     * @return int
     */
    public int checkElkAandB(wildlife_Tokens[][] wildlifeArray, int row, int col){
        if(wildlifeArray[row][col].getType() == wildlife_Tokens.wildlife_Type.Elk){
            numElk += 1;
            if((wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Elk ^ wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Elk ^ wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Elk)
                    ^(wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Elk && wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Elk && wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Elk)){
                if(row % 2 == 0) {
                    if (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Elk) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numElk += checkElkAandB(wildlifeArray, row, col + 1);
                    }
                    if (wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Elk) {
                        wildlifeArray[row + 1][col + 1].tokenChecked = true;
                        numElk += checkElkAandB(wildlifeArray, row + 1, col + 1);
                    }
                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Elk) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numElk+=checkElkAandB(wildlifeArray, row + 1, col);
                    }
                    return numElk;
                }
                else {
                    if (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Elk) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numElk += checkElkAandB(wildlifeArray, row, col + 1);
                    }
                    if (col != 0) {
                        if (wildlifeArray[row + 1][col - 1].getType() == wildlife_Tokens.wildlife_Type.Elk) {
                            wildlifeArray[row + 1][col - 1].tokenChecked = true;
                            numElk+=checkElkAandB(wildlifeArray, row + 1, col - 1);
                        }
                    }

                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Elk) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numElk+=checkElkAandB(wildlifeArray, row + 1, col);
                    }
                    return numElk;
                }
            }
            else {
                return 0;
            }

        }
        else{
            return numElk;
        }
    }

    //scoring Elk according to A Score card of elk
    /**
     * @param numElk
     * @return int
     */
    public int scoreElkA(int numElk){
        if(numElk == 1) {
            return 2;
        } else if (numElk == 2) {
            return 5;
        } else if (numElk == 3) {
            return 9;
        }
        else if (numElk == 4){
            return 13;
        }
        else {
            return 0;
        }
    }
    //scoring Elk according to B Score card of elk
    /**
     * @param numElk
     * @return int
     */
    public int scoreElkB(int numElk) {
        if(numElk == 1){
            return 2;
        } else if (numElk == 2) {
            return 4;

        } else if (numElk == 3) {
            return 7;
        }
        else if (numElk == 4){
            return 10;
        }
        else if (numElk == 5) {
            return 14;
        } else if (numElk == 6) {
            return 18;
        }
        else if (numElk == 7) {
            return 23;
        } else if (numElk >= 8) {
            return 28;
        } else {
            return 0;
        }
    }

    //Checking Fox and counting number of unique tokens around it nad returing number.
    /**
     * @param wildlifeArray
     * @param row
     * @param col
     * @return int
     */
    public int checkFoxA(wildlife_Tokens[][] wildlifeArray, int row, int col) {
        if (wildlifeArray[row][col].getType() == wildlife_Tokens.wildlife_Type.Fox) {
            tempArrayWildLife = new ArrayList<>();
            tempArrayWildLife.add(wildlifeArray[row][col + 1].getType());
            tempArrayWildLife.add(wildlifeArray[row + 1][col].getType());
            if (row % 2 == 0){
                if (row != 0){
                    tempArrayWildLife.add(wildlifeArray[row - 1][col].getType());
                    tempArrayWildLife.add(wildlifeArray[row - 1][col + 1].getType());
                }
                tempArrayWildLife.add(wildlifeArray[row + 1][col + 1].getType());
                if (col != 0){
                    tempArrayWildLife.add(wildlifeArray[row][col - 1].getType());
                }
            }
            else{
                tempArrayWildLife.add(wildlifeArray[row - 1][col].getType());

                if (col!=0){
                    tempArrayWildLife.add(wildlifeArray[row][col - 1].getType());
                    tempArrayWildLife.add(wildlifeArray[row - 1][col - 1].getType());
                    tempArrayWildLife.add(wildlifeArray[row + 1][col - 1].getType());
                }
            }
            HashSet<wildlife_Tokens.wildlife_Type> uniqueAdjacentFox= new HashSet<wildlife_Tokens.wildlife_Type>(tempArrayWildLife);
            return uniqueAdjacentFox.size();
        }
        return 0;

    }
    //Checking Fox for B by number of pairs aorund it.
    /**
     * @param wildlifeArray
     * @param row
     * @param col
     * @return int
     */
    public int checkFoxB(wildlife_Tokens[][] wildlifeArray, int row , int col) {
        if (wildlifeArray[row][col].getType()  == wildlife_Tokens.wildlife_Type.Fox) {
            tempArrayWildLife = new ArrayList<>();
            tempArrayWildLife.add(wildlifeArray[row][col + 1].getType());
            tempArrayWildLife.add(wildlifeArray[row + 1][col].getType());
            if (row % 2 == 0) {
                if (row != 0) {
                    tempArrayWildLife.add(wildlifeArray[row - 1][col].getType());
                    tempArrayWildLife.add(wildlifeArray[row - 1][col + 1].getType());
                }
                tempArrayWildLife.add(wildlifeArray[row + 1][col + 1].getType());
                if (col != 0) {
                    tempArrayWildLife.add(wildlifeArray[row][col - 1].getType());
                }
            } else {
                tempArrayWildLife.add(wildlifeArray[row - 1][col].getType());

                if (col != 0) {
                    tempArrayWildLife.add(wildlifeArray[row][col - 1].getType());
                    tempArrayWildLife.add(wildlifeArray[row - 1][col - 1].getType());
                    tempArrayWildLife.add(wildlifeArray[row + 1][col - 1].getType());
                }
            }
        }
        for (int x = 0 ; x<tempArrayWildLife.size(); x++){
            for (int y = x + 1; y<tempArrayWildLife.size(); y++){
                if(tempArrayWildLife.get(x)==tempArrayWildLife.get(y)){
                    numFoxPairs+=1;
                }
            }
        }
        return numFoxPairs;
    }
    //Scoring Card for B
    public int scoreFoxB(int numFoxPairs){
        if(numFoxPairs == 1){
            return 3;
        } else if (numFoxPairs == 2) {
            return 5;
        } else if (numFoxPairs == 3) {
            return 7;
        }
        else {
            return 0;
        }
    }

    //checking Salmon by recursively calling and checking tokens around it and finding a chain of salmons and retuning number of salmon in one chain
    /**
     * @param wildlifeArray
     * @param row
     * @param col
     * @return int
     */
    public int checkSalmonA(wildlife_Tokens[][] wildlifeArray, int row, int col) {
        if(wildlifeArray[row][col].getType() == wildlife_Tokens.wildlife_Type.Salmon) {
            numSalmon += 1;

            if((wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Salmon ^ wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Salmon ^ wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Salmon)
                    ^(wildlifeArray[row][col + 1].getType()== wildlife_Tokens.wildlife_Type.Salmon && wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Salmon && wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Salmon)){
                if(row % 2 == 0) {
                    if (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Salmon) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numSalmon+=checkElkAandB(wildlifeArray,row,col + 1);
                    }
                    if (wildlifeArray[row + 1][col + 1].getType() == wildlife_Tokens.wildlife_Type.Salmon) {
                        wildlifeArray[row + 1][col + 1].tokenChecked = true;
                        numSalmon+=checkElkAandB(wildlifeArray, row + 1, col + 1);
                    }
                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Salmon) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numSalmon+=checkElkAandB(wildlifeArray, row + 1,col);
                    }
                    return numSalmon;
                }
                else {
                    if (wildlifeArray[row][col + 1].getType() == wildlife_Tokens.wildlife_Type.Salmon) {
                        wildlifeArray[row][col + 1].tokenChecked = true;
                        numSalmon+=checkElkAandB(wildlifeArray, row, col +1 );
                    }
                    if (col != 0) {
                        if (wildlifeArray[row + 1][col - 1].getType() == wildlife_Tokens.wildlife_Type.Salmon) {
                            wildlifeArray[row + 1][col - 1].tokenChecked = true;
                            numSalmon+=checkElkAandB(wildlifeArray, row + 1, col - 1);
                        }
                    }

                    if (wildlifeArray[row + 1][col].getType() == wildlife_Tokens.wildlife_Type.Salmon) {
                        wildlifeArray[row + 1][col].tokenChecked = true;
                        numSalmon += checkElkAandB(wildlifeArray, row + 1, col);
                    }
                    return numSalmon;
                }

            }
            else {
                return 0;
            }
        }
        else{
            return numSalmon;
        }

    }
    //scoring for A Scorecard
    /**
     * @param numSalmon
     * @return int
     */
    public int scoreSalmonA(int numSalmon){
        if(numSalmon == 1) {
            return 2;
        } else if (numSalmon == 2) {
            return 4;
        } else if (numSalmon == 3) {
            return 7;
        } else if (numSalmon == 4) {
            return 11;
        } else if (numSalmon == 5) {
            return 15;
        } else if (numSalmon == 6) {
            return 20;
        } else if (numSalmon >= 7) {
            return 26;
        } else {
            return 0;
        }
    }
    //scoring for B Scorecard
    /**
     * @param numSalmon
     * @return int
     */
    public int scoreSalmonB(int numSalmon){
        if(numSalmon == 1) {
            return 2;
        } else if (numSalmon == 2) {
            return 4;
        } else if (numSalmon == 3) {
            return 8;
        } else if (numSalmon >=4) {
            return 12;
        }
        else {
            return 0;
        }
    }
    //scoring for C Scorecard
    /**
     * @param numSalmon
     * @return int
     */
    public int scoreSalmonC(int numSalmon){
        if(numSalmon == 1) {
            return 2;
        } else if (numSalmon == 2) {
            return 4;
        } else if (numSalmon == 3) {
            return 9;
        } else if (numSalmon == 4){
            return 11;
        } else if (numSalmon >= 5) {
            return 17;
        }
        else {
            return 0;
        }
    }

    /**
     * @param wildlifeArray
     */
    public void defineEmpty(wildlife_Tokens[][] wildlifeArray) {
        for (int i = 0; i < wildlifeArray.length; i++){
            for (int j = 0; j < wildlifeArray[i].length; j++) {

                if (wildlifeArray[i][j] == null){
                    wildlife_Tokens empty = new wildlife_Tokens(wildlife_Tokens.wildlife_Type.empty);
                    empty.tokenChecked = true;
                    wildlifeArray[i][j] = empty;
                }
            }
        }
    }
}
