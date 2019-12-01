package Heroes;

import fileio.FileSystem;

import java.io.IOException;

public class Map {
    public char[][] map;
    private static Map instance = null;
    private Map() {

    }
    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public void load(FileSystem fs) throws IOException {
        int row = fs.nextInt();
        int col = fs.nextInt();
        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            String mapi = fs.nextWord();
            for (int j = 0; j < col; j++) {
                map[i][j] = mapi.charAt(j);
            }
        }
    }


}
