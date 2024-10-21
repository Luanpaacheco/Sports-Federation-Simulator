import java.util.ArrayList;

public class Plantel {

    private ArrayList<Atleta>atletas;

    public Plantel(){
        atletas=new ArrayList<>();
    }

    public boolean cadastraAtleta(Atleta atleta) {
        if((consultaAtleta(atleta.getNumero())==null)){
            atletas.add(atleta);
            return true;
        } else
            return false;
        }

    public Atleta consultaAtleta(String nome) {
        for(Atleta a : atletas){
            if((a.getNome().equalsIgnoreCase(nome)))
                return a;
        }
        return null;
    }

    public Atleta consultaAtleta(int numero) {
       // Atleta a = null;
        for(Atleta a : atletas){
            if(a.getNumero()==numero)
                return a;
        }
        return null;
    }

    public Atleta consultaAtletaP(String pais) {
        // Atleta a = null;
        for(Atleta a : atletas){
            if(a.getPais().equals(pais))
                return a;
        }
        return null;
    }

    public ArrayList<Atleta> consultaAtletas(String p) {
        ArrayList<Atleta>aux=new ArrayList<>(atletas.size());
        for(Atleta a : atletas){
            if((a.getPais().equals(p))){ //se der merda com outros é aqui
                aux.add(a);
            }
        }
        if(aux.isEmpty()){
            return null;
        }else
            return aux;
    }

    public ArrayList<Atleta> consultaAtletas() {
        ArrayList<Atleta>aux=new ArrayList<>(atletas.size());
        for(Atleta a : atletas){
            if(!(a.getListaMedalhas().isEmpty()) ){ //se der merda com outros é aqui
                aux.add(a);
            }

        }
        if(aux.isEmpty()){
            return null;
        }else
            return aux;
    }


}
