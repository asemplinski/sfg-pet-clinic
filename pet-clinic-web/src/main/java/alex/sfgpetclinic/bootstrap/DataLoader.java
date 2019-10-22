package alex.sfgpetclinic.bootstrap;

import alex.springframework.model.*;
import alex.springframework.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private  final PetTypeService petTypeService;
    private final VetSpecialtyService vetSpecialtyService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, VetSpecialtyService vetSpecialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.vetSpecialtyService = vetSpecialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        PetType savedDogType = petTypeService.save(dogPetType);
        System.out.println("Saved Dog Pet Type");

        PetType catPetType = new PetType();
        catPetType.setName("Cat");
        PetType savedCatType = petTypeService.save(catPetType);
        System.out.println("Saved Cat Pet Type");


        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Semplinski");
        owner1.setAddress("4009 W 52nd.");
        owner1.setCity("Denver");
        owner1.setTelephone("408-497-7781");

        Pet alexsdog = new Pet();
        alexsdog.setPetType(dogPetType);
        alexsdog.setOwner(owner1);
        alexsdog.setName("Utah");
        alexsdog.setBirthDate(LocalDate.now());

        owner1.getPets().add(alexsdog);

        ownerService.save(owner1);

        Visit dogVisit = new Visit();
        dogVisit.setPet(alexsdog);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Sneezy Dog");

        visitService.save(dogVisit);

        System.out.println();

        Owner owner2 = new Owner();
        owner2.setFirstName("David");
        owner2.setLastName("Schmidt");
        owner2.setAddress("1611 Mullberry Lane");
        owner2.setCity("San Jose");
        owner2.setTelephone("408-540-9847");

        Pet davesCat = new Pet();
        davesCat.setPetType(catPetType);
        davesCat.setOwner(owner2);
        davesCat.setName("Nigel");
        davesCat.setBirthDate(LocalDate.now());

        owner2.getPets().add(davesCat);


        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        VetSpecialty radiology = new VetSpecialty();
        radiology.setDescription("Radiology");
        VetSpecialty savedRadiology = vetSpecialtyService.save(radiology);

        VetSpecialty surgery = new VetSpecialty();
        surgery.setDescription("Surgery");
        VetSpecialty savedSurgery = vetSpecialtyService.save(surgery);


        Vet vet1 = new Vet();
        vet1.setFirstName("Tina");
        vet1.setLastName("Fey");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobby");
        vet2.setLastName("McGee");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
