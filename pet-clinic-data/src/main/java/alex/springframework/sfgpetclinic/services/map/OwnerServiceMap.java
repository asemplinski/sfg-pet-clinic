package alex.springframework.sfgpetclinic.services.map;

import alex.springframework.sfgpetclinic.model.Owner;
import alex.springframework.sfgpetclinic.services.CrudService;
import alex.springframework.sfgpetclinic.services.OwnerService;

import javax.persistence.Id;
import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private  Owner owner;

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }


    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

}
