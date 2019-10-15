package alex.springframework.sfgpetclinic.services;

import alex.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{



    Owner findByLastName(String lastName);


}
