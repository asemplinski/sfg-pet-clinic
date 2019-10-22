package alex.springframework.repositories;

import alex.springframework.model.VetSpecialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VetSpecialityRepository extends CrudRepository<VetSpecialty, Long> {

    Set<VetSpecialty> findAll();

    Optional<VetSpecialty> findById(Long aLong);

    VetSpecialty save(VetSpecialty vetSpecialty);

    void delete(VetSpecialty vetSpecialty);

    void deleteById(Long aLong);

}
