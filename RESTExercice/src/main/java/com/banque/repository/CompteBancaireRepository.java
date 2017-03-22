package com.banque.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.banque.domain.CompteBancaire;
/**
 * classe pour palier a l'absence de bdd et de JPA 
 * @author Raoul
 *
 */
public class CompteBancaireRepository {
		
	private ArrayList<CompteBancaire> listecompte ;

	
	public CompteBancaireRepository() {
		super();
		this.listecompte = new ArrayList<CompteBancaire>();
		this.listecompte.add(new CompteBancaire( new Long(15689332)));
		CompteBancaire compteAllimente = new CompteBancaire(new Long(789456));
		compteAllimente.crediter(12345);
		listecompte.add(compteAllimente);
		compteAllimente = new CompteBancaire(new Long(6));
		compteAllimente.crediter(1289);
		listecompte.add(compteAllimente);
	}

	public CompteBancaire getOne(Long id ){
		CompteBancaire compteTrouve =null ; 
		for (CompteBancaire compte : listecompte ){
			if(compte.getId().equals(id)){
				compteTrouve =compte ; 
			}
		}
		return compteTrouve ;
	}
	
	public CompteBancaire save(CompteBancaire compteAEnregistrer ){
      
		CompteBancaire compte = new CompteBancaire( compteAEnregistrer.getId()); 
		compte.crediter(compteAEnregistrer.getSolde());
		return compte; 
	}
}
