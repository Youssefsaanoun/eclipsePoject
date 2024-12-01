package myproject.java;

import java.util.List;

import Models.Etudiant;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import repositoryImplementation.RepositoryServise;
import servisesImplementation.EtudiantServisesImplementation;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {
    private final EtudiantServisesImplementation etudiantServisesImplementation;

    // Default constructor (not recommended for DI use)
    // Constructor for dependency injection
    public MyResource(EtudiantServisesImplementation etudiantServisesImplementation) {
        this.etudiantServisesImplementation = etudiantServisesImplementation;
    }
    public MyResource() {
        this.etudiantServisesImplementation = new EtudiantServisesImplementation(new RepositoryServise()); // Default constructor
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etudiant> getEtudiants() {
        return etudiantServisesImplementation.GetAllEtudiant();
    }
}
