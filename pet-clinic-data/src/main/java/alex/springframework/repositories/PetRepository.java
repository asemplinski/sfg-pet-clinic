package alex.springframework.repositories;

import alex.springframework.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    Set<Pet> findAll();

    Optional<Pet> findById(Long aLong);

    Pet save(Pet pet);

    void delete(Pet pet);

    void deleteById(Long aLong);

}
