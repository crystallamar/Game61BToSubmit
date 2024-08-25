package core;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import tileengine.TETile;
import tileengine.TERenderer;
import tileengine.Tileset;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import static java.awt.event.MouseEvent.MOUSE_MOVED;
import java.awt.AWTEvent;
import java.util.Random;

public class PlayingGame {
    EndGame endGame = new EndGame();
    Character avatar = new Character();
    Boolean playingGame = true;
    TERenderer ter = new TERenderer();

    Hover mousePointer = new Hover();
    //int numLoops = 0;
    int numCoins;
    SavedGame save = new SavedGame();



//    public void playingGame(TETile[][] world, ArrayList<Integer> avatarCoor) {
//       // PointerInfo pointerInfo = new PointerInfo();
//        while (playingGame) {
//            boolean expectingInput = true;
//            boolean ifColon;
//            char key;
//            while (expectingInput) {
//                if (StdDraw.hasNextKeyTyped()) {
//                    ifColon = true;
//                    key = StdDraw.nextKeyTyped();
//                    avatarCoor = avatar.moveChar(key, world, avatarCoor);
//                    if (key == ':') {
//                        while(ifColon) {
//                            if(StdDraw.hasNextKeyTyped()) {
//                                key = StdDraw.nextKeyTyped();
//                                avatar.ifExit(key);
//                                ifColon = false;
//                            }
//                        }
//                    }
//                    ter.renderFrame(world);
//
//                    int modifiers = 0;
//                   // pointerInfo.mouseMoved(Component.(AWTEvent.MOUSE_MOTION_EVENT_MASK);
//                //(MOUSE_MOVED));
//
//                }
//            }
//        }
//    }

    public void playingGame(TETile[][] world, ArrayList<Integer> avatarCoor, Random rand, Boolean trial, int numTrial) {
        // PointerInfo pointerInfo = new PointerInfo();

        ArrayList<Integer> mouseCoor;
        while (playingGame) {
            boolean expectingInput = true;
            boolean ifColon;
            char key;
            int initMouseXCoor = 0;
            int initMouseYCoor = 0;
            int currMouseXCoor = 0;
            int currMouseYCoor = 0;
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
                    int numLoops = avatarCoor.get(2);
                    int trialBool = avatarCoor.getLast();
                    numTrial = avatarCoor.get(3);
                    if (trialBool == 0) {
                        trial = false;
                    } else {
                        trial = true;
                        //numCoins = avatarCoor.get(2);
                        if (numLoops == 0) {

                            // SAVE GAME HERE
                            //save.saveFile("Character", avatar);
                            //save.saveFile("World", world);
                            SavedGame saveGame = new SavedGame();
                            saveGame.saveAvatarCoor(avatarCoor);

                            numLoops = objectives.objectives(world, numTrial, rand, numLoops, x, y);
                            int newAvatarCoorOGCoins = avatarCoor.get(2) + 1;
                            //int newAvatarCoorOGCoins = numLoops;
                            avatarCoor.remove(2);
                            avatarCoor.add(2, newAvatarCoorOGCoins);
                            playingGame(world, avatarCoor, rand, false, numTrial);
                        } else if (numLoops == 7) {
                            numLoops = 0;
                            numTrial++;
                            // RETRIEVE GAME BEFORE TRIAL
                        } else {
                            numLoops = objectives.objectives(world, numTrial, rand, numLoops, x, y);
                        }


                        //else {
                            //save.saveFile("PlayingGame", playingGame);

                            //numLoops = objectives.objectives(world, numCoins, rand, numLoops, x, y);

                            //numLoops = objectives.trial1Colors(world, avatarCoor.getFirst(), avatarCoor.get(1), numLoops);


                            // int updatedNumLoops = objectives.trial1Colors(world, avatarCoor.getFirst(), avatarCoor.get(1), numLoops);
                            //numLoops = updatedNumLoops;

                    }

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
                    // pointerInfo.mouseMoved(Component.(AWTEvent.MOUSE_MOTION_EVENT_MASK);
                    //(MOUSE_MOVED));

                }
            }
        }
    }
}