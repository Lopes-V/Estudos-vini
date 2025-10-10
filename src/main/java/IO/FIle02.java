import java.io.File;
import java.io.IOException;

public class FIle02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio = new File("pasta");
        boolean isDiretorioCriado = fileDiretorio.mkdir();
        System.out.println("Diretorio criado? " + isDiretorioCriado);
        File fileArquivoDiretorio = new File(fileDiretorio,"arquivo.txt");
        boolean isFileArquivoCriado = fileArquivoDiretorio.createNewFile();
        System.out.println("Arquivo .txt criado? " + isFileArquivoCriado);
        File fileRenomeado = new File(fileDiretorio, "arquivo_renomeado.txt");
        boolean fileRenamed = fileArquivoDiretorio.renameTo(fileRenomeado);
        System.out.println("Arquivo .txt criado? " + fileRenamed);

        File diretorioRenamed = new File("pasta2");
        boolean isDIretorioRenomeado = fileDiretorio.renameTo(diretorioRenamed);
        System.out.println("Diretorio pasta renomeado? " + isDIretorioRenomeado);

    }
}
