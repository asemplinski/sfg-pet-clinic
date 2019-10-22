package alex.springframework.repositories;

import alex.springframework.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    Set<Owner> findAll();

    Optional<Owner> findById(Long along);

    Owner save(Owner owner);

    void delete(Owner owner);

    void deleteById(Long aLong);
}
