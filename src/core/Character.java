package core;

import edu.princeton.cs.algs4.StdDraw;
import tileengine.TETile;
import tileengine.Tileset;

import java.util.ArrayList;
import java.util.Random;

public class Character {
    EndGame endGame = new EndGame();
    Coins coins = new Coins();
    int coinsPickedUp = 0;
    boolean ifGameEnd;
    Objectives trials = new Objectives();
    Random rand;

    public ArrayList<Integer> generateAvatar (TETile[][] world, Random random) {
        ArrayList<Integer> avatarCoor = new ArrayList<>();
        Boolean placeCharacter = false;
        int randX;
        int randY;
        do {
            randX = random.nextInt(90);
            randY = random.nextInt(50);
            if (world[randX][randY] == Tileset.SAND) {
                world[randX][randY] = Tileset.AVATAR;
                placeCharacter = true;
            }
        }
        while (!placeCharacter);
            avatarCoor.add(randX);
            avatarCoor.add(randY);

            return avatarCoor;
        }

        public void setAvatarCoor(TETile[][] world, ArrayList<Integer> avatarCoor) {
            world[avatarCoor.getFirst()][avatarCoor.getLast()] = Tileset.AVATAR;
        }

    public ArrayList<Integer> moveChar(char input, TETile[][] world, ArrayList<Integer> avatarCoor, Random rand, Boolean trial, int OGCoins) {
        int xCoor = avatarCoor.get(0);
        int yCoor = avatarCoor.get(1);
        int trialNum = OGCoins;
        //int numCoinsPickedUp = avatarCoor.get(2);
        if (input == 'w') {
            avatarCoor = moveCharUp(world, avatarCoor, rand, trial, trialNum);
            //world[xCoor][yCoor] = Tileset.SAND;
        }
        if (input == 'a') {
            avatarCoor = moveCharLeft(world, avatarCoor, rand, trial, trialNum);
            //world[xCoor][yCoor] = Tileset.SAND;

        }
        if (input == 's') {
            avatarCoor = moveCharDown(world, avatarCoor, rand, trial, trialNum);
            //world[xCoor][yCoor] = Tileset.SAND;

        }
        if (input == 'd') {
            avatarCoor = moveCharRight(world, avatarCoor, rand, trial, trialNum);
            //world[xCoor][yCoor] = Tileset.SAND;

        }
//
        return avatarCoor;
    }

    public void ifExit(char input) {
        if ((input == 'q') || (input == 'Q')) {
            endGame.endGame();
        }
    }

    public ArrayList<Integer> moveCharUp(TETile[][] world, ArrayList<Integer> avatarCoor, Random rand, Boolean trial, int trialNum) {
        // RETURNS XY COOR, numCoinsPickedUp, OG Coins, if Trial True (0 false, 1 true)


        int xCoor = avatarCoor.get(0);
        int yCoor = avatarCoor.get(1);
        int numCoinsPickedUp;



        ArrayList<Integer> avatarPickedUpCoinArray = avatarPickedUpCoin(world, xCoor, yCoor + 1, rand, trial, trialNum);
        numCoinsPickedUp = avatarPickedUpCoinArray.getFirst();
        int trialHappening = avatarPickedUpCoinArray.get(1);
        trialNum = avatarPickedUpCoinArray.getLast();

        if (trialNum == 7) {
            numCoinsPickedUp = 0;
        }



        if (world[xCoor][yCoor + 1] == Tileset.SAND) {
            world[xCoor][yCoor] = Tileset.SAND;

            while (!avatarCoor.isEmpty()) {
                avatarCoor.remove(0);
            }
            avatarCoor.add(xCoor);
            avatarCoor.add(yCoor + 1);
            world[avatarCoor.getFirst()][avatarCoor.getLast()] = Tileset.AVATAR;
            avatarCoor.add(numCoinsPickedUp);
            avatarCoor.add(trialNum);
            avatarCoor.add(trialHappening);

        }
        //ifGameEnd = coins.triggerEndOfGame(numCoinsPickedUp);
//        if (ifGameEnd) {
//            world[xCoor][yCoor] = Tileset.SAND;
//            world[xCoor][yCoor + 1] = Tileset.AVATAR;
//            endGame.callEndGame(world);
//        }
        return avatarCoor;
    }
    public ArrayList<Integer> moveCharLeft(TETile[][] world, ArrayList<Integer> avatarCoor, Random rand, Boolean trial, int trialNum) {
        // RETURNS XY COOR, numCoinsPickedUp, OG Coins, if Trial True (0 false, 1 true)

        int xCoor = avatarCoor.get(0);
        int yCoor = avatarCoor.get(1);
        int numCoinsPickedUp;

        ArrayList<Integer> avatarPickedUpCoinArray = avatarPickedUpCoin(world, xCoor - 1, yCoor, rand, trial, trialNum);

        numCoinsPickedUp = avatarPickedUpCoinArray.getFirst();
        trialNum = avatarPickedUpCoinArray.getLast();
        int trialHappening = avatarPickedUpCoinArray.get(1);

        if (world[xCoor - 1][yCoor] == Tileset.SAND) {
            world[xCoor][yCoor] = Tileset.SAND;

            while (!avatarCoor.isEmpty()) {
                avatarCoor.remove(0);
            }
            avatarCoor.add(xCoor - 1);
            avatarCoor.add(yCoor);
            world[avatarCoor.getFirst()][avatarCoor.getLast()] = Tileset.AVATAR;
            avatarCoor.add(numCoinsPickedUp);
            avatarCoor.add(trialNum);
            avatarCoor.add(trialHappening);

        }
//        ifGameEnd = coins.triggerEndOfGame(numCoinsPickedUp);
//        if (ifGameEnd) {
//            world[xCoor][yCoor] = Tileset.SAND;
//            world[xCoor - 1][yCoor] = Tileset.AVATAR;
//            endGame.callEndGame(world);
//        }

        return avatarCoor;
    }

