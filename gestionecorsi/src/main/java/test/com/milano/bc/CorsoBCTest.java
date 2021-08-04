package test.com.milano.bc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.CorsistaBC;
import com.milano.bc.CorsoBC;
import com.milano.bc.CorsoCorsistaBC;
import com.milano.bc.model.Corsista;
import com.milano.bc.model.Corso;
import com.milano.bc.model.CorsoCorsista;

class CorsoBCTest {
	private static Corso corso1;
	private static Corso corso2;
	private static Connection conn;
	private static Corsista corsista1;
	private static Corsista corsista2;
	private static CorsoCorsista cc1;
	private static CorsoCorsista cc2;
	private static CorsoBC corsoBC;
	private static CorsoCorsistaBC ccBC;
	private static CorsistaBC corsistaBC;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso1 = new Corso();
		corso1.setCodice(1);
		corso1.setNome("JAVA");
		corso1.setDataInizio(new GregorianCalendar(2020,10,1).getTime());
		corso1.setDataFine(new GregorianCalendar(2020,10,10).getTime());
		corso1.setCosto(1000);
		corso1.setCommento("bello");
		corso1.setAula("B123");
		corso1.setCodDocente(1);
		
		corso2 = new Corso();
		corso2.setCodice(2);
		corso2.setNome("MINECRAFT");
		corso2.setDataInizio(new GregorianCalendar(2020,11,1).getTime());
		corso2.setDataFine(new GregorianCalendar(2020,11,12).getTime());
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
		
		try {
			corsoBC = new CorsoBC();
			ccBC = new CorsoCorsistaBC();
			corsistaBC = new CorsistaBC();
			corsoBC.create(corso1);
			corsoBC.create(corso2);
			corsistaBC.create(corsista1);
			corsistaBC.create(corsista2);
			
			cc1 = new CorsoCorsista();
			cc1.setCodCorso(corso1.getCodice());
			cc1.setCodCorsista(corsista1.getCodCorsista());
			
			cc2 = new CorsoCorsista();
			cc2.setCodCorso(corso1.getCodice());
			cc2.setCodCorsista(corsista2.getCodCorsista());
			
			ccBC.create(cc1);
			ccBC.create(cc2);
			System.out.println("Corso creato");
		} catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}

	
	@Test
	void testUpdate() {
		try {
			corso1.setCodice(1);
			corso1.setNome("SQL");
			corso1.setDataInizio(new GregorianCalendar(1990,10,1).getTime());
			corso1.setDataFine(new GregorianCalendar(2020,10,10).getTime());
			corso1.setCosto(1000);
			corso1.setCommento("bellino");
			corso1.setAula("B123");
			corso1.setCodDocente(1);
			corsoBC.update(corso1);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetCorsi() {
		try {
			Corso[] corsi = corsoBC.getCorsi();
			assertNotNull(corsi);
		}catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test 
	void testGetMigliorCorso(){
		try {
			String migliore = corsoBC.getMigliorCorso();
			assertNotNull(migliore);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetDataUltimoCorso() {
		try {
			Date dataUltima = corsoBC.getDataUltimoCorso();
			assertNotNull(dataUltima);
		}  catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetAvgCorsi() {
		try {
			double media = corsoBC.getAvgCorso();
			assertNotNull(media);
		}  catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetNumCommenti() {
		try {
			int nCommenti = corsoBC.getNumCommenti();
			assertNotNull(nCommenti);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetCorsiDisp() {
		try {
			Corso[] corsiDisp = corsoBC.getCorsiDisp();
			assertNotNull(corsiDisp);
		}  catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			cc1 = null;
			cc2 = null;
			conn.commit();
			corsoBC.delete(corso1.getCodice());
			corsoBC.delete(corso2.getCodice());
			corsistaBC.delete(corsista1);
			corsistaBC.delete(corsista2);
			DBAccess.closeConnection();
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
