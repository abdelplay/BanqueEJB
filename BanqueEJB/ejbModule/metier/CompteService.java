package metier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CompteService
 */
@Stateless(name="COMPTEEJB")
public class CompteService implements CompteServiceRemote, CompteServiceLocal {

	@PersistenceContext(unitName="MysqlDS")
	EntityManager em;
   
    public CompteService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Long addCompte(Compte c) {
           em.persist(c);
		return c.getCode();
	}

	@Override
	public List<Compte> getAllComptes() {
		Query q = em.createQuery("select c from Compte c");
		return q.getResultList();
	}

	@Override
	public void verser(Long id, double mnt) {
		Compte c = em.find(Compte.class, id);	
		c.setSolde(c.getSolde() + mnt);
		em.persist(c);
	}

	@Override
	public void retirer(Long id, double mnt) {
		Compte c = em.find(Compte.class, id);	
		c.setSolde(c.getSolde() - mnt);
		
	}

	@Override
	public Compte consulter(Long id) {
		Compte c = em.find(Compte.class, id);
		if (c==null) throw new RuntimeException("Compte introuvable !!!");
		return c;
	}

	@Override
	public void remove(Long id) {
		Compte c = em.find(Compte.class, id);
		em.remove(c);		
	}

}
