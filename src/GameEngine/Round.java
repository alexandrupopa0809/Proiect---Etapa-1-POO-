package GameEngine;

import Heroes.Hero;
import Heroes.Rogue;

public final class Round {

    public void startRound(final GameInput gameInput, final Hero[] heroes) {
        //eroii se misca
        for (int i = 0; i < gameInput.getmHeroesNumber(); i++) {
            heroes[i].move();
        }
        //iterez de doua ori prin eroi
        for (int i = 0; i < gameInput.getmHeroesNumber(); i++) {
            for (int j = i + 1; j < gameInput.getmHeroesNumber(); j++) {
                //daca sunt amandoi in viata si se afla in acelasi loc
                if (heroes[i].isAlive && heroes[j].isAlive) {
                    if ((heroes[i].rowPos == heroes[j].rowPos)
                            && (heroes[i].colPos == heroes[j].colPos)) {
                        //se lupta
                        if (heroes[j] instanceof Rogue) {
                            //heroes[j] ataca primul
                            heroes[i].fightBack(heroes[j]);
                            heroes[j].fightBack(heroes[i]);
                        } else {
                            //altfel heroes[i] ataca primul
                            heroes[j].fightBack(heroes[i]);
                            heroes[i].fightBack(heroes[j]);
                        }
                        //se verifica cine ramane in viata si se dau xp points
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
