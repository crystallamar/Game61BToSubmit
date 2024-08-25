package core;

import edu.princeton.cs.algs4.In;
import org.antlr.v4.runtime.misc.Utils;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;

public class SavedGame {
    //File saveFile = new File();
    FileUtils fileUtils = new FileUtils();


    public static final String savedGameDirectory = (new File(System.getProperty("user.dir")).getPath());
    //String saveFile = files.readFile("savedGame.txt");
    //String savedGame = savedGameDirectory + saveFile;




    public void saveSeed(long seed) {
        String seedString = Long.toString(seed);
        FileUtils.writeFile("seed", seedString);

    }

    public long readSeed(String fileName) {
        String stringSeed = FileUtils.readFile(fileName);
        long seed = Long.parseLong(stringSeed);
        return seed;
    }

    public void saveAvatarCoor(ArrayList<Integer> avatarCoor) {
        int xCoor = avatarCoor.getFirst();
        int yCoor = avatarCoor.get(1);
        String stringCoor = Integer.toString(xCoor);
        stringCoor += " ";
        stringCoor += Integer.toString(yCoor);

        FileUtils.writeFile("avatarCoor", stringCoor);
    }
    public ArrayList<Integer> readAvatarCoor(String fileName) {
        ArrayList<Integer> avatarCoor = new ArrayList<>();
        String stringAvatarCoor = FileUtils.readFile(fileName);
        String[] stringArray = stringAvatarCoor.split(" ");
        int xCoor = Integer.parseInt(stringArray[0]);
        int yCoor = Integer.parseInt(stringArray[1]);
        avatarCoor.add(xCoor);
        avatarCoor.add(yCoor);
        return avatarCoor;
    }

    public void saveOGAvCoor(ArrayList<Integer> avatarCoor) {
        int xCoor = avatarCoor.getFirst();
        int yCoor = avatarCoor.get(1);
        String stringCoor = Integer.toString(xCoor);
        stringCoor += " ";
        stringCoor += Integer.toString(yCoor);

        FileUtils.writeFile("OGAvCoor", stringCoor);
    }
    public ArrayList<Integer> readOGAvCoor(String fileName) {
        ArrayList<Integer> OGavatarCoor = new ArrayList<>();
        String stringAvatarCoor = FileUtils.readFile(fileName);
        String[] stringArray = stringAvatarCoor.split(" ");
        int xCoor = Integer.parseInt(stringArray[0]);
        int yCoor = Integer.parseInt(stringArray[1]);
        OGavatarCoor.add(xCoor);
        OGavatarCoor.add(yCoor);
        return OGavatarCoor;
    }
}


