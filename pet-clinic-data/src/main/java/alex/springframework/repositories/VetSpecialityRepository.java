package alex.springframework.repositories;

import alex.springframework.model.VetSpecialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetSpecialityRepository extends CrudRepository<VetSpecialty, Long> {
}
