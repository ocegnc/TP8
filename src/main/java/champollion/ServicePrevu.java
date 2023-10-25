package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    private final UE ue;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, UE ue) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.ue = ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    public UE getUe() {
        return ue;
    }

    public int getVolumePour(TypeIntervention type) {
        int result = 0;
       /* switch (type) {
            case CM:
                result = getVolumeCM(); break;
            case TD:
                result = getVolumeTD(); break;
            case TP:
                result = getVolumeTP(); break;
        }
        return result;
        */
        if (type==TypeIntervention.CM){
            result = getVolumeCM();
        }
        if (type==TypeIntervention.TP){
            result = getVolumeTP();
        }
        if (type==TypeIntervention.TD){
            result = getVolumeTD();
        }
        return result;
    }
}
