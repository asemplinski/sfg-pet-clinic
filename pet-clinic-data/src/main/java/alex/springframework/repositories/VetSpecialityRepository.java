package alex.springframework.repositories;

import alex.springframework.model.VetSpecialty;
import org.springframework.data.repository.CrudRepository;

public interface VetSpecialityRepository extends CrudRepository<VetSpecialty, Long> {
}
