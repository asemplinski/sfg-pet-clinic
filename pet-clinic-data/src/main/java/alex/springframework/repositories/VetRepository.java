package alex.springframework.repositories;

import alex.springframework.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {

    Set<Vet> findAll();

    Optional<Vet> findById(Long aLong);

    Vet save(Vet vet);

    void delete(Vet vet);

    void deleteById(Long aLong);

}
