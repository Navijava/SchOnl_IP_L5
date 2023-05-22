package schoolOnline.entitiesUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class LogService {
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
    public static ArrayList<String> readLogs(){
        try {
            return (ArrayList<String>) Files.readAllLines(Paths.get("src/schoolOnline/creationDate.log"));
        }catch(java.io.IOException e){}
        return null;
    }
    public static ArrayList<String> readLogs(String path){
        try {
            return (ArrayList<String>) Files.readAllLines(Paths.get(path));
        }catch(java.io.IOException e){}
        return null;
    }
    public static void logWriteDataNio(String data){
        try {
            Files.write(Paths.get("src/schoolOnline/lesson24_logs.log"),
                    (data + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {}
    }
    public static void customLogWriteDataNio(String data){
        try {
            Files.write(Paths.get("src/schoolOnline/logLevel.data"),
                    (data + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {}
    }
}
