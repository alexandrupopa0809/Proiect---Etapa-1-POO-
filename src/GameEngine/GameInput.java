package GameEngine;

import Heroes.Hero;
//import com.Heroes.Hero;


public class GameInput {
    //private final int mRow;
    //private final int mCol;private final char[][] mMap;
    private final int mHeroesNumber;
    private final Hero[] mHeroes;
    private final int mRoundsNumber;

    public GameInput() {
        mRoundsNumber = 0;
        mHeroesNumber = 0;
        //mMap = null;
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