/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champollion;

import java.util.Date; 
/**
 *
 * @author maevadesfours
 */
public class Intervention {
    private Salle salle;
    private UE ue;
    private Enseignant enseignant;
    private Date debut; 
    private int duree; 
    private boolean annulee=false;
    private TypeIntervention type; 

    public Intervention(Salle salle, UE ue, Enseignant enseignant, Date debut, int duree, TypeIntervention type) {
        this.salle = salle;
        this.ue = ue;
        this.enseignant = enseignant;
        this.debut = debut;
        this.duree = duree;
        this.type = type;
    }
    
    public void annuler(){
        this.annulee = true;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getType() {
        return type;
    }
    
    
    public boolean isAnnulee(){
    return annulee; 
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }
    
}
