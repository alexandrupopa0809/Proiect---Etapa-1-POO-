package GameEngine;

import Heroes.Hero;
import fileio.implementations.FileWriter;

import java.io.IOException;

public final class Game {

    public Game() {

    }

    public void startGame(final GameInput gameInput, final Hero[] heroes) {
        //pentru fiecare runda sunt facute operatiile respective
        for (int i = 0; i < gameInput.getmRoundsNumber(); i++) {
            Round round = new Round();
            round.startRound(gameInput, heroes);
        }
    }

    //sunt afisati in fisierul out jucatorii
    public void writeOutput(final GameInput gameInput, final Hero[] heroes,
                            final FileWriter fileWriter) throws IOException {
        for (int i = 0; i < gameInput.getmHeroesNumber(); i++) {
            fileWriter.writeWord(heroes[i].toString());
            fileWriter.writeNewLine();
        }
    }

}
