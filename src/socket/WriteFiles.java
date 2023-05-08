package socket;

import java.io.*;

public class WriteFiles {
    public static void write1(final String path, final String cont) {
        try(OutputStream out = new FileOutputStream("src/socket/black.txt", true);
            Writer file = new OutputStreamWriter(out)) {
            file.append(cont);
        } catch (IOException e) {}
    }
}
