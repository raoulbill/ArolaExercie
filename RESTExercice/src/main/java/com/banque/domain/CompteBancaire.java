package com.banque.domain;


import java.io.Serializable;

//
//@Entity
//@Table(name="T_CompteBanquaire")
public class CompteBancaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6668839664897996333L;

//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id ; 
	
//	@Column(name ="CB_Solde")
	public double solde ; 

	/**
	 * cree un compte avec un solde a 0€ 
	 * @param id 
	 */
	public CompteBancaire(Long id){
		this.id =id ; 
		this.solde = 0 ; 
	}
	
	public void crediter (double montant){
		this.solde = solde+ montant ; 
	}
	
	public void debiter (double montant){
		this.solde = solde- montant ; 
	}

	public Long getId() {
		return id;
	}

	public double getSolde() {
		return solde;
	}

}
