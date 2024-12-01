package repositoryImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Models.Etudiant;
import repository.EtudiantRepository;

public class RepositoryServise implements EtudiantRepository{
	private List<Etudiant> etudiants = new ArrayList<>();
	@Override
	public List<Etudiant> GetAllEtudiant() {
			return etudiants;
	}

	@Override
	public Optional<Etudiant> getEudiantById(Long Id) {
				return etudiants.stream().filter(etudiant->etudiant.getId()==Id).findFirst();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void DeleteEtudiant(Long Id) {
		etudiants.remove(Id);
	}

	@Override
	public void AddEtudiant(Etudiant etud) {
		etudiants.add(etud);
	}

	@Override
	public Boolean modifEtudiant(Long Id, Etudiant  newEtud) {
			Optional<Etudiant> optional= getEudiantById(Id);
			if (optional.isPresent()) {
				Etudiant etudiant=optional.get();
				etudiant.setAdresses(newEtud.getAdresses());
				etudiant.setAge(newEtud.getAge());
				etudiant.setLastName(newEtud.getLastName());
				etudiant.setFirstName(null);
				etudiant.setRoles(newEtud.getRoles());
				return true;}
				else
					return false ;



				
			}
	}