import java.util.ArrayList;

public class Atleta {
    private ArrayList<Medalha>ListaMedalhas;

    private int numero;

    private String nome;

    private String pais;

    public Atleta(int numero, String nome, String pais) {
        this.numero = numero;
        this.nome = nome;
        this.pais = pais;
        ListaMedalhas=new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public ArrayList<Medalha> getListaMedalhas() {
        return ListaMedalhas;
    }

    public void adicionaMedalha(Medalha medalha) {

        ListaMedalhas.add(medalha);
    }

    public int consultaQuantidadeMedalhas() {
        return ListaMedalhas.size();
    }

}
