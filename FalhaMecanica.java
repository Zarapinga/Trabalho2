public class FalhaMecanica implements Desafio {

    @Override
    public void imprimirDescricaoEvento() {

        JogoInterface.getRelatorio("Durante a viagem, sua nave sofreu uma falha mecanica e quebrou...");

    }

    @Override
    public void enfrentarDesafio(Nave nave) {

        nave.quebrar();

    }

}