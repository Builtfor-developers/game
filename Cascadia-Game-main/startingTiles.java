/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.gameView;

import java.util.ArrayList;

public class startingTiles {
    public ArrayList<Tiles> startingTile1,startingTile2,startingTile3,startingTile4,startingTile5;
    public static ArrayList<ArrayList<Tiles>> collectionStarterTiles;
    public startingTiles(){
        startingTile1 = new ArrayList<>();
        startingTile2 = new ArrayList<>();
        startingTile3 = new ArrayList<>();
        startingTile4 = new ArrayList<>();
        startingTile5 = new ArrayList<>();

        collectionStarterTiles = new ArrayList<>();


        // Starter tile 1
        Tiles swampHawk = new Tiles();
        swampHawk.create_Tile(Tiles.Tiles_Type.Swamp, Tiles.wildlife_Type.Hawk,"/cascadia images new/starter 1/swamp-hawk-key.png");
        swampHawk.keyStoneTile=true;
        startingTile1.add(swampHawk);


        Tiles mountainDesertBearFox = new Tiles();
        mountainDesertBearFox.create_Tile(Tiles.Tiles_Type.Mountain_and_Desert, Tiles.wildlife_Type.Fox_and_Bear,"/cascadia images new/starter 1/mountain+desert-bear-fox.png");


        Tiles forestLakeSalmonHawkElk = new Tiles();
        forestLakeSalmonHawkElk.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Hawk_and_Salmon_and_Elk,"/cascadia images new/starter 1/forest+lake-salmon-elk-hawk.png");

        startingTile1.add(forestLakeSalmonHawkElk);
        startingTile1.add(mountainDesertBearFox);

        //Starter Tile 2
        Tiles forestElk = new Tiles();
        forestElk.create_Tile(Tiles.Tiles_Type.Forest, Tiles.wildlife_Type.Elk,"/cascadia images new/starter 2/forest-elk-key.png");
        forestElk.keyStoneTile=true;

        Tiles desertSwampFoxSalmon  =new Tiles();
        desertSwampFoxSalmon.create_Tile(Tiles.Tiles_Type.Desert_and_Swamp, Tiles.wildlife_Type.Fox_and_Salmon,"/cascadia images new/starter 2/desert+swamp-fox-salmon.png");

        Tiles lakeMountainHawkElkBear = new Tiles();
        lakeMountainHawkElkBear.create_Tile(Tiles.Tiles_Type.Lake_and_Mountain, Tiles.wildlife_Type.Elk_and_Hawk_and_Bear,"/cascadia images new/starter 2/lake+mountain-hawk-elk-bear.png");

        startingTile2.add(forestElk);
        startingTile2.add(lakeMountainHawkElkBear);
        startingTile2.add(desertSwampFoxSalmon);


        //Starter Tile 3

        Tiles lakeSalmon = new Tiles();
        lakeSalmon.create_Tile(Tiles.Tiles_Type.Lake, Tiles.wildlife_Type.Salmon, "/cascadia images new/starter 3/lake-salmon-key.png");
        lakeSalmon.keyStoneTile=true;

        Tiles forestDesertSalmonElkBear = new Tiles();
        forestDesertSalmonElkBear.create_Tile(Tiles.Tiles_Type.Forest_and_Desert, Tiles.wildlife_Type.Elk_and_Salmon_and_Bear,"/cascadia images new/starter 3/forest+desert-salmon-elk-bear.png");

        Tiles mountainSwampFoxHawk = new Tiles();
        mountainSwampFoxHawk.create_Tile(Tiles.Tiles_Type.Mountain_and_Swamp, Tiles.wildlife_Type.Fox_and_Hawk,"/cascadia images new/starter 3/mountain+swamp-fox-hawk.png");

        startingTile3.add(lakeSalmon);
        startingTile3.add(forestDesertSalmonElkBear);
        startingTile3.add(mountainSwampFoxHawk);

        //Starting Tile 4

        Tiles desertFox = new Tiles();
        desertFox.create_Tile(Tiles.Tiles_Type.Desert, Tiles.wildlife_Type.Fox,"/cascadia images new/starter 4/desert-fox-key.png");
        desertFox.keyStoneTile=true;

        Tiles swampLakeSalmonFoxHawk = new Tiles();
        swampLakeSalmonFoxHawk.create_Tile(Tiles.Tiles_Type.Swamp_and_Lake, Tiles.wildlife_Type.Fox_and_Hawk_and_Salmon,"/cascadia images new/starter 4/swamp+lake-salmon-fox-hawk.png");

        Tiles mountainForestBearElk = new Tiles();
        mountainForestBearElk.create_Tile(Tiles.Tiles_Type.Mountain_and_Forest, Tiles.wildlife_Type.Bear_and_Elk,"/cascadia images new/starter 4/mountain+forest-bear-elk.png");

        startingTile4.add(desertFox);
        startingTile4.add(swampLakeSalmonFoxHawk);
        startingTile4.add(mountainForestBearElk);

        //Starter Tile 5
        Tiles mountainBear = new Tiles();
        mountainBear.create_Tile(Tiles.Tiles_Type.Mountain, Tiles.wildlife_Type.Bear,"/cascadia images new/starter 5/mountain-bear-key.png");
        mountainBear.keyStoneTile=true;

        Tiles forestSwampHawkElkFox = new Tiles();
        forestSwampHawkElkFox.create_Tile(Tiles.Tiles_Type.Forest_and_Swamp, Tiles.wildlife_Type.Hawk_and_Fox_and_Elk,"/cascadia images new/starter 5/forest+swamp-hawk-elk-fox.png");

        Tiles desertLakeSalmonBear = new Tiles();
        desertLakeSalmonBear.create_Tile(Tiles.Tiles_Type.Desert_and_Lake, Tiles.wildlife_Type.Bear_and_Salmon,"/cascadia images new/starter 5/desert+lake-salmon-bear.png");

        startingTile5.add(mountainBear);
        startingTile5.add(forestSwampHawkElkFox);
        startingTile5.add(desertLakeSalmonBear);

        collectionStarterTiles.add(startingTile1);
        collectionStarterTiles.add(startingTile2);
        collectionStarterTiles.add(startingTile3);
        collectionStarterTiles.add(startingTile4);
        collectionStarterTiles.add(startingTile5);

    }

}
