package alex.springframework.services.springdatajpa;

import alex.springframework.model.VetSpecialty;
import alex.springframework.repositories.VetSpecialityRepository;
import alex.springframework.services.VetSpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class VetSpecialtySDJpaService implements VetSpecialtyService {

    VetSpecialityRepository vetSpecialityRepository;

    public VetSpecialtySDJpaService(VetSpecialityRepository vetSpecialityRepository) {
        this.vetSpecialityRepository = vetSpecialityRepository;
    }

    @Override
    public Set<VetSpecialty> findAll() {
        Set<VetSpecialty> vetSpecialties = new HashSet<>();

        vetSpecialityRepository.findAll().forEach(vetSpecialties::add);

        return vetSpecialties;
    }

    @Override
    public VetSpecialty findById(Long aLong) {
        return vetSpecialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public VetSpecialty save(VetSpecialty object) {
        return vetSpecialityRepository.save(object);
    }

    @Override
    public void delete(VetSpecialty object) {
        vetSpecialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetSpecialityRepository.deleteById(aLong);
    }
}
