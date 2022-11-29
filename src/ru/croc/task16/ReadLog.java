package ru.croc.task16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadLog {
    private List<Log> logs = new ArrayList<>();

    public List<Log> getLogs(String path) throws IOException {
        List<File> files = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .filter(file -> file.
                        getFileName().toString().endsWith(".trace") ||
                        file.getFileName().toString().endsWith(".log"))
                .map(Path::toFile).toList();

        for (File file : files) {
            readData(file);
        }
        return logs;
    }


    private void readData(File file) throws IOException {

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                logs.add(new Log(Long.parseLong(line.split(" ")[0]), line));
            }
        }
    }
}
