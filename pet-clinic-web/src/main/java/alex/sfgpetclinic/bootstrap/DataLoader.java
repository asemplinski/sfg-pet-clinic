package alex.sfgpetclinic.bootstrap;

import alex.springframework.model.Owner;
import alex.springframework.model.Vet;
import alex.springframework.services.OwnerService;
import alex.springframework.services.VetService;
import alex.springframework.services.map.OwnerServiceMap;
import alex.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;

    public DataLoader(OwnerServiceMap ownerService, VetServiceMap vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Alex");
        owner1.setLastName("Semplinski");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("David");
        owner2.setLastName("Schmidt");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Tina");
        vet1.setLastName("PetLover");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2l);
        vet2.setFirstName("Bobby");
        vet1.setLastName("McGee");

        vetService.save(vet2);

        System.out.println("Loaded Vets");



    }
}