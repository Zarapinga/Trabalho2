import java.io.*;
import java.util.Date;

public class Arquivo {
    
    Date data;
    String conteudo;

    public Arquivo(String conteudo) {

        this.conteudo = conteudo;
        data = new Date();

    }

    public void escrever() {

        if (verificarPastaLogs()) {

            JogoInterface.getRelatorio("Pasta logs criada");

        }

        try (FileWriter writer = new FileWriter("logs/" + data.toString() + ".log")) {

            writer.write(conteudo);

        } 
        
        catch (IOException e) {

            JogoInterface.getRelatorio("Erro ao escrever arquivo" + e.getMessage());

        } 
        
        catch (Exception e) {

            JogoInterface.getRelatorio("Erro desconhecido");

        }

    }

    public boolean verificarPastaLogs() {

        File pasta = new File("logs");

        if (!pasta.exists()) {

            pasta.mkdir();
            return true;

        }

        return false;

    }

}
