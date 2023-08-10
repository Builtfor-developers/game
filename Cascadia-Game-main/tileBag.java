/*
Group Number 32
Student Names and GitHub IDs:
    Bhavya Bhatia 29760014
    Mayank Sehrawat 87071103
 */
package com.gameView;

import java.util.ArrayList;

public class tileBag {
    public ArrayList<Tiles> tileBagArray;

    public tileBag() {
        tileBagArray = new ArrayList<>();


        //change
        Tiles lakeBear = new Tiles();
        lakeBear.create_Tile(Tiles.Tiles_Type.Lake, Tiles.wildlife_Type.Bear,"/cascadia images new/lake-bear-key.png");
        tileBagArray.add(lakeBear);
        lakeBear.keyStoneTile=true;

        Tiles lakeHawk = new Tiles();
        lakeHawk.create_Tile(Tiles.Tiles_Type.Lake, Tiles.wildlife_Type.Hawk,"/cascadia images new/lake-hawk-key.png");
        tileBagArray.add(lakeHawk);
        lakeHawk.keyStoneTile=true;

        Tiles lakeSalmon = new Tiles();
        lakeSalmon.create_Tile(Tiles.Tiles_Type.Lake, Tiles.wildlife_Type.Salmon,"/cascadia images new/lake-salmon-key.png");
        tileBagArray.add(lakeSalmon);
        lakeSalmon.keyStoneTile=true;

        Tiles lakeMountBearElk = new Tiles();
        lakeMountBearElk.create_Tile(Tiles.Tiles_Type.Lake_and_Mountain, Tiles.wildlife_Type.Bear_and_Elk,"/cascadia images new/lake+mountain-bear-elk.png");
        tileBagArray.add(lakeMountBearElk);

        Tiles lakeMountBearHawk = new Tiles();
        lakeMountBearHawk.create_Tile(Tiles.Tiles_Type.Lake_and_Mountain, Tiles.wildlife_Type.Bear_and_Hawk,"/cascadia images new/lake+mountain-hawk-bear.png");
        tileBagArray.add(lakeMountBearHawk);

        Tiles lakeMountainHawkElk = new Tiles();
        lakeMountainHawkElk.create_Tile(Tiles.Tiles_Type.Lake_and_Mountain, Tiles.wildlife_Type.Hawk_and_Elk,"/cascadia images new/lake+mountain-hawk-elk.png");
        tileBagArray.add(lakeMountainHawkElk);

        Tiles lakeMountainSalmonBear = new Tiles();
        lakeMountainSalmonBear.create_Tile(Tiles.Tiles_Type.Lake_and_Mountain, Tiles.wildlife_Type.Bear_and_Salmon,"/cascadia images new/lake+mountain-salmon-bear.png");
        tileBagArray.add(lakeMountainSalmonBear);

        Tiles lakeMountainSalmonBearHawk = new Tiles();
        lakeMountainSalmonBearHawk.create_Tile(Tiles.Tiles_Type.Lake_and_Mountain, Tiles.wildlife_Type.Hawk_and_Salmon_and_Bear,"/cascadia images new/lake+mountain-salmon-bear-hawk.png");
        tileBagArray.add(lakeMountainSalmonBearHawk);

        Tiles lakeMountainSalmonHawk = new Tiles();
        lakeMountainSalmonHawk.create_Tile(Tiles.Tiles_Type.Lake_and_Mountain, Tiles.wildlife_Type.Hawk_and_Salmon,"/cascadia images new/lake+mountain-salmon-hawk.png");
        tileBagArray.add(lakeMountainSalmonHawk);

        Tiles mountainDesertFoxElkBear = new Tiles();
        mountainDesertFoxElkBear.create_Tile(Tiles.Tiles_Type.Mountain_and_Desert, Tiles.wildlife_Type.Fox_and_Elk_and_Bear,"/cascadia images new/mountain+desert-fox-elk-bear.png");
        tileBagArray.add(mountainDesertFoxElkBear);

        Tiles mountainDesertSalmonBearFox = new Tiles();
        mountainDesertSalmonBearFox.create_Tile(Tiles.Tiles_Type.Mountain_and_Desert, Tiles.wildlife_Type.Salmon_Bear_Fox,"/cascadia images new/mountain+desert-salmon-bear-fox.png");
        tileBagArray.add(mountainDesertSalmonBearFox);

        Tiles mountainDesertSalmonElk = new Tiles();
        mountainDesertSalmonElk.create_Tile(Tiles.Tiles_Type.Mountain_and_Desert, Tiles.wildlife_Type.Elk_and_Salmon,"/cascadia images new/mountain+desert-salmon-elk.png");
        tileBagArray.add(mountainDesertSalmonElk);

        Tiles mountainForestBearFox = new Tiles();
        mountainForestBearFox.create_Tile(Tiles.Tiles_Type.Mountain_and_Forest, Tiles.wildlife_Type.Fox_and_Bear,"/cascadia images new/mountain+forest-bear-fox.png");
        tileBagArray.add(mountainForestBearFox);

        Tiles mountainForestElkFox = new Tiles();
        mountainForestElkFox.create_Tile(Tiles.Tiles_Type.Mountain_and_Forest, Tiles.wildlife_Type.Fox_and_Elk,"/cascadia images new/mountain+forest-elk-fox.png");
        tileBagArray.add(mountainForestElkFox);

        Tiles mountainForestFoxELkBear = new Tiles();
        mountainForestFoxELkBear.create_Tile(Tiles.Tiles_Type.Mountain_and_Forest, Tiles.wildlife_Type.Fox_and_Elk_and_Bear,"/cascadia images new/mountain+forest-fox-elk-bear.png");
        tileBagArray.add(mountainForestFoxELkBear);

        Tiles mountainForestHawkBear = new Tiles();
        mountainForestHawkBear.create_Tile(Tiles.Tiles_Type.Mountain_and_Forest, Tiles.wildlife_Type.Bear_and_Hawk,"/cascadia images new/mountain+forest-hawk-bear.png");
        tileBagArray.add(mountainForestHawkBear);

        Tiles mountainForestHawkElkBear = new Tiles();
        mountainForestHawkElkBear.create_Tile(Tiles.Tiles_Type.Mountain_and_Forest, Tiles.wildlife_Type.Elk_and_Hawk_and_Bear,"/cascadia images new/mountain+forest-hawk-elk-bear.png");
        tileBagArray.add(mountainForestHawkElkBear);

        Tiles mountainSwampBearSalmon = new Tiles();
        mountainSwampBearSalmon.create_Tile(Tiles.Tiles_Type.Mountain_and_Swamp, Tiles.wildlife_Type.Bear_and_Salmon,"/cascadia images new/mountain+swamp-bear-salmon.png");
        tileBagArray.add(mountainSwampBearSalmon);

        Tiles mountainSwampElkFox = new Tiles();
        mountainSwampElkFox.create_Tile(Tiles.Tiles_Type.Mountain_and_Swamp, Tiles.wildlife_Type.Fox_and_Elk,"/cascadia images new/mountain+swamp-elk-fox.png");
        tileBagArray.add(mountainSwampElkFox);

        Tiles mountainSwampElkHawk = new Tiles();
        mountainSwampElkHawk.create_Tile(Tiles.Tiles_Type.Mountain_and_Swamp, Tiles.wildlife_Type.Elk_and_Hawk,"/cascadia images new/mountain+swamp-elk-hawk.png");
        tileBagArray.add(mountainSwampElkHawk);

        Tiles mountainSwampFoxBearHawk = new Tiles();
        mountainSwampFoxBearHawk.create_Tile(Tiles.Tiles_Type.Mountain_and_Swamp, Tiles.wildlife_Type.Elk_and_Salmon_and_Bear,"/cascadia images new/mountain+swamp-salmon-elk-bear.png");
        tileBagArray.add(mountainSwampFoxBearHawk);

        Tiles mountainBear = new Tiles();
        mountainBear.create_Tile(Tiles.Tiles_Type.Mountain, Tiles.wildlife_Type.Bear,"/cascadia images new/mountain-bear-key.png");
        tileBagArray.add(mountainBear);
        mountainBear.keyStoneTile=true;

        Tiles mountainElk = new Tiles();
        mountainElk.create_Tile(Tiles.Tiles_Type.Mountain, Tiles.wildlife_Type.Elk,"/cascadia images new/mountain-elk-key.png");
        tileBagArray.add(mountainElk);
        mountainElk.keyStoneTile=true;

        Tiles mountainHawk = new Tiles();
        mountainHawk.create_Tile(Tiles.Tiles_Type.Mountain, Tiles.wildlife_Type.Hawk,"/cascadia images new/mountain-hawk-key.png");
        tileBagArray.add(mountainHawk);
        mountainHawk.keyStoneTile=true;

        Tiles swampLakeBearSalmonHawk = new Tiles();
        swampLakeBearSalmonHawk.create_Tile(Tiles.Tiles_Type.Swamp_and_Lake, Tiles.wildlife_Type.Hawk_and_Salmon_and_Bear,"/cascadia images new/swamp+lake-bear-salmon-hawk.png");
        tileBagArray.add(swampLakeBearSalmonHawk);

        Tiles swampLakeFoxHawk = new Tiles();
        swampLakeFoxHawk.create_Tile(Tiles.Tiles_Type.Swamp_and_Lake, Tiles.wildlife_Type.Fox_and_Hawk,"/cascadia images new/swamp+lake-fox-hawk.png");
        tileBagArray.add(swampLakeFoxHawk);

        Tiles swampLakeFoxSalmon = new Tiles();
        swampLakeFoxSalmon.create_Tile(Tiles.Tiles_Type.Swamp_and_Lake, Tiles.wildlife_Type.Fox_and_Salmon,"/cascadia images new/swamp+lake-fox-salmon.png");
        tileBagArray.add(swampLakeFoxSalmon);

        Tiles swampLakeHawkBear = new Tiles();
        swampLakeHawkBear.create_Tile(Tiles.Tiles_Type.Swamp_and_Lake, Tiles.wildlife_Type.Bear_and_Hawk,"/cascadia images new/swamp+lake-hawk-bear.png");
        tileBagArray.add(swampLakeHawkBear);

        Tiles swampLakeSalmonBear = new Tiles();
        swampLakeSalmonBear.create_Tile(Tiles.Tiles_Type.Swamp_and_Lake, Tiles.wildlife_Type.Bear_and_Salmon,"/cascadia images new/swamp+lake-hawk-bear.png");
        tileBagArray.add(swampLakeSalmonBear);

        Tiles swampLakeSalmonHawk = new Tiles();
        swampLakeSalmonHawk.create_Tile(Tiles.Tiles_Type.Swamp_and_Lake, Tiles.wildlife_Type.Hawk_and_Salmon,"/cascadia images new/swamp+lake-salmon-hawk.png");
        tileBagArray.add(swampLakeSalmonHawk);

        Tiles swampFox = new Tiles();
        swampFox.create_Tile(Tiles.Tiles_Type.Swamp, Tiles.wildlife_Type.Fox,"/cascadia images new/swamp-fox-key.png");
        tileBagArray.add(swampFox);
        swampFox.keyStoneTile=true;

        Tiles swampHawk = new Tiles();
        swampHawk.create_Tile(Tiles.Tiles_Type.Swamp, Tiles.wildlife_Type.Hawk,"/cascadia images new/swamp-hawk-key.png");
        tileBagArray.add(swampHawk);
        swampHawk.keyStoneTile=true;

        Tiles swampSalmon = new Tiles();
        swampSalmon.create_Tile(Tiles.Tiles_Type.Swamp, Tiles.wildlife_Type.Salmon,"/cascadia images new/swamp-salmon-key.png");
        tileBagArray.add(swampSalmon);
        swampSalmon.keyStoneTile=true;

        Tiles desertElk = new Tiles();
        desertElk.create_Tile(Tiles.Tiles_Type.Desert, Tiles.wildlife_Type.Elk,"/cascadia images new/desert-elk-key.png");
        desertElk.keyStoneTile=true;
        tileBagArray.add(desertElk);

        Tiles desertFox = new Tiles();
        desertFox.create_Tile(Tiles.Tiles_Type.Desert, Tiles.wildlife_Type.Fox, "/cascadia images new/desert-fox-key.png");
        desertFox.keyStoneTile=true;
        tileBagArray.add(desertFox);

        Tiles desertSalmon = new Tiles();
        desertSalmon.create_Tile(Tiles.Tiles_Type.Desert, Tiles.wildlife_Type.Salmon, "/cascadia images new/desert-salmon-key.png");
        desertSalmon.keyStoneTile=true;
        tileBagArray.add(desertSalmon);

        Tiles desertLakeElkHawk = new Tiles();
        desertLakeElkHawk.create_Tile(Tiles.Tiles_Type.Desert_and_Lake, Tiles.wildlife_Type.Elk_and_Hawk, "/cascadia images new/desert+lake-elk-hawk.png");
        tileBagArray.add(desertLakeElkHawk);

        Tiles desertLakeElkSalmon = new Tiles();
        desertLakeElkSalmon.create_Tile(Tiles.Tiles_Type.Desert_and_Lake, Tiles.wildlife_Type.Elk_and_Salmon, "/cascadia images new/desert+lake-elk-salmon.png");
        tileBagArray.add(desertLakeElkSalmon);

        Tiles desertLakeFoxBear = new Tiles();
        desertLakeFoxBear.create_Tile(Tiles.Tiles_Type.Desert_and_Lake, Tiles.wildlife_Type.Fox_and_Bear, "/cascadia images new/desert+lake-fox-bear.png");
        tileBagArray.add(desertLakeFoxBear);

        Tiles desertLakeFoxHawkBear = new Tiles();
        desertLakeFoxHawkBear.create_Tile(Tiles.Tiles_Type.Desert_and_Lake, Tiles.wildlife_Type.Fox_and_Hawk_and_Bear, "/cascadia images new/desert+lake-fox-hawk-bear.png");
        tileBagArray.add(desertLakeFoxHawkBear);

        Tiles desertLakeFoxHawk = new Tiles();
        desertLakeFoxHawk.create_Tile(Tiles.Tiles_Type.Desert_and_Lake, Tiles.wildlife_Type.Fox_and_Hawk, "/cascadia images new/desert+lake-fox-hawk.png");
        tileBagArray.add(desertLakeFoxHawk);

        Tiles desertLakeSalmonBearFox = new Tiles();
        desertLakeSalmonBearFox.create_Tile(Tiles.Tiles_Type.Desert_and_Lake, Tiles.wildlife_Type.Fox_and_Salmon_and_Bear, "/cascadia images new/desert+lake-salmon-bear-fox.png");
        tileBagArray.add(desertLakeSalmonBearFox);

        Tiles desertSwampElkFox = new Tiles();
        desertSwampElkFox.create_Tile(Tiles.Tiles_Type.Desert_and_Swamp, Tiles.wildlife_Type.Fox_and_Elk, "/cascadia images new/desert+swamp-elk-fox.png");
        tileBagArray.add(desertSwampElkFox);

        Tiles desertSwampElkSalmon = new Tiles();
        desertSwampElkSalmon.create_Tile(Tiles.Tiles_Type.Desert_and_Swamp, Tiles.wildlife_Type.Elk_and_Salmon, "/cascadia images new/desert+swamp-elk-salmon.png");
        tileBagArray.add(desertSwampElkSalmon);

        Tiles desertSwampHawkFox = new Tiles();
        desertSwampHawkFox.create_Tile(Tiles.Tiles_Type.Desert_and_Swamp, Tiles.wildlife_Type.Fox_and_Hawk, "/cascadia images new/desert+swamp-hawk-fox.png");
        tileBagArray.add(desertSwampHawkFox);

        Tiles desertSwampHawkSalmon = new Tiles();
        desertSwampHawkSalmon.create_Tile(Tiles.Tiles_Type.Desert_and_Swamp, Tiles.wildlife_Type.Hawk_and_Salmon, "/cascadia images new/desert+swamp-hawk-salmon.png");
        tileBagArray.add(desertSwampHawkSalmon);

        Tiles desertSwampSalmonElkFox = new Tiles();
        desertSwampSalmonElkFox.create_Tile(Tiles.Tiles_Type.Desert_and_Swamp, Tiles.wildlife_Type.Fox_and_Elk_and_Salmon, "/cascadia images new/desert+swamp-salmon-elk-fox.png");
        tileBagArray.add(desertSwampSalmonElkFox);

        Tiles desertSwampSalmonHawkFox = new Tiles();
        desertSwampSalmonHawkFox.create_Tile(Tiles.Tiles_Type.Desert_and_Swamp, Tiles.wildlife_Type.Fox_and_Hawk_and_Salmon, "/cascadia images new/desert+swamp-salmon-hawk-fox.png");
        tileBagArray.add(desertSwampSalmonHawkFox);

        Tiles forestBear = new Tiles();
        forestBear.create_Tile(Tiles.Tiles_Type.Forest, Tiles.wildlife_Type.Bear, "/cascadia images new/forest-bear-key.png");
        forestBear.keyStoneTile=true;
        tileBagArray.add(forestBear);

        Tiles forestElk = new Tiles();
        forestElk.create_Tile(Tiles.Tiles_Type.Forest, Tiles.wildlife_Type.Elk, "/cascadia images new/forest-elk-key.png");
        forestElk.keyStoneTile=true;
        tileBagArray.add(forestElk);

        Tiles forestFox = new Tiles();
        forestFox.create_Tile(Tiles.Tiles_Type.Forest, Tiles.wildlife_Type.Fox, "/cascadia images new/forest-fox-key.png");
        forestFox.keyStoneTile=true;
        tileBagArray.add(forestFox);

        Tiles forestDesertBearElk = new Tiles();
        forestDesertBearElk.create_Tile(Tiles.Tiles_Type.Forest_and_Desert, Tiles.wildlife_Type.Bear_and_Elk, "/cascadia images new/forest+desert-bear-elk.png");
        tileBagArray.add(forestDesertBearElk);

        Tiles forestDesertElkFoxSalmon = new Tiles();
        forestDesertElkFoxSalmon.create_Tile(Tiles.Tiles_Type.Forest_and_Desert, Tiles.wildlife_Type.Fox_and_Elk_and_Salmon, "/cascadia images new/forest+desert-elk-fox-salmon.png");
        tileBagArray.add(forestDesertElkFoxSalmon);

        Tiles forestDesertElkFox = new Tiles();
        forestDesertElkFox.create_Tile(Tiles.Tiles_Type.Forest_and_Desert, Tiles.wildlife_Type.Fox_and_Elk, "/cascadia images new/forest+desert-elk-fox.png");
        tileBagArray.add(forestDesertElkFox);

        Tiles forestDesertElkSalmon = new Tiles();
        forestDesertElkSalmon.create_Tile(Tiles.Tiles_Type.Forest_and_Desert, Tiles.wildlife_Type.Elk_and_Salmon, "/cascadia images new/forest+desert-elk-salmon.png");
        tileBagArray.add(forestDesertElkSalmon);

        Tiles forestDesertFoxSalmon = new Tiles();
        forestDesertFoxSalmon.create_Tile(Tiles.Tiles_Type.Forest_and_Desert, Tiles.wildlife_Type.Fox_and_Salmon, "/cascadia images new/forest+desert-fox-salmon.png");
        tileBagArray.add(forestDesertFoxSalmon);

        Tiles forestLakeBearSalmon = new Tiles();
        forestLakeBearSalmon.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Bear_and_Salmon, "/cascadia images new/forest+lake-bear-salmon.png");
        tileBagArray.add(forestLakeBearSalmon);

