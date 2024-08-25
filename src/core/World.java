package core;
import tileengine.TERenderer;
import tileengine.TETile;
import edu.princeton.cs.algs4.StdDraw;
import tileengine.TETile;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Random;

public class World implements Serializable {
    long seed;
    Random rand;
    //new Random(seed);

    public World(long seed) {
        this.seed = seed;
        rand = new Random(seed);
    }

    public ArrayList<Integer> generateWorld (TETile[][] world, long seed, int width, int height) {
        //rand.setSeed(seed);
        //Random rand = new Random(seed);
        Random rand = this.rand;
        Hallways hallways = new Hallways();
        Mountains addMountains = new Mountains();
        Sand addSand = new Sand();
        Character avatar = new Character();
        Coins coins = new Coins();
        ArrayList<Integer> avatarCoor = new ArrayList<>();
        SavedGame saveGame =  new SavedGame();

        ArrayList<ArrayList<Integer>> centerCoorOfSand = new ArrayList<>();

        addMountains.generateMountains(world, seed, width, height, rand);
        centerCoorOfSand = addSand.generateSand(world, rand);
        hallways.generateHallways(world, rand, centerCoorOfSand);
        coins.generateCoins(world, rand, false, 0);
        avatarCoor = avatar.generateAvatar(world, rand);
        saveGame.saveOGAvCoor(avatarCoor);
        return avatarCoor;
        //return world;
    }

    public void callPlayGame (TETile[][] world, ArrayList<Integer> avatarCoor){
        PlayingGame playingGame = new PlayingGame();
        //EndGame endGame = new EndGame();
        //boolean ifGameEnd = true;
        playingGame.playingGame(world, avatarCoor, rand, false, 0);
    }

}


