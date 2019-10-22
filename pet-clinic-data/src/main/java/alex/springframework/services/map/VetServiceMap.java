package alex.springframework.services.map;

import alex.springframework.model.Vet;
import alex.springframework.model.VetSpecialty;
import alex.springframework.services.VetService;
import alex.springframework.services.VetSpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final VetSpecialtyService vetSpecialtyService;

    public VetServiceMap(VetSpecialtyService vetSpecialtyService) {
        this.vetSpecialtyService = vetSpecialtyService;
    }

    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialties().size() >0){
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null){
                    VetSpecialty savedSpecialty = vetSpecialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }


        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