        Tiles forestLakeElkBear = new Tiles();
        forestLakeElkBear.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Bear_and_Elk, "/cascadia images new/forest+lake-elk-bear.png");
        tileBagArray.add(forestLakeElkBear);

        Tiles forestLakeElkHawk = new Tiles();
        forestLakeElkHawk.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Elk_and_Hawk, "/cascadia images new/forest+lake-elk-hawk.png");
        tileBagArray.add(forestLakeElkHawk);

        Tiles forestLakeFoxBear = new Tiles();
        forestLakeFoxBear.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Fox_and_Bear, "/cascadia images new/forest+lake-fox-bear.png");
        tileBagArray.add(forestLakeFoxBear);

        Tiles forestLakeFoxSalmon = new Tiles();
        forestLakeFoxSalmon.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Fox_and_Salmon, "/cascadia images new/forest+lake-fox-salmon.png");
        tileBagArray.add(forestLakeFoxSalmon);

        Tiles forestLakeHawkElkFox = new Tiles();
        forestLakeHawkElkFox.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Hawk_and_Fox_and_Elk, "/cascadia images new/forest+lake-hawk-elk-fox.png");
        tileBagArray.add(forestLakeHawkElkFox);

        Tiles forestLakeHawkElk = new Tiles();
        forestLakeHawkElk.create_Tile(Tiles.Tiles_Type.Forest_and_Lake, Tiles.wildlife_Type.Elk_and_Hawk, "/cascadia images new/forest+lake-hawk-elk.png");
        tileBagArray.add(forestLakeHawkElk);

        Tiles forestSwampBearFox = new Tiles();
        forestSwampBearFox.create_Tile(Tiles.Tiles_Type.Forest_and_Swamp, Tiles.wildlife_Type.Fox_and_Bear, "/cascadia images new/forest+swamp-bear-fox.png");
        tileBagArray.add(forestSwampBearFox);

        Tiles forestSwampBearSalmon = new Tiles();
        forestSwampBearSalmon.create_Tile(Tiles.Tiles_Type.Forest_and_Swamp, Tiles.wildlife_Type.Bear_and_Salmon, "/cascadia images new/forest+swamp-bear-salmon.png");
        tileBagArray.add(forestSwampBearSalmon);

        Tiles forestSwampElkHawk = new Tiles();
        forestSwampElkHawk.create_Tile(Tiles.Tiles_Type.Forest_and_Swamp, Tiles.wildlife_Type.Elk_and_Hawk, "/cascadia images new/forest+swamp-elk-hawk.png");
        tileBagArray.add(forestSwampElkHawk);

        Tiles forestSwampElkSalmon = new Tiles();
        forestSwampElkSalmon.create_Tile(Tiles.Tiles_Type.Forest_and_Swamp, Tiles.wildlife_Type.Elk_and_Salmon, "/cascadia images new/forest+swamp-elk-salmon.png");
        tileBagArray.add(forestSwampElkSalmon);

        Tiles forestSwampFoxHawk = new Tiles();
        forestSwampFoxHawk.create_Tile(Tiles.Tiles_Type.Forest_and_Swamp, Tiles.wildlife_Type.Fox_and_Hawk, "/cascadia images new/forest+swamp-fox-hawk.png");
        tileBagArray.add(forestSwampFoxHawk);

        Tiles forestSwampSalmonElkHawk = new Tiles();
        forestSwampSalmonElkHawk.create_Tile(Tiles.Tiles_Type.Forest_and_Swamp, Tiles.wildlife_Type.Hawk_and_Salmon_and_Elk, "/cascadia images new/forest+swamp-salmon-elk-hawk.png");
        tileBagArray.add(forestSwampSalmonElkHawk);

    }




}
