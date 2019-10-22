package alex.springframework.services.springdatajpa;

import alex.springframework.model.Vet;
import alex.springframework.repositories.VetRepository;
import alex.springframework.repositories.VetSpecialityRepository;
import alex.springframework.services.VetService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
//@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;
    private final VetSpecialityRepository vetSpecialityRepository;

    public VetSDJpaService(VetRepository vetRepository, VetSpecialityRepository vetSpecialityRepository) {
        this.vetRepository = vetRepository;
        this.vetSpecialityRepository = vetSpecialityRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
