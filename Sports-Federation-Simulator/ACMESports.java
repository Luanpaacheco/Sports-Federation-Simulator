
// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import java.util.Scanner;

public class ACMESports {
    // Atributos para redirecionamento de E/S
    private static Scanner entrada = new Scanner(System.in);  // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "dadosin.txt";  // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "dadosout.txt";  // Nome do arquivo de saida de dados
    private static Medalheiro medalheiro;


    private static Plantel plantel;


    //private static Scanner sc;

    public ACMESports() {
        //sc = new Scanner(System.in);
        plantel = new Plantel();
        medalheiro = new Medalheiro();
        redirecionaES();    // Redireciona E/S para arquivos


    }


    public void executar() {
        CadastraAtleta();                                       //1
        CadastraMedalhas();                                     //2
        CadastraMedalhasEAtletasCorrespondentes();              //3
        MostraDadosDeUmAtletaPorNumero();                       //4
        MostraDadosDeUmAtletaPorNome();                         //5
        MostraDadosDeUmaMedalhaPorCodigo();                     //6
        MostraDadosDosAtletaPorPais();                          //7
        MostraDadosDeUmAtletaPorMedalhaTipo();                  //8
        MostraDadosDeUmAtletaPorModalidade();                   //9
        MostraAtletaComMaisMedalhas();                          //10
    }

    //1
    public static void CadastraAtleta() {
        int numero = 0;
        String nome;
        String pais;
        //System.out.println("digite o numero");
        numero = entrada.nextInt();
        entrada.nextLine();
        while (numero != -1) {
            //System.out.println("digite o nome:");
            nome = entrada.nextLine();
            //System.out.println("digite o pais:");
            pais = entrada.nextLine();
            Atleta a1 = new Atleta(numero, nome, pais);
            if (plantel.cadastraAtleta(a1)) {
                System.out.println("1:" + numero + "," + nome + "," + pais);
            }
            //System.out.println("digite o numero");
            numero = entrada.nextInt();
            entrada.nextLine();
        }

    }

    //2
    public static void CadastraMedalhas() {
        int codigo = 0;
        int tipo;
        boolean individual;
        String modalidade;
        //System.out.println("digite o codigo");
        codigo = entrada.nextInt();
        entrada.nextLine();
        while (codigo != -1) {
            //System.out.println("digite o tipo:");
            tipo = entrada.nextInt();
            entrada.nextLine();
            //System.out.println("digite se é indivudual:");
            individual = entrada.nextBoolean();
            entrada.nextLine();
            //System.out.println("digite a modalidade:");
            modalidade = entrada.nextLine();
            Medalha m1 = new Medalha(codigo, tipo, individual, modalidade);
            if (medalheiro.cadastraMedalha(m1)) {
                System.out.println("2:" + codigo + "," + tipo + "," + individual + "," + modalidade);
            }
            //System.out.println("digite o codigo");
            codigo = entrada.nextInt();

        }

    }

    //3
    public static void CadastraMedalhasEAtletasCorrespondentes() {
        int codigo = 0;
        int numero;
        //System.out.println("digite o codigo da medalha");
        codigo = entrada.nextInt();
        while (codigo != -1) {
            //System.out.println("digite o numero do atleta:");
            numero = entrada.nextInt();

            if (!(plantel.consultaAtleta(numero) == null)) {
                if (!(medalheiro.consultaMedalha(codigo) == null)) {
                    medalheiro.consultaMedalha(codigo).adicionaAtleta(plantel.consultaAtleta(numero));
                    plantel.consultaAtleta(numero).adicionaMedalha(medalheiro.consultaMedalha(codigo));
                    System.out.println("3:" + codigo + "," + numero);
                }
            }
            //System.out.println("digite o codigo da medalha");
            codigo = entrada.nextInt();
            entrada.nextLine();


        }
    }

    public static void MostraDadosDeUmAtletaPorNumero() {
        //System.out.println("digite o numero do atleta:");
        int numero = entrada.nextInt();
        entrada.nextLine();
        if (!(plantel.consultaAtleta(numero) == null)) {
            System.out.println("4:" + numero + "," + plantel.consultaAtleta(numero).getNome() + "," + plantel.consultaAtleta(numero).getPais());
        } else System.out.println("4:Nenhum atleta encontrado.");
    }

    public static void MostraDadosDeUmAtletaPorNome() {
        //System.out.println("digite o nome do atleta:");
        String nome = entrada.nextLine();
        if (!(plantel.consultaAtleta(nome) == null)) {
            System.out.println("5:" + plantel.consultaAtleta(nome).getNumero() + "," +nome + "," + plantel.consultaAtleta(nome).getPais());
        } else System.out.println("5:Nenhum atleta encontrado.");
    }

