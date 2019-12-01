package fileio.interfaces;

import java.io.IOException;

public interface IReader {
    boolean nextBool() throws IOException;

    int nextInt() throws IOException;

    long nextLong() throws IOException;

    float nextFloat() throws IOException;

    double nextDouble() throws IOException;

    String nextWord() throws IOException;

    void close() throws IOException;
}
