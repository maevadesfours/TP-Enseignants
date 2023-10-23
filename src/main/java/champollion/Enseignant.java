package champollion;
import java.util.ArrayList;
import java.util.LinkedList;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }
    ArrayList<ServicePrevu> serviceprevu = new ArrayList<>();
    LinkedList<Intervention> intervention = new LinkedList<>();

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
        int equiTD = 0;
        for (ServicePrevu servicep : serviceprevu){
            equiTD += 1.5 * servicep.getVolumeCM();
            equiTD += servicep.getVolumeTD();
            equiTD += 0.75 * servicep.getVolumeTP();
        }  
        return Math.round(equiTD);
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
    int equiTD_UE = 0;

        for (ServicePrevu servicep : serviceprevu){
            if (servicep.getUe() == ue){
            equiTD_UE = (int) (equiTD_UE + 1.5 * servicep.getVolumeCM());
            equiTD_UE = equiTD_UE + servicep.getVolumeTD();
            equiTD_UE = (int) (equiTD_UE + 0.75 * servicep.getVolumeTP());
        }
    }
        return Math.round(equiTD_UE);
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
      ServicePrevu servicep = new ServicePrevu (volumeCM, volumeTD, volumeTP, ue, this);
      serviceprevu.add(servicep);
  
    }
    public void ajouteIntervention(Intervention e){
        intervention.add(e);

    }
    public int resteAPlanifier(){
        int heuresP =0 ;

        for (int i = 0; i < intervention.size(); i++){

            switch (intervention.get(i).getType()){

                case CM:
                    heuresP = (int) (heuresP + intervention.get(i).getDuree() * 1.5);
                    break;
                case TD: 
                    heuresP = heuresP + intervention.get(i).getDuree();
                    break;
                case TP:
                    heuresP = (int) (heuresP + intervention.get(i).getDuree() * 0.75);
                    break;
                default:
                    break;
            }

        }
        return Math.round(heuresP);
    }
     public boolean enSousService(){
        if(resteAPlanifier()>= 192){
            return false;
        }else{
            return true;
        }

    }
  }
