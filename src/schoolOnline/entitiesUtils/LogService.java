package schoolOnline.entitiesUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LogService {
    //static File fl = new File("");
    public static void logWriteDate(String data) {
        try (OutputStream out = new FileOutputStream("src/schoolOnline/creationDate.log", true);
             Writer file = new OutputStreamWriter(out)) {
            file.append(data + "\n");
        } catch (IOException e) {}
    }
    public static void printLogs () {
        try {
        List<String> strings = Files.readAllLines(Paths.get("src/schoolOnline/creationDate.log"));
        strings.forEach(a -> System.out.println(a));
        }catch(java.io.IOException e){}

    }
}
