package champollion;

import java.util.ArrayList;

public class UE {
    private final String myIntitule;
    private ArrayList<Intervention> lesSeances;

    public UE(String myIntitule) {
            this.myIntitule = myIntitule;
            this.lesSeances = new ArrayList<Intervention>();
    }

    public String getIntitule() {
        return myIntitule;
    }

    public void addSeance(Intervention intervention){
        this.lesSeances .add(intervention);
    }

}
