public class ImpactoMeteoro implements Desafio {

    @Override
    public void imprimirDescricaoEvento() {

        JogoInterface.getRelatorio("Durante sua viagem, a rota de sua nave esta no caminho de um meteoro, e o impacto eh iminente...");

    }

    @Override
    public void enfrentarDesafio(Nave nave) {

        if (nave.getTiro() > 0) {

            nave.decrementarTiro(1);
            JogoInterface.getRelatorio("A custo de um tiro, voce destruiu o meteoro e seguiu normalmente sua rota");

        }

        else  {

            JogoInterface.getRelatorio("O impacto eh inevitavel, e voce ve sua vida passando diante do seus olhos...Foi um belo sonho restaurar a Terra...");
            JogoInterface.getRelatorio("GAME OVER!!!");
            Jogo.gameOver();

        }

    }


    
}