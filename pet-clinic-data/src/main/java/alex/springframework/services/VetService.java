package alex.springframework.services;

import alex.springframework.model.Vet;
import org.springframework.stereotype.Component;


@Component
public interface VetService extends CrudService<Vet, Long> {


}
