package io.neilshirsat.ui.simulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class GenerateBingoTiles {

    private int seed;

    private Random RandomNumberGenerator;

    public final int[] LOWER_BOUND = new int[]{
            1,
            16,
            31,
            46,
            61
    };

    public final int[] UPPER_BOUND = new int[]{
            15,
            30,
            45,
            60,
            75
    };

    public ArrayList<Integer> GeneratedNumbers;

    public GenerateBingoTiles(int seed) {
        this.seed = seed;
        RandomNumberGenerator = new Random(seed);
        GeneratedNumbers = new ArrayList<>(75);
        for (int i = 1; i <= 75; i++) {
            GeneratedNumbers.add(i);
        }

    }

    public int[][] GenerateBingoTileSquare() {
        int[][] BingoBoard = new int[5][5];

        for (int i = 0; i < 5; i++) {
            BingoBoard[i] = RandomNumberGenerator.ints(LOWER_BOUND[i], UPPER_BOUND[i]).distinct().limit(5).toArray();
        }

        return BingoBoard;
    }

    public int GenerateBingoNumber() {
        int gn = RandomNumberGenerator.nextInt(GeneratedNumbers.size());
        return GeneratedNumbers.remove(gn);
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public Random getRandomNumberGenerator() {
        return RandomNumberGenerator;
    }

    public void setRandomNumberGenerator(Random randomNumberGenerator) {
        RandomNumberGenerator = randomNumberGenerator;
    }

}
