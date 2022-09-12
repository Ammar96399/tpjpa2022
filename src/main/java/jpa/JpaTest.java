package jpa;

import jpa.dao.ChildDAO;
import jpa.dao.PatientDAO;
import jpa.dao.ProfessionalDAO;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		var manager = EntityManagerHelper.getEntityManager();
		var tx = manager.getTransaction();
		var patientDAO = new ProfessionalDAO();
		var childDAO = new ChildDAO();
		tx.begin();
		try {
			patientDAO.createProfessional("Cambria", "Alpha");
			patientDAO.createProfessional("Maria", "Beta");
			patientDAO.createProfessional("Jean", "Citron");
			childDAO.createChild("firstChild", "good", "parent", 12);

			patientDAO.getAll().forEach(System.out::println);

			System.out.println(patientDAO.getPatientByName("Maria", "Beta"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		System.out.println("done ...");
	}

}
