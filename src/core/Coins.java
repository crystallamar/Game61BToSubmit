package core;

import tileengine.TETile;
import tileengine.Tileset;

import java.util.Random;

public class Coins {
    public void generateCoins(TETile[][] world, Random random, Boolean trial, int numTrials) {
        //int numCoinsTotal = 10;
        int tempX;
        int tempY;
        int numCoinsTotal;
        if (!trial) {
            numCoinsTotal = 3;
        }
        else {
            numCoinsTotal = 6;
        }


        while(numCoinsTotal != 0) {
            tempX = random.nextInt(1, 94);
            tempY = random.nextInt(1, 53);
            if (ifSandPlaceCoin(world, tempX, tempY, trial, numCoinsTotal, numTrials)) {
                numCoinsTotal--;
            }
        }
    }

    public boolean ifSandPlaceCoin(TETile[][] world, int x, int y, Boolean trial, Integer numCoinsTotal, int trialNum) {
        boolean placedCoin = false;

        if (!trial) {
            if (world[x][y] == Tileset.SAND) {
                world[x][y] = Tileset.CELL;
                placedCoin = true;
            }
        }
        else if (trialNum ==1 ){
                if (numCoinsTotal == 1) {
                    if (world[x][y] == Tileset.SAND) {
                        world[x][y] = Tileset.CELLRED;
                        placedCoin = true;
                    }
                }
                if (numCoinsTotal == 2) {
                    if (world[x][y] == Tileset.SAND) {
                        world[x][y] = Tileset.CELLOrange;
                        placedCoin = true;
                    }
                }
                if (numCoinsTotal == 3) {
                    if (world[x][y] == Tileset.SAND) {
                        world[x][y] = Tileset.CELLYellow;
                        placedCoin = true;
                    }
                }
                if (numCoinsTotal == 4) {
                    if (world[x][y] == Tileset.SAND) {
                        world[x][y] = Tileset.CELLGreen;
                        placedCoin = true;
                    }
                }
                if (numCoinsTotal == 5) {
                    if (world[x][y] == Tileset.SAND) {
                        world[x][y] = Tileset.CELLBlue;
                        placedCoin = true;
                    }
                }
                if (numCoinsTotal == 6) {
                    if (world[x][y] == Tileset.SAND) {
                        world[x][y] = Tileset.CELLViolet;
                        placedCoin = true;
                    }
                }

        }
        else if (trialNum == 2) {
            if (numCoinsTotal == 1) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.num1;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 2) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.num2;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 3) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.num3;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 4) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.num4;
                    placedCoin = true;
                }
            } if (numCoinsTotal == 5) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.num5;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 6) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.num6;
                    placedCoin = true;
                }
            }


        }
        else if (trialNum == 3) {
            if (numCoinsTotal == 1) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.letterA;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 2) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.letterB;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 3) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.letterC;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 4) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.letterD;
                    placedCoin = true;
                }
            } if (numCoinsTotal == 5) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.letterE;
                    placedCoin = true;
                }
            }
            if (numCoinsTotal == 6) {
                if (world[x][y] == Tileset.SAND) {
                    world[x][y] = Tileset.letterF;
                    placedCoin = true;
                }
            }
        }


        return placedCoin;
    }

    public int removeCoin(TETile[][] world, int x, int y) {
        if (world[x][y] == Tileset.CELL) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.CELLRED) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.CELLYellow) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.CELLOrange) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.CELLGreen) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.CELLBlue) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.CELLViolet) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.num1) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.num2) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.num3) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.num4) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.num5) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.num6) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.letterA) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.letterB) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.letterC) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.letterD) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.letterE) {
            world[x][y] = Tileset.SAND;
            return 1;
        }
        if (world[x][y] == Tileset.letterF) {
            world[x][y] = Tileset.SAND;
            return 1;
        }

        return 0;


    }

    public boolean isCoin(TETile[][] world, int x, int y) {
        if (world[x][y] == Tileset.CELL) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.CELLRED) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.CELLOrange) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.CELLYellow) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.CELLGreen) {
            //world[x][y] = Tileset.SAND;
            return true;
        }

        else if (world[x][y] == Tileset.CELLBlue) {
            //world[x][y] = Tileset.SAND;
            return true;
        }

        else if (world[x][y] == Tileset.CELLViolet) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.num1) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.num2) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.num3) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.num4) {
            //world[x][y] = Tileset.SAND;
            return true;
        }

        else if (world[x][y] == Tileset.num5) {
            //world[x][y] = Tileset.SAND;
            return true;
        }

        else if (world[x][y] == Tileset.num6) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.letterA) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.letterB) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.letterC) {
            //world[x][y] = Tileset.SAND;
            return true;
        }
        else if (world[x][y] == Tileset.letterD) {
            //world[x][y] = Tileset.SAND;
            return true;
        }

        else if (world[x][y] == Tileset.letterE) {
            //world[x][y] = Tileset.SAND;
            return true;
        }

        else if (world[x][y] == Tileset.letterF) {
            //world[x][y] = Tileset.SAND;
            return true;
        }

        return false;
    }

    public boolean triggerEndOfGame(int numCoinsPickedUp) {
        //EndGame endGame = new EndGame();
        boolean ifGameEnd = false;
        if (numCoinsPickedUp == 3) { //CHANGE BACK TO 10
            //endGame.endGame();
            ifGameEnd = true;

        }
        return ifGameEnd;
    }

}
