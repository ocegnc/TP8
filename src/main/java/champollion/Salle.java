package champollion;

import java.util.HashSet;
import java.util.Set;

public class Salle {

    private String intitule;
    private int capacite;
    private Set<Intervention> occupations = new HashSet<>();

    public Salle(String intitule, int capacite) {
        this.intitule = intitule;
        this.capacite = capacite;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void addOccupation(Intervention intervention) {
        occupations.add(intervention);
    }
}
