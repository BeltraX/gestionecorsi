package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dao.CorsoCorsistaDAO;
import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.model.Corsista;
import com.milano.bc.model.Corso;
import com.milano.bc.model.CorsoCorsista;

class CorsoDAOTest {
	private static Corso corso1;
	private static Corso corso2;
	private static Connection conn;
	private static Corsista corsista1;
	private static Corsista corsista2;
	private static CorsoCorsista cc1;
	private static CorsoCorsista cc2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso1 = new Corso();
		corso1.setCodice(1);
		corso1.setNome("JAVA");
		corso1.setDataInizio(new GregorianCalendar(2021,10,1).getTime());
		corso1.setDataFine(new GregorianCalendar(2021,10,10).getTime());
		corso1.setCosto(1000);
		corso1.setCommento("bello");
		corso1.setAula("B123");
		corso1.setCodDocente(1);
		
		corso2 = new Corso();
		corso2.setCodice(2);
		corso2.setNome("MINECRAFT");
		corso2.setDataInizio(new GregorianCalendar(2019,11,1).getTime());
		corso2.setDataFine(new GregorianCalendar(2022,11,12).getTime());
		corso2.setCosto(1000);
		corso2.setCommento("bello");
		corso2.setAula("B123");
		corso2.setCodDocente(1);
		
		corsista1 = new Corsista();
		corsista1.setCodCorsista(1);
		corsista1.setNomeCorsista("Marco");
		corsista1.setCognomeCorsista("Verde");
		corsista1.setPrecedentiformativi(1);
		
		corsista2 = new Corsista();
		corsista2.setCodCorsista(2);
		corsista2.setNomeCorsista("Marco");
		corsista2.setCognomeCorsista("Verde");
		corsista2.setPrecedentiformativi(1);
		
		cc1 = new CorsoCorsista();
		cc1.setCodCorso(2);
		cc1.setCodCorsista(1);
		
		cc2 = new CorsoCorsista();
		cc2.setCodCorso(2);
		cc2.setCodCorsista(2);
		
		try {
			CorsistaDAO.getFactory().create(conn, corsista1);
			CorsistaDAO.getFactory().create(conn, corsista2);
			CorsoDAO.getFactory().createCorso(conn, corso1);
			CorsoDAO.getFactory().createCorso(conn, corso2);
			CorsoCorsistaDAO.getFactory().create(conn, cc1);
			CorsoCorsistaDAO.getFactory().create(conn, cc2);
			System.out.println("Corso creato");
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}

	@Test
	void testAvgCorso() {
		try {
			double avg = CorsoDAO.getFactory().getAvgCorso(conn);
			assertNotNull(avg);
			System.out.println(avg);
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@Test
	void testUpdate() {
		try {
			corso1 = new Corso();
			corso1.setCodice(1);
			corso1.setNome("SQL");
			corso1.setDataInizio(new GregorianCalendar(2019,10,1).getTime());
			corso1.setDataFine(new GregorianCalendar(2019,10,20).getTime());
			corso1.setCosto(1000);
			corso1.setCommento("bellino");
			corso1.setAula("B123");
			corso1.setCodDocente(1);
			CorsoDAO.getFactory().updateCorso(conn, corso1);
			System.out.println("Modificato corso");
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getCorsi(conn);
			assertNotNull(corsi);
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@Test
	void testDataUltimoCorso() {
		try {
			Date dataUltimo = CorsoDAO.getFactory().getDataUltimoCorso(conn);
			System.out.println(dataUltimo);
			assertNotNull(dataUltimo);
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@Test
	void testNumCommenti() {
		try {
			int num = CorsoDAO.getFactory().getNumCommenti(conn);
			System.out.println(num);
			assertNotNull(num);
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@Test
	void testGetMigliorCorso() {
		try {
			String nomeCorso = CorsoDAO.getFactory().getMigliorCorso(conn);
			assertNotNull(nomeCorso);
			System.out.println("top corso: "+nomeCorso);
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@Test
	void testGetCorsiDisp() {
		try {
			Corso[] corsiDisp = CorsoDAO.getFactory().getCorsiDisp(conn);
			assertNotNull(corsiDisp);
			for(Corso c: corsiDisp)
				System.out.println("nome corso disp: "+c.getNome());
		}  catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			cc1 = null;
			cc2 = null;
			conn.commit();
			CorsoDAO.getFactory().deleteCorso(conn, 1);
			CorsoDAO.getFactory().deleteCorso(conn, 2);
			CorsistaDAO.getFactory().delete(conn, corsista1);
			CorsistaDAO.getFactory().delete(conn, corsista2);
			DBAccess.closeConnection();
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
}
