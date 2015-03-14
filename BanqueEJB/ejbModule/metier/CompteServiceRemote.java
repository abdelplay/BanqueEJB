package metier;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CompteServiceRemote {

	public Long addCompte(Compte c);
	public List<Compte> getAllComptes();
	public void verser(Long id, double mnt);
	public void retirer(Long id, double mnt);
	public Compte consulter(Long id);
	public void remove(Long id);
	
}
