package com.banque.domainServices;

import com.banque.domain.CompteBancaire;

public class VerifierSolvabilite {

	/**
	 * 
	 * @param compte le compte a annalyser 
	 * @param montant le montant de retrait souhaite 
	 * @return true si il est possible d'effectuer un retrait false sinon 
	 */
	public boolean verifierSolvabilite(CompteBancaire compte , double montant){
		return compte.getSolde()>montant ; 
	}
}
