package GameEngine;

import Heroes.Hero;
import Heroes.Wizard;
import Heroes.Pyromancer;
import Heroes.Rogue;
import Heroes.Knight;

public final class HeroesFactory {

    private HeroesFactory() {

    }

    public static Hero createHero(final char heroName, final int rowPos,
                                  final int colPos) {
        switch (heroName) {
            case 'W' : return new Wizard(rowPos, colPos);
            case 'P' : return new Pyromancer(rowPos, colPos);
            case 'R' : return new Rogue(rowPos, colPos);
            case 'K' : return new Knight(rowPos, colPos);
        }
        return null;
    }
}
