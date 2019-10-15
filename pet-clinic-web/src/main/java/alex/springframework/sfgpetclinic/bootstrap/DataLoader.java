package alex.springframework.sfgpetclinic.bootstrap;

import alex.springframework.sfgpetclinic.model.Owner;
import alex.springframework.sfgpetclinic.model.Person;
import alex.springframework.sfgpetclinic.model.Vet;
import alex.springframework.sfgpetclinic.services.OwnerService;
import alex.springframework.sfgpetclinic.services.VetService;
import alex.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import alex.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerService;
    private  final VetServiceMap vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

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
