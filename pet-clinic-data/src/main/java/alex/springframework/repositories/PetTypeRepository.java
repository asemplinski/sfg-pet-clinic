package alex.springframework.repositories;

import alex.springframework.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

    Set<PetType> findAll();

    Optional<PetType> findById(Long aLong);

    PetType save(PetType petType);

    void delete(PetType petType);

    void deleteById(Long aLong);

}
