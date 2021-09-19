package io.neilshirsat.ui.simulation;

import java.util.ArrayList;

public class SimulationState {

    private int BingoBoardCount;

    private int DayCount;

    private int Seed;

    private int Winners;

    private int BingoTurn;

    private ArrayList<Integer> RolledBalls;

    private ArrayList<Integer> GameWinnerCards;

    private int[][][] BingoBoardNumbers;

    private boolean[][][] BingoSquareSelected;

    private GenerateBingoTiles BingoGenerator;

    private boolean[] IsBoardWinners;

    public int getBingoBoardCount() {
        return BingoBoardCount;
    }

    public void setBingoBoardCount(int bingoBoardCount) {
        BingoBoardCount = bingoBoardCount;
    }

    public int getDayCount() {
        return DayCount;
    }

    public void setDayCount(int dayCount) {
        DayCount = dayCount;
    }

    public int getSeed() {
        return Seed;
    }

    public void setSeed(int seed) {
        Seed = seed;
    }

    public int getWinners() {
        return Winners;
    }

    public void setWinners(int winners) {
        Winners = winners;
    }

    public ArrayList<Integer> getRolledBalls() {
        return RolledBalls;
    }

    public void setRolledBalls(ArrayList<Integer> rolledBalls) {
        RolledBalls = rolledBalls;
    }

    public int getBingoTurn() {
        return BingoTurn;
    }

    public void setBingoTurn(int bingoTurn) {
        BingoTurn = bingoTurn;
    }

    public ArrayList<Integer> getGameWinnerCards() {
        return GameWinnerCards;
    }

    public void setGameWinnerCards(ArrayList<Integer> gameWinnerCards) {
        GameWinnerCards = gameWinnerCards;
    }

    public int[][][] getBingoBoardNumbers() {
        return BingoBoardNumbers;
    }

    public void setBingoBoardNumbers(int[][][] bingoBoardNumbers) {
        BingoBoardNumbers = bingoBoardNumbers;
    }

    public boolean[][][] getBingoSquareSelected() {
        return BingoSquareSelected;
    }

    public void setBingoSquareSelected(boolean[][][] bingoSquareSelected) {
        BingoSquareSelected = bingoSquareSelected;
    }

    public GenerateBingoTiles getBingoGenerator() {
        return BingoGenerator;
    }

    public void setBingoGenerator(GenerateBingoTiles bingoGenerator) {
        BingoGenerator = bingoGenerator;
    }

    public boolean[] getIsBoardWinners() {
        return IsBoardWinners;
    }

    public void setIsBoardWinners(boolean[] isBoardWinners) {
        IsBoardWinners = isBoardWinners;
    }

}
