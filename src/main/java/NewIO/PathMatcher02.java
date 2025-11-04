package NewIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class listarDasListas extends SimpleFileVisitor<Path> {

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.getFileName().toString().endsWith(".java") || file.getFileName().toString().endsWith(".class")){
            System.out.println("  Arquivo: " + file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
public class PathMatcher02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src");
        listarDasListas listAllFiles = new listarDasListas();
        Files.walkFileTree(path, listAllFiles);
    }
}

