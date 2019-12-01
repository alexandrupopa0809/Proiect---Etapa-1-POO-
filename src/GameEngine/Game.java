package GameEngine;

import Heroes.*;
import GameEngine.GameInput;

public class Game {

    public Game() {

    }

    public void startGame(GameInput gameInput, Hero[] heroes) {
        for (int i = 0; i < gameInput.getmRoundsNumber(); i++) {
            Round round = new Round();
            round.startRound(gameInput, heroes);
        }
        for (int i = 0; i < gameInput.getmHeroesNumber(); i++) {
                System.out.println(heroes[i].toString());
        }
    }

}
