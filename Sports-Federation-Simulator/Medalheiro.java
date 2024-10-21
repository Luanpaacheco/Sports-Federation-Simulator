import java.util.ArrayList;

public class Medalheiro {

    private ArrayList<Medalha> medalhas;

    public Medalheiro() {
        medalhas = new ArrayList<>();
    }

    public boolean cadastraMedalha(Medalha m) {
        if(consultaMedalha(m.getCodigo()) == null){
          medalhas.add(m);
          return true;
        }else
            return false;
    }

    public Medalha consultaMedalha(int codigo) {
        for (Medalha a : medalhas) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Medalha> consultaMedalhas(int tipo) {
        ArrayList<Medalha>aux=new ArrayList<>(medalhas.size());
        for(Medalha a : medalhas){
            if(a.getTipo()==tipo && !(a.getListaAtletas().isEmpty())){
                aux.add(a);
            }
        }
        if(aux.isEmpty()){
            return null;
        }else
            return aux;
    }




    public ArrayList<Medalha> consultaMedalhas(String modalidade) {
        ArrayList<Medalha>aux=new ArrayList<>(medalhas.size());
        for(Medalha a : medalhas){
            if(a.getModalidade().equals(modalidade) && !(a.getListaAtletas()==null) ){ //se der merda com outros é aqui
                aux.add(a);
            }
        }
        if(aux.isEmpty()){
            return null;
        }else
            return aux;
    }

}
