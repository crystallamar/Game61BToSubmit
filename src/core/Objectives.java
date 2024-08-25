package core;

import edu.princeton.cs.algs4.StdDraw;
import tileengine.TETile;
import tileengine.Tileset;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import tileengine.TERenderer;



public class Objectives {
    TERenderer ter = new TERenderer();
    boolean trial = false;
    Random rand;


    public int objectives(TETile[][] world, int coinCountOG, Random rand, int numLoops, int x, int y) {
        EndGame endGame = new EndGame();
        if (coinCountOG == 1 && numLoops == 0) {
            objective1(world, rand);
            return 0;
        }
        else if (coinCountOG == 1) { // and it isn't the first loop
            return trialPickUpCoin(world, x, y, numLoops);
        }
        if (coinCountOG == 2 && numLoops == 0) {
            objective2(world, rand);
            return 0;
        }
        else if (coinCountOG == 2) {
            return trialPickUpCoin(world, x, y, numLoops);
        }
        if (coinCountOG == 3 && numLoops == 0) {
            objective3(world, rand);
            return 0;
        }
        else if (coinCountOG == 3) {
            return trialPickUpCoin(world, x, y, numLoops);
        }
//        if (coinCountOG == 4) {
//            endGame.callEndGame(world);
//        }
        return 0;
    }
    public void objective1 (TETile[][] world, Random rand) {
        PlayingGame playGame = new PlayingGame();

        Coins coins = new Coins();
        Character newAvatar = new Character();
        //World updatedWorld = new World(seed);
        trialRoom(world);
        trialRoomIntro();
        trialContinue(world);
        coins.generateCoins(world, rand, true, 1);
        ArrayList<Integer> avatarCoor = newAvatar.generateAvatar(world, rand);
        ter.renderFrame(world);

        whilePlayingTrial(world, avatarCoor, rand, trial, 1);
        //trial1Colors(world, avatarCoor.getFirst(), avatarCoor.get(1));


                }



    public void objective2(TETile[][] world, Random rand) {
        PlayingGame playGame = new PlayingGame();

        Coins coins = new Coins();
        Character newAvatar = new Character();
        //World updatedWorld = new World(seed);
        trialRoom(world);
        trialRoomIntro();
        trialContinue(world);
        coins.generateCoins(world, rand, true, 2);
        ArrayList<Integer> avatarCoor = newAvatar.generateAvatar(world, rand);
        ter.renderFrame(world);

        whilePlayingTrial(world, avatarCoor, rand, trial, 2);
    }

    public void objective3(TETile[][] world, Random rand) {
        PlayingGame playGame = new PlayingGame();
        EndGame endGame = new EndGame();

        Coins coins = new Coins();
        Character newAvatar = new Character();
        //World updatedWorld = new World(seed);
        trialRoom(world);
        trialRoomIntro();
        trialContinue(world);
        coins.generateCoins(world, rand, true, 3);
        ArrayList<Integer> avatarCoor = newAvatar.generateAvatar(world, rand);
        ter.renderFrame(world);

        whilePlayingTrial(world, avatarCoor, rand, trial, 3);
        endGame.callEndGame(world);
    }


    public void trialRoomIntro() {
        StdDraw.setPenColor(Color.black);
        StdDraw.filledRectangle(47, 26, 40, 20);
        StdDraw.setPenColor(Color.green);
        StdDraw.text(47, 26, "Trial: Press C to continue");
        StdDraw.show();
    }

    public void trialRoom(TETile[][] world) {
        for (int i = 0; i < 94; i++) {
            for (int n = 0; n < 55; n++) {
                world[i][n] = Tileset.GRASS;
            }
        }

        for (int i = 20; i < 60; i++) {
            for (int n = 10; n < 40; n++) {
                world[i][n] = Tileset.SAND;
            }
        }
        ter.renderFrame(world);

    }

    public void trialContinue(TETile[][] world) {
        boolean expectingInput = true;
        char key;
        while (expectingInput) {
            if (StdDraw.hasNextKeyTyped()) {
                key = StdDraw.nextKeyTyped();
                if ((key == 'c') || (key == 'C')) {
                    trialRoom(world);
                    expectingInput = false;
                }
            }
        }
    }

