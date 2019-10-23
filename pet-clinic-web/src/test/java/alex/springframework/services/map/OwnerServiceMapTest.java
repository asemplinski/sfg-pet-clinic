package alex.springframework.services.map;


import alex.springframework.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long owner1Id = 1L;
    final Long owner2Id = 2L;
    final String lastName = "Semplinski";


    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        Owner owner = new Owner();
        owner.setId(owner1Id);
        owner.setLastName(lastName);
        ownerServiceMap.save(owner);

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());


    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);

        assertEquals(owner1Id, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = new Owner();
        owner2.setId(owner2Id);

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(owner2Id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(owner1Id));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(owner1Id);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner results = ownerServiceMap.findByLastName(lastName);

        assertNotNull(results);

    }
}