import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.Compte;
import metier.CompteServiceRemote;


public class Main {

	public static void main(String[] args) {

		try {
			
	//	Properties p = new Properties();
	//	p.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
	//	Context ctx = new InitialContext(p);
		
			Context ctx = new InitialContext();
		CompteServiceRemote csr = (CompteServiceRemote) ctx.lookup("ejb:/BanqueEJB/COMPTEEJB!metier.CompteServiceRemote");
	
		csr.addCompte(new Compte(19000 , new Date()));
		
		for (Compte c : csr.getAllComptes()){
			
			System.out.println(" Num compte : "+c.getCode());
			System.out.println(" Date creation : "+c.getDateCreation());
			System.out.println(" Solde : "+c.getSolde());
            System.out.println("===========================");
			
		}
		
		csr.verser(3L, 1200);
		
		csr.retirer(7L, 500);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

}
