package alex.springframework.services;

import alex.springframework.model.Pet;
import org.springframework.stereotype.Component;



public interface PetService extends CrudService<Pet, Long> {


}
