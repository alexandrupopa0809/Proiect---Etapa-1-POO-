package GameEngine;

import Heroes.*;
import fileio.implementations.FileWriter;

import java.io.IOException;

public class Game {

    public Game() {

    }

    public void startGame(GameInput gameInput, Hero[] heroes) {
        for (int i = 0; i < gameInput.getmRoundsNumber(); i++) {
            Round round = new Round();
            round.startRound(gameInput, heroes);
        }
    }

    public void writeOutput(GameInput gameInput, Hero[] heroes, FileWriter fileWriter) throws IOException {
        for(int i = 0; i < gameInput.getmHeroesNumber(); i++) {
            fileWriter.writeWord(heroes[i].toString());
            fileWriter.writeNewLine();
        }
    }

}
