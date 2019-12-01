package GameEngine;

import Heroes.Hero;

public final class GameInput {
    //numarul de eroi
    private final int mHeroesNumber;
    //eroii
    private final Hero[] mHeroes;
    //numarul de runde
    private final int mRoundsNumber;

    public GameInput() {
        mRoundsNumber = 0;
        mHeroesNumber = 0;
        mHeroes = null;
    }

    public GameInput(final int heroesNumber, final Hero[] heroes,
                     final int roundsNumber) {
       mHeroesNumber = heroesNumber;
       mHeroes = heroes;
       mRoundsNumber = roundsNumber;
    }

    public int getmRoundsNumber() {
        return mRoundsNumber;
    }

    public int getmHeroesNumber() {
        return mHeroesNumber;
    }

    public Hero[] getmHeroes() {
        return mHeroes;
    }
}
