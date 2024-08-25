package core;
//package utils;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.pdfbox.contentstream.operator.text.SetFontAndSize;
import tileengine.TERenderer;
import tileengine.TETile;
import tileengine.Tileset;
import utils.FileUtils;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
        private static final int WIDTH = 94;
        private static final int HEIGHT = 55;

    public static void main(String[] args) {
        //Random randWorld = new Random();
        FileUtils files = new FileUtils();
        File savedGame = new File("Saved Game");

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT); // Creates screen
        TETile[][] world = new TETile[WIDTH][HEIGHT]; // creates the world to build in
        //long seed = 12345;
        //long seed = System.currentTimeMillis();
        TitleScreen titleScreen = new TitleScreen();
        Character character = new Character();
        PlayingGame playingGame = new PlayingGame();
        ArrayList<Integer> avatarCoor = new ArrayList<>();
        EndGame endGame = new EndGame();

        titleScreen.generateTitleScreen(world, WIDTH, HEIGHT);
        long seed = titleScreen.onTitlePage(world, WIDTH, HEIGHT);
        SavedGame saveFiles = new SavedGame();
        
        saveFiles.saveSeed(seed);
        World updatedWorld = new World(seed);

        avatarCoor = updatedWorld.generateWorld(world, seed, WIDTH, HEIGHT);
        //world = updatedWorld.generateWorld(world, seed, WIDTH, HEIGHT);
        ter.renderFrame(world);
        //character.takeInput();
        updatedWorld.callPlayGame(world, avatarCoor);
        endGame.callEndGame(world);
        ter.renderFrame(world);
    }

}