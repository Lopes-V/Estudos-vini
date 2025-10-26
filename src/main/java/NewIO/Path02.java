package NewIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Path02 {
    public static void main(String[] args) throws IOException {
        Path pasta = Paths.get("pasta");
        Path pastaDirectory = Files.createDirectory(pasta);
    }
}
