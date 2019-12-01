package GameEngine;

import Heroes.*;

public class HeroesFactory {

    private HeroesFactory() {

    }

    public static Hero createHero(char heroName, int rowPos, int colPos) {
        switch(heroName) {
            case 'W' : return new Wizard(rowPos, colPos);
            case 'P' : return new Pyromancer(rowPos, colPos);
            case 'R' : return new Rogue(rowPos, colPos);
            case 'K' : return new Knight(rowPos, colPos);
        }
        return null;
    }
}
