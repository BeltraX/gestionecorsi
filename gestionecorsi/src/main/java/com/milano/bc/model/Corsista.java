package com.milano.bc.model;

public class Corsista {
	private int codCorsista;
	private String nomeCorsista;
	private String cognomeCorsista;
	private boolean precedentiformativi;

	public int getCodCorsista() {
		return codCorsista;
	}

	public void setCodCorsista(int codCorsista) {
		this.codCorsista = codCorsista;
	}

	public String getNomeCorsista() {
		return nomeCorsista;
	}

	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}

	public String getCognomeCorsista() {
		return cognomeCorsista;
	}

	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}

	public boolean isPrecedentiformativi() {
		return precedentiformativi;
	}

	public void setPrecedentiformativi(boolean precedentiformativi) {
		this.precedentiformativi = precedentiformativi;
	}

}
