package champollion;

import java.util.ArrayList;
import java.util.HashMap;

public class UE {
    private final String myIntitule;
    private int heureCM;
    private int heureTP;
    private int heureTD;
    private HashMap<Enseignant, ServicePrevu> lesIntervenants;
    private ArrayList<Intervention> lesSeances;

    public UE(String myIntitule, int heureCM, int heureTP, int heureTD) {
            this.myIntitule = myIntitule;
            this.heureCM = heureCM;
            this.heureTP = heureTP;
            this.heureTD = heureTD;
            this.lesIntervenants = new HashMap<Enseignant, ServicePrevu>();
            this.lesSeances = new ArrayList<Intervention>();
    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeureCM() {
        return heureCM;
    }

    public int getHeureTP() {
        return heureTP;
    }

    public int getHeureTD() {
        return heureTD;
    }

    public void addSeance(Intervention i){
        this.lesSeances.add(i);
    }
}
