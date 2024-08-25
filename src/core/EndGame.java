package core;

import org.apache.pdfbox.contentstream.operator.state.Save;
import tileengine.TERenderer;
import edu.princeton.cs.algs4.StdDraw;
import tileengine.TETile;
import tileengine.Tileset;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EndGame {
    TERenderer ter = new TERenderer();
    public void quitGame() {
        boolean endGame = true;
        char key;
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(47, 27, 8, 5);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(47, 27, "Save Game: S\n Quit Game: Q");
        StdDraw.show();
        while (endGame) {
            if (StdDraw.hasNextKeyTyped()) {
                key = StdDraw.nextKeyTyped();
                if ((key == 's') || (key == 'S')) {
                    //Save game
                    endGame = false;
                }

                if ((key == 'q') || (key == 'Q')) {
                    System.exit(0);
                }

            }
        }

    }

    public void pressedSave() {
        //save game
    }

    public void pressedQuit() {
        System.exit(0);
    }
public void endGame() {
    boolean waiting = true;
    char key;
    while (waiting) {
        StdDraw.setPenColor(Color.black);
        StdDraw.filledRectangle(45, 25, 60, 60);
        StdDraw.setPenColor(Color.green);
        StdDraw.text(45, 26, "Congratulations! You win!");
        StdDraw.text(45, 23, "Press Q to Quit");
        StdDraw.show();
        while (StdDraw.hasNextKeyTyped()) {
            key = StdDraw.nextKeyTyped();
            if ((key != 'q') || (key != 'Q')) {
                System.exit(0);
            }


        }


    }
}

public void callEndGame(TETile[][] world) {
    endGame();
    //ter.renderFrame(world);
    //return true;


}

public boolean endObjective(TETile[][] world) {
        SavedGame retrieveGame = new SavedGame();
        PlayingGame game;
        Character avatar = new Character();
        //retrieveGame.readFile("PlayingGame");
        long seed = retrieveGame.readSeed("seed");
        World genWorld = new World(seed);
        Grass genGrass = new Grass();
        genGrass.generateGrass(world, 94, 55);
        genWorld.generateWorld(world, seed, 94, 55);
        ArrayList<Integer> avatarCoor = retrieveGame.readAvatarCoor("avatarCoor");
        avatar.setAvatarCoor(world, avatarCoor);
        ArrayList<Integer> OGavatarCoor = retrieveGame.readAvatarCoor("OGAvCoor");



        world[OGavatarCoor.getFirst()][OGavatarCoor.getLast()] = Tileset.SAND;


        return false;


}
//    try {
//        ObjectInputStream objectInputStream = null;
//        FileInputStream streamIn = new FileInputStream("Character");
//        objectInputStream = new ObjectInputStream(streamIn);
//
//} catch (FileNotFoundException e) {
//        throw new RuntimeException(e);
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//    World newWorld = new World(seed);
//        newWorld.generateWorld(world, seed, 94, 55);
//        ter.renderFrame(world);
//        return false;
//}
}
