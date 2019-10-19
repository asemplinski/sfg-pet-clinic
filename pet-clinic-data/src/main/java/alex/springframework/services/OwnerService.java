package alex.springframework.services;

import alex.springframework.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{



    Owner findByLastName(String lastName);


}
