package com.banque.restService;

import com.banque.domain.CompteBancaire;
import com.banque.domainServices.VerifierSolvabilite;
import com.banque.repository.CompteBancaireRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Raoul
 *
 */
@Path("/banque")
public class ServicesBancairesService {


	private CompteBancaireRepository compteBancaireRepository = new CompteBancaireRepository();


	private VerifierSolvabilite verifierSolvabilite = new VerifierSolvabilite();

	/**
	 * permet de visualier le compte 
	 * @param id le numero de compte 
	 * @return l'etat du compte 
	 */
	@GET
	@Path("/{id}")
	public Response recupererCompte(@PathParam("id") Long id){
		CompteBancaire compte = compteBancaireRepository.getOne(id) ;
		String output = "Le compte numero  : "+ compte.getId() +" a pour solde : "+compte.getSolde();  

		return Response.status(200).entity(output).build();
	}
	/**
	 * permet d'effectuer les operations d'ajout d'argent au compte 
	 * @param id le numero de compte 
	 * @param montant d'argent a ajouter 
	 * @return
	 */
	@PUT
	@Path("/crediter/{id}/{montant}")
	public Response crediter(@PathParam("id") Long id ,@PathParam("montant") double montant){
		CompteBancaire compteACrediter =compteBancaireRepository.getOne(id);
		compteACrediter.crediter(montant);
		compteBancaireRepository.save(compteACrediter); 
		String output = "Le compte numero  : "+ compteACrediter.getId() +" a pour solde : "+compteACrediter.getSolde();  

		return Response.status(200).entity(output).build();
	}
	/**
	 * permet d'effectuer les operations de debits
	 * @param id le numero de compte 
	 * @param montant d'argent a enlever 
	 * @return
	 */
	@PUT
	@Path("/debiter/{id}/{montant}")
	public Response debiter(@PathParam("id") Long id ,@PathParam("montant")   double montant){
		String output ="" ;
		CompteBancaire compteADebiter =compteBancaireRepository.getOne(id);
		if(verifierSolvabilite.verifierSolvabilite(compteADebiter , montant)){
			compteADebiter.debiter(montant);
		}else{
			output ="le compte n'a pu etre debite " ;
		}
		compteBancaireRepository.save(compteADebiter); 
		output = "Le compte numero  : "+ compteADebiter.getId() +" a pour solde : "+compteADebiter.getSolde();  

		return Response.status(200).entity(output).build();
	}
}