    public static void MostraDadosDeUmaMedalhaPorCodigo() {
        //System.out.println("digite o codigo da medalha:");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        if (!(medalheiro.consultaMedalha(codigo) == null)) {
            System.out.println("6:" + codigo + "," +medalheiro.consultaMedalha(codigo).getTipo() + "," + medalheiro.consultaMedalha(codigo).getIndividual() + "," + medalheiro.consultaMedalha(codigo).getModalidade());
        } else System.out.println("6:Nenhuma medalha encontrada.");
    }

    public static void MostraDadosDosAtletaPorPais() {
        //System.out.println("digite o nome do pais do atleta:");
        String pais = entrada.nextLine();
        if (!(plantel.consultaAtletas(pais) == null)) {
            for (int i = 0; i < plantel.consultaAtletas(pais).size(); i++) {
                        System.out.println("7:" + (plantel.consultaAtletas(pais).get(i)).getNumero() +  "," + (plantel.consultaAtletas(pais).get(i).getNome()+","+pais));
                    }
                } else
                    System.out.println("7:Pais nao encontrado.");
            }


    public static void MostraDadosDeUmAtletaPorMedalhaTipo() {
        //System.out.println("digite o tipo da medalha:");
        int tipo = entrada.nextInt();
        entrada.nextLine();
        int k = 0;
        if (!(medalheiro.consultaMedalhas(tipo) == null)) {
            for (int i = 0; i < medalheiro.consultaMedalhas(tipo).size(); i++) {
                if (!((medalheiro.consultaMedalhas(tipo).get(i)).getListaAtletas().isEmpty())) {
                    for (int j = 0; j < (medalheiro.consultaMedalhas(tipo).get(i)).getListaAtletas().size(); j++) {
                        System.out.println("8:" + (medalheiro.consultaMedalhas(tipo).get(i)).getListaAtletas().get(j).getNumero() + "," + (medalheiro.consultaMedalhas(tipo).get(i)).getListaAtletas().get(j).getNome() + "," + (medalheiro.consultaMedalhas(tipo).get(i)).getListaAtletas().get(j).getPais());
                        k = 1;
                    }
                } else if (k == 0)
                    System.out.println("8:Nenhum atleta encontrado.");
            }
        } else System.out.println("8:Nenhum atleta encontrado.");
    }

    public static void MostraDadosDeUmAtletaPorModalidade() {
        //System.out.println("digite a modalidade:");
        String modalidade = entrada.nextLine();

        if (!(medalheiro.consultaMedalhas(modalidade) == null)) {
            for (int i = 0; i < medalheiro.consultaMedalhas(modalidade).size(); i++) {
                if (!((medalheiro.consultaMedalhas(modalidade).get(i)).getListaAtletas().isEmpty())) {
                    for (int j = 0; j < (medalheiro.consultaMedalhas(modalidade).get(i)).getListaAtletas().size(); j++) {
                        System.out.println("9:" + modalidade + "," + (medalheiro.consultaMedalhas(modalidade).get(i)).getTipo() + "," + (medalheiro.consultaMedalhas(modalidade).get(i)).getListaAtletas().get(j).getNumero() + "," + (medalheiro.consultaMedalhas(modalidade).get(i)).getListaAtletas().get(j).getNome() + "," + (medalheiro.consultaMedalhas(modalidade).get(i)).getListaAtletas().get(j).getPais());

                    }
                } else
                    System.out.println("9:" + modalidade + "," + medalheiro.consultaMedalhas(modalidade).get(i).getTipo() + "," + "sem atletas com medalha");
            }
        } else System.out.println("9:Modalidade nao encontrada.");
    }

    public static void MostraAtletaComMaisMedalhas() {
        Atleta maior;
        maior = null;

        if (!(plantel.consultaAtletas() == null)) {
            for (Atleta a : plantel.consultaAtletas()) {
                if (maior == null || (maior.consultaQuantidadeMedalhas() < a.consultaQuantidadeMedalhas())) {
                    maior = a;
                }
            }
            int ouro = 0;
            int prata = 0;
            int bronze = 0;
            for (int i = 0; i < maior.consultaQuantidadeMedalhas(); i++) {
                switch (maior.getListaMedalhas().get(i).getTipo()) {
                    case 1:
                        ouro++;
                        break;
                    case 2:
                        prata++;
                        break;
                    case 3:
                        bronze++;
                        break;
                }
            }

            System.out.println("10:" + maior.getNumero() + "," + maior.getNome() + "," + maior.getPais() + ",Ouro:" + ouro + ",Prata:" + prata + ",Bronze:" + bronze);

        } else System.out.println("Nenhum atleta com medalha");
    }

    // Redireciona E/S para arquivos
    // Chame este metodo para redirecionar a leitura e escrita de dados para arquivos
    private void redirecionaES() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    // Restaura E/S padrao de tela(console)/teclado
    // Chame este metodo para retornar a leitura e escrita de dados para o padrao
    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }


}
