package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Begginer;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Begginer();

        Minesweeper minesweeper = new Minesweeper(gameLevel);
        minesweeper.run();
    }

}
