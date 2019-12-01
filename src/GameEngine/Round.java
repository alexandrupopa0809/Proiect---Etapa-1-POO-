package GameEngine;

import Heroes.Hero;
import Heroes.Rogue;

import java.util.Random;
//import GameEngine.GameInput;

public class Round {

    public void startRound(GameInput gameInput, Hero[] heroes) {
        for (int i = 0; i < gameInput.getmHeroesNumber(); i++) {
            heroes[i].move();
        }
        for (int i = 0; i < gameInput.getmHeroesNumber(); i++) {
            for (int j = i + 1; j < gameInput.getmHeroesNumber(); j++) {
                if (heroes[i].isAlive && heroes[j].isAlive) {
                    if ((heroes[i].rowPos == heroes[j].rowPos) &&
                            (heroes[i].colPos == heroes[j].colPos)) {
                        if (heroes[j] instanceof Rogue) {
                            heroes[i].fightBack(heroes[j]);
                            heroes[j].fightBack(heroes[i]);
                        }
                        else {
                            heroes[j].fightBack(heroes[i]);
                            heroes[i].fightBack(heroes[j]);
                        }
                        if (heroes[i].isAlive && !heroes[j].isAlive) {
                            heroes[i].getXpPoints(heroes[j].level);
                        }
                        if (!heroes[i].isAlive && heroes[j].isAlive) {
                            heroes[j].getXpPoints(heroes[i].level);
                        }
                    }
                }
            }
        }

    }
}
