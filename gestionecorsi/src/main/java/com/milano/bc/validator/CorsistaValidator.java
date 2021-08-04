package com.milano.bc.validator;

import java.util.regex.Pattern;

import com.milano.bc.model.Corsista;

public class CorsistaValidator {
	public boolean checkNome(Corsista corsista) {
		return Pattern.matches("^[a-zA-Z ,.'-]{2,30}+$", corsista.getNomeCorsista());
	}

	public boolean checkCognome(Corsista corsista) {
		return Pattern.matches("^[a-zA-Z ,.'-]{2,30}+$", corsista.getCognomeCorsista());
	}

	public boolean checkPrecFormativi(Corsista corsista) {
		int x = corsista.getPrecedentiformativi();
		if (x == 0 || x == 1) {
			return true;
		} else
			return false;
	}
}