    public void trialComplete(TETile[][] world) {
        EndGame endGame = new EndGame();
        ReadFiles readSeed = new ReadFiles();
        long seed = readSeed.readFileSeed();
        endGame.endObjective(world);

        ter.renderFrame(world);
    }

    public int trialPickUpCoin(TETile[][] world, int x, int y, int numTrialCoins) {
        Coins coin = new Coins();
        if (coin.isCoin(world, x, y)) {
            numTrialCoins += coin.removeCoin(world, x, y);
            return numTrialCoins;
        }

        if (numTrialCoins == 6) {
           trialComplete(world);
           numTrialCoins++;
        }
        return numTrialCoins;
    }

    public void whilePlayingTrial(TETile[][] world, ArrayList<Integer> avatarCoor, Random rand, Boolean trial, int numTrial){
        Character avatar = new Character();
        Boolean playingGame = true;
        TERenderer ter = new TERenderer();
        EndGame endGame = new EndGame();

        Hover mousePointer = new Hover();
        int numLoops = 0;
        int numCoinsPickedUpInTrial;


        ArrayList<Integer> mouseCoor;
        while (playingGame) {
            boolean expectingInput = true;
            boolean ifColon;
            char key;
            int initMouseXCoor = 0;
            int initMouseYCoor = 0;
            int currMouseXCoor;
            int currMouseYCoor;
            Objectives objectives = new Objectives();



            while (expectingInput) {
                mouseCoor = mousePointer.mouseMoves();

                currMouseXCoor = mouseCoor.getFirst();
                currMouseYCoor = mouseCoor.getLast();
                String tileTitle = mousePointer.convertCoor(world, mouseCoor);
                if ((initMouseXCoor != currMouseXCoor) || (initMouseYCoor != currMouseYCoor)) {
                    mousePointer.displayNothing();
                    mousePointer.displayTile(tileTitle);
                    initMouseXCoor = currMouseXCoor;
                    initMouseYCoor = currMouseYCoor;
                }

                if (StdDraw.hasNextKeyTyped()) {
                    ifColon = true;
                    key = StdDraw.nextKeyTyped();
                    avatarCoor = avatar.moveChar(key, world, avatarCoor, rand, trial, numTrial);
                    int x = avatarCoor.getFirst();
                    int y = avatarCoor.get(1);
                    numCoinsPickedUpInTrial = avatarCoor.get(2);
                    int OGCoins = avatarCoor.get(3);
                    int trialBool = avatarCoor.get(4);
                    if (numCoinsPickedUpInTrial != 7) {
                        numCoinsPickedUpInTrial = trialPickUpCoin(world, x, y, numCoinsPickedUpInTrial);
                        avatarCoor.remove(4); // remove trialBool
                        avatarCoor.remove(3); // remove OGCoins
                        avatarCoor.remove(2); // remove numCoinsPickedUp in trial
                        avatarCoor.add(numCoinsPickedUpInTrial);
                        avatarCoor.add(OGCoins);
                        avatarCoor.add(trialBool);
                    }
                    else {
                        playingGame = false;
                        expectingInput = false;
                        avatarCoor.remove(4); // remove trialBool
                        avatarCoor.remove(3); // remove OGCoins
                        avatarCoor.remove(2); // remove numCoinsPickedUp in trial
                        avatarCoor.add(0);
                        avatarCoor.add(OGCoins);
                        avatarCoor.add(trialBool);

                    }
//                    if (OGCoins == 4) {
//                        endGame.callEndGame(world);
//                    }

                    if (key == ':') {
                        while (ifColon) {
                            if (StdDraw.hasNextKeyTyped()) {
                                key = StdDraw.nextKeyTyped();
                                avatar.ifExit(key);
                                ifColon = false;
                            }
                        }
                    }
                    ter.renderFrame(world);

                    int modifiers = 0;

                }
            }
        }
    }
    }


