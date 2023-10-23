package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
	}	
        
         @Test
        public void testHeuresPrevues(){
            untel.ajouteEnseignement(uml, 0, 1, 0);
            untel.ajouteEnseignement(java, 0, 1, 0);
            assertEquals(2, untel.heuresPrevues(),"L'enseignant doit réaliser 4h" );
        } 
        

        @Test 
        public void testEnSousService(){
            untel.ajouteEnseignement(uml, 2, 2, 5);
            assertEquals(true, untel.enSousService(), "L'enseignant est en sous service");

            untel.ajouteEnseignement(uml, 100, 30, 80);
            assertEquals(true, untel.enSousService(), "L'enseignant n'est pas en sous service");

        }
          @Test
        public void testHeuresPlanifiees(){
            Salle salle = new Salle ("Salle informatique", 30);
            Intervention e = new Intervention (salle, uml, untel, new Date(), 2, TypeIntervention.TD);
            untel.ajouteIntervention(e);
            assertEquals(2, untel.resteAPlanifier(), "L'enseignant doit réaliser 2h");
        }
}
	

