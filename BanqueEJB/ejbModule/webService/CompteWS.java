package webService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.Compte;
import metier.CompteServiceLocal;


@WebService
@Stateless
public class CompteWS {
	
	@EJB
	CompteServiceLocal compteService;
	
	@WebMethod
	public List<Compte> consulterComptes(){
		return compteService.getAllComptes();
	}
	
	@WebMethod(operationName="ajouterCompte")
	public Long addCompte(Compte c){
		return compteService.addCompte(c);
	}
}



