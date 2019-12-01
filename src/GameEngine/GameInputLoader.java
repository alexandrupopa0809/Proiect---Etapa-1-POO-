package GameEngine;

import Heroes.Hero;
import Heroes.Map;
import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    public GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        Hero[] heroes = new Hero[0];
        int noRounds = 0;
        int noHeroes = 0;
        int row = 0;
        int col = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            Map.getInstance().load(fs);

            noHeroes = fs.nextInt();
            heroes = new Hero[noHeroes];

            for (int i = 0; i < noHeroes; i++) {
                heroes[i] = HeroesFactory.createHero(fs.nextWord().charAt(0),
                        fs.nextInt(), fs.nextInt());
            }

            noRounds = fs.nextInt();

            for (int i = 0; i < noRounds; i++) {
                String heroMoves = fs.nextWord();
                for (int j = 0; j < noHeroes; j++) {
                    heroes[j].moves += heroMoves.charAt(j);
                }

            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return new GameInput(noHeroes, heroes, noRounds);
    }
}
