package main;

import GameEngine.Game;
import GameEngine.GameInput;
import GameEngine.GameInputLoader;

public class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        Game game = new Game();
        game.startGame(gameInput, gameInput.getmHeroes());

    }
}
