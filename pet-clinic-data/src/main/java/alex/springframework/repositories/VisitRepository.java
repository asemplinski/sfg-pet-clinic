package alex.springframework.repositories;

import alex.springframework.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    Set<Visit> findAll();

    Optional<Visit> findById(Long aLong);

    Visit save(Visit visit);

    void delete(Visit visit);

    void deleteById(Long aLong);



}
