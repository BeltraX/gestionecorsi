package com.milano.architecture.dao;

public interface DAOConstants {
	String SELECT_CORSISTI = "select * from corsista";
	String SELECT_DOCENTI = "select * from docente";
	String SELECT_CORSI = "select * from corso";
	String SELECT_ADMIN = "select * from amministratore";
	String SELECT_CORSI_BYID = "select * from corso where codcorso = ?";

	String SELECT_CORSISTASEQ = "select corsista_seq.nextval from dual";
	String SELECT_CORSOSEQ = "select corso_seq.nextval from dual";

	String INSERT_CORSO = "insert into corso values(?,?,?,?,?,?,?,?)";
	String INSERT_CORSISTA = "insert into corsista values(?,?,?,?)";
	String COUNT_PARTECIP_BYID = "select count(*) from corso_corsista where codcorso = ?";
	String SELECT_DURATA_GG_CORSO = "select (datafinecorso - datainiziocorso) from corso where codcorso = ?";

	String SELECT_DATA_ULTIMOCORSO = "select max(datainiziocorso) from corso";
	String SELECT_TOT_CORSISTI = "select count(*) from corsista";
	String COUNT_COMMENTI = "select count(commenticorso) from corso";
	String COUNT_DOCENTI = "selct count(coddocente) from corso where coddocente= ?";

	String DELETE_CORSO = "Delete from corso where codcorso = ?";
	String DELETE_CORSISTA = "Delete from corsista where codcorsista = ?";
	
	String UPDATE_CORSO = "Update corso set nomecorso = ?, datainiziocorso = ?, datafinecorso = ?, costocorso = ?, commenticorso = ?, aulacorso = ?, coddocente = ? where codcorso = ?";
}
