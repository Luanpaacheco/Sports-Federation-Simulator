import java.util.ArrayList;

public class Medalha {

    private ArrayList<Atleta> ListaAtletas;

    private int codigo;

    private int tipo;

    private boolean individual;

    private String modalidade;

    public Medalha(int codigo, int tipo, boolean individual, String modalidade) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.individual = individual;
        this.modalidade = modalidade;
        ListaAtletas=new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public ArrayList<Atleta> getListaAtletas() {

       return ListaAtletas;
    }

    public boolean getIndividual() {
        return individual;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void adicionaAtleta(Atleta atleta) {
        ListaAtletas.add(atleta);
    }

}
