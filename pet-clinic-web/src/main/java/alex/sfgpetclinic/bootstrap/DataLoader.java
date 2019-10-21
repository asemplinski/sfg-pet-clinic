package alex.sfgpetclinic.bootstrap;

import alex.springframework.model.Owner;
import alex.springframework.model.Pet;
import alex.springframework.model.PetType;
import alex.springframework.model.Vet;
import alex.springframework.services.OwnerService;
import alex.springframework.services.PetTypeService;
import alex.springframework.services.VetService;
import alex.springframework.services.map.OwnerServiceMap;
import alex.springframework.services.map.PetServiceMap;
import alex.springframework.services.map.PetTypeServiceMap;
import alex.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private  final PetTypeService petTypeService;


    public DataLoader(OwnerServiceMap ownerService, VetServiceMap vetService, PetTypeServiceMap petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        PetType savedDogType = petTypeService.save(dogPetType);
        System.out.println("Saved Dog Pet Type");

        PetType catPetType = new PetType();
        dogPetType.setName("Cat");
        PetType savedCatType = petTypeService.save(catPetType);
        System.out.println("Saved Cat Pet Type");

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Semplinski");

        ownerService.save(owner1);

        System.out.println();

        Owner owner2 = new Owner();
        owner2.setFirstName("David");
        owner2.setLastName("Schmidt");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tina");
        vet1.setLastName("Fey");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobby");
        vet2.setLastName("McGee");

        vetService.save(vet2);

        System.out.println("Loaded Vets");

    }
}
