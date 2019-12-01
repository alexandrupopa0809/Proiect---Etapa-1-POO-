package main;

import GameEngine.Game;
import GameEngine.GameInput;
import GameEngine.GameInputLoader;
import fileio.implementations.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        Game game = new Game();
        game.startGame(gameInput, gameInput.getmHeroes());

        //se ia ca parametru fisierul de iesire din linia de comanda
        String outfile = args[1];
        FileWriter fileWriter = new FileWriter(outfile);
        //apelez metoda de scriere a jucatorilor
        game.writeOutput(gameInput, gameInput.getmHeroes(), fileWriter);
        fileWriter.close();
    }
}
