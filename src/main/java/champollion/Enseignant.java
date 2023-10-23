package champollion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    private final Map<UE, ServicePrevu> enseignements = new HashMap<>();
    private ArrayList<Intervention> lesInterventions;

    public Enseignant(String nom, String email) {

        super(nom, email);
        this.lesInterventions = new ArrayList<Intervention>();
        }

    public float equivalentTD(TypeIntervention type, int volumeHoraire){
        float result = 0f;
        switch (type){
            case CM:
                result = volumeHoraire*1.5f;
                break;
            case TD:
                result = volumeHoraire;
                break;
            case TP:
                result = volumeHoraire*0.75f;
                break;
        }
        return result;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        int result = 0;
        for (UE ue : enseignements.keySet()) {
             result += heuresPrevuesPourUE(ue);
        }
        return Math.round(result);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        float result = 0;
        ServicePrevu p = enseignements.get(ue);
        if (p != null) {
            result = equivalentTD(TypeIntervention.CM, p.getVolumeCM()) + equivalentTD(TypeIntervention.TD, p.getVolumeTD()) + equivalentTD(TypeIntervention.TP, p.getVolumeTP())
            ;
        }
        return Math.round(result);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        if (volumeCM < 0 || volumeTD < 0 || volumeTP < 0) {
            throw new IllegalArgumentException("Les volumes horaires doivent être positifs ou nuls");
        }
        ServicePrevu s = enseignements.get(ue);
        if (s == null) { // Pas encore de service prévu pour cette UE
            s = new ServicePrevu(volumeCM, volumeTD, volumeTP, ue);
            enseignements.put(ue, s);
        } else { // Mette à jour le service prévu pour cette UE
            s.setVolumeCM(volumeCM + s.getVolumeCM());
            s.setVolumeTD(volumeTD + s.getVolumeTD());
            s.setVolumeTP(volumeTP + s.getVolumeTP());
            }
        }

    public void ajouteIntervention(Intervention i) {
        this.lesInterventions.add(i);
        UE ue = i.getMatiere();
        System.out.println(i.getMatiere());
        ue.addSeance(i);
    }

    public boolean enSousService() {
        return this.heuresPrevues() < 192;
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        ServicePrevu s = enseignements.get(ue);
        int nbHeurePlanif = 0;
        float planifier = s.getVolumePour(type);
        for(Intervention intervention : lesInterventions) {
            if ((ue.equals(intervention.getMatiere())) &&(type.equals(intervention.getType()))) {
                nbHeurePlanif += intervention.getDuree();
            }
        }
        return Math.round(planifier - nbHeurePlanif);
    }

}
