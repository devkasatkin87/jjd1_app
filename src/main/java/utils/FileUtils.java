package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    private static long lastModified = -1;
    private static List<String> dataList = new LinkedList<>();
    private File file;
    private Path path;


    public FileUtils(String filename) {
        this.file = new File(filename);
        this.path = Paths.get(filename);
    }

    public List<String> ReadDataFromFile() {

        if (lastModified != file.lastModified()) {
            dataList.clear();

            try(Stream<String> lineStream = Files.newBufferedReader(path).lines()) {

                dataList = lineStream.collect(Collectors.toList());

                lastModified = file.lastModified();
            } catch (IOException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }


        return dataList;
    }
}
