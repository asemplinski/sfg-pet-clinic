package alex.springframework.services.map;

import alex.springframework.model.VetSpecialty;
import alex.springframework.services.VetSpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetSpecialtyServiceMap extends AbstractMapService<VetSpecialty, Long> implements VetSpecialtyService {

    @Override
    public Set<VetSpecialty> findAll() {
        return super.findAll();
    }

    @Override
    public VetSpecialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public VetSpecialty save(VetSpecialty object) {
        return super.save(object);
    }

    @Override
    public void delete(VetSpecialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
