package champollion;

import java.util.Date;

public class Intervention {

    private Date debut;
    private int duree;
    private int heureDeb;
    private UE matiere;
    private TypeIntervention type;
    private Salle salle;
    private Enseignant enseignant;

    public Intervention(Date debut, int duree, int heureDeb, Enseignant enseignant, UE matiere, TypeIntervention type, Salle salle) {
        this.debut = debut;
        this.duree = duree;
        this.heureDeb = heureDeb;
        this.enseignant = enseignant;
        this.matiere = matiere;
        this.type = type;
        this.salle = salle;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }


    public int getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(int heureDeb) {
        this.heureDeb = heureDeb;
    }

    public UE getMatiere() {
        return matiere;
    }

    public void setMatiere(UE matiere) {
        this.matiere = matiere;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
}