    public ArrayList<Integer> moveCharDown(TETile[][] world, ArrayList<Integer> avatarCoor, Random rand, Boolean trial, int trialNum) {
        // RETURNS XY COOR, numCoinsPickedUp, OG Coins, if Trial True (0 false, 1 true)


        int xCoor = avatarCoor.get(0);
        int yCoor = avatarCoor.get(1);
        int numCoinsPickedUp;

        ArrayList<Integer> avatarPickedUpCoinArray = avatarPickedUpCoin(world, xCoor, yCoor - 1, rand, trial, trialNum);
        numCoinsPickedUp = avatarPickedUpCoinArray.getFirst();
        int trialHappening = avatarPickedUpCoinArray.get(1);
        trialNum = avatarPickedUpCoinArray.getLast();


        if (world[xCoor][yCoor - 1] == Tileset.SAND) {
            world[xCoor][yCoor] = Tileset.SAND;

            avatarCoor.remove(0);
            avatarCoor.remove(0);
            while (!avatarCoor.isEmpty()) {
                avatarCoor.remove(0);
            }
            avatarCoor.add(xCoor);
            yCoor -= 1;
            avatarCoor.add(yCoor);
            world[avatarCoor.getFirst()][avatarCoor.getLast()] = Tileset.AVATAR;
            avatarCoor.add(numCoinsPickedUp);
            avatarCoor.add(trialNum);
            avatarCoor.add(trialHappening);

        }
//        ifGameEnd = coins.triggerEndOfGame(numCoinsPickedUp);
//        if (ifGameEnd) {
//            world[xCoor][yCoor] = Tileset.SAND;
//            world[xCoor][yCoor - 1] = Tileset.AVATAR;
//            endGame.callEndGame(world);
//        }

        return avatarCoor;
    }
    public ArrayList<Integer> moveCharRight(TETile[][] world, ArrayList<Integer> avatarCoor, Random rand, Boolean trial, int trialNum) {
        // RETURNS XY COOR, numCoinsPickedUp, OG Coins, if Trial True (0 false, 1 true)


        int xCoor = avatarCoor.get(0);
        int yCoor = avatarCoor.get(1);
        int numCoinsPickedUp;
        // int trialNum;

        ArrayList<Integer> avatarPickedUpCoinArray = avatarPickedUpCoin(world, xCoor + 1, yCoor, rand, trial, trialNum);
        numCoinsPickedUp = avatarPickedUpCoinArray.getFirst();
        int trialHappening = avatarPickedUpCoinArray.get(1);
        trialNum = avatarPickedUpCoinArray.getLast();


        if (world[xCoor + 1][yCoor] == Tileset.SAND) {
            world[xCoor][yCoor] = Tileset.SAND;

            avatarCoor.remove(0);
            avatarCoor.remove(0);
            while (!avatarCoor.isEmpty()) {
                avatarCoor.remove(0);
            }
            avatarCoor.add(xCoor + 1);
            avatarCoor.add(yCoor);
            world[avatarCoor.getFirst()][avatarCoor.getLast()] = Tileset.AVATAR;
            avatarCoor.add(numCoinsPickedUp);
            avatarCoor.add(trialNum);
            avatarCoor.add(trialHappening);
        }
//        ifGameEnd = coins.triggerEndOfGame(numCoinsPickedUp);
//        if (ifGameEnd) {
//            world[xCoor][yCoor] = Tileset.SAND;
//            world[xCoor + 1][yCoor] = Tileset.AVATAR;
//            endGame.callEndGame(world);
//        }
        return avatarCoor;
    }

    public ArrayList<Integer> avatarPickedUpCoin(TETile[][] world, int x, int y, Random rand, Boolean trial, int OGCoins) {

// Returns numberOfCoinsPickedUpInTrial, 1 if it is a trial, and og coins
        boolean isCoin = coins.isCoin(world, x, y);
        ArrayList<Integer> numCoinsAndBool = new ArrayList<>();
        int False = 0;
        int True = 1;
        coinsPickedUp += coins.removeCoin(world, x, y);
//        if(coinsPickedUp == 7){
//            coinsPickedUp = 0;
//        }
        numCoinsAndBool.add(coinsPickedUp);

        if (isCoin && !trial) { // And Trial is false
            numCoinsAndBool.remove(0);
            numCoinsAndBool.add(0);
            numCoinsAndBool.add(True);
            OGCoins++;
        }
        else if (isCoin && trial) {
            numCoinsAndBool.add(True);
            trials.trialRoom(world);
            trials.objectives(world, OGCoins, rand, coinsPickedUp, x, y);
            if (OGCoins == 3) {
                endGame.callEndGame(world);
            }
        }
        else {
            numCoinsAndBool.add(False);
        }
        numCoinsAndBool.add(OGCoins);
//        else if (currNumCoinsPickedUp == 6){
//            currNumCoinsPickedUp++;
//
//            numCoinsAndBool.add(False);
//            numCoinsAndBool.add(currNumCoinsPickedUp);
//        }
        return numCoinsAndBool;

    }
}
