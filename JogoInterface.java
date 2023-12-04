import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JogoInterface implements ActionListener {

    private JFrame janela;
    private JLabel textoCombustivel;
    private JLabel textoEnergia;
    private JLabel textoQuantidadeDePlantas;
    private JLabel textoAcao;
    private static JTextArea textoEventos;
    private JScrollPane scroll;
    private static JTextField entradaJogador;
    private JButton executarAcao;
    private int valorCombustivel;
    private int valorEnergia;
    private int valorPlantas;
    private static String relatorio;
    private Jogador jogador;
    private Nave nave;

    public JogoInterface(Jogador jogador, Nave nave) {

        this.jogador = jogador;
        this.nave = nave;
        valorCombustivel = nave.getCombustivel();
        valorEnergia = jogador.getEnergia();
        valorPlantas = jogador.getPlantasDeArvore();
        relatorio = "";

        janela = new JFrame("Fundacao Terra");
        textoCombustivel = new JLabel("Combustivel: " + valorCombustivel);
        textoEnergia = new JLabel("Energia: " + valorEnergia);
        textoQuantidadeDePlantas = new JLabel("Plantas de Arvore: " + valorPlantas);
        textoAcao = new JLabel("Escolher acao: ", new ImageIcon("src/ImageIcon.jpeg"), SwingConstants.LEFT);

        textoEventos = new JTextArea (45,100);
        textoEventos.setEditable(false);
        scroll = new JScrollPane(textoEventos);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        entradaJogador = new JTextField("");
        executarAcao = new JButton("Go");
        executarAcao.addActionListener(this);
        montarJanela();

    }

    private void montarJanela() {

        janela.setSize(1200,800);
        janela.setLayout(new BorderLayout());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BoxLayout(painelSuperior, BoxLayout.X_AXIS));
        painelSuperior.add(textoCombustivel);
        painelSuperior.add(textoEnergia);
        painelSuperior.add(textoQuantidadeDePlantas);
        janela.add(painelSuperior, BorderLayout.NORTH);

        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.X_AXIS));
        painelInferior.add(textoAcao);
        painelInferior.add(entradaJogador);
        painelInferior.add(executarAcao);
        janela.add(painelInferior, BorderLayout.SOUTH);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.X_AXIS));
        painelCentral.add(scroll);
        janela.add(painelCentral, BorderLayout.CENTER);

        janela.pack();

    }

    public void exibir() {

        setValorCombustivel();
        setValorEnergia();
        setValorPlanta();
        janela.setVisible(true);

    }

    public void setValorCombustivel() {

        valorCombustivel = nave.getCombustivel();
        textoCombustivel.setText("Combustivel: " + valorCombustivel);

    }

    public void setValorEnergia() {

        valorEnergia = jogador.getEnergia();
        textoEnergia.setText("Energia: " + valorEnergia);

    }

    public void setValorPlanta() {

        valorPlantas = jogador.getPlantasDeArvore();
        textoQuantidadeDePlantas.setText("Plantas de Arvore: " + valorPlantas);

    }

    public static void getRelatorio(String texto) {

        relatorio = "\n" + texto;
        textoEventos.append(relatorio);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        processarAcao();

    }

    public static String processarAcao() {

       String texto = entradaJogador.getText();
       return texto;

    }

}

