package main;

import GameEngine.Game;
import GameEngine.GameInput;
import GameEngine.GameInputLoader;
import Heroes.Hero;
import fileio.implementations.FileWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        Game game = new Game();
        game.startGame(gameInput, gameInput.getmHeroes());

        String outfile = args[1];
        FileWriter fileWriter = new FileWriter(outfile);
        game.writeOutput(gameInput, gameInput.getmHeroes(), fileWriter);
        fileWriter.close();
    }
}
