package alex.springframework.services.springdatajpa;

import alex.springframework.model.Owner;
import alex.springframework.repositories.OwnerRepository;
import alex.springframework.repositories.PetRepository;
import alex.springframework.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName("Semplinski");

        when( ownerRepository.findByLastName(any())).thenReturn(returnOwner);


        Owner semplinski = service.findByLastName("Semplinski");

        assertEquals("Semplinski", semplinski.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwners = new HashSet<>();

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Semplinski");

        returnOwners.add(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setLastName("Schmidt");

        returnOwners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> returnedOwners = service.findAll();

        assertEquals(2, returnedOwners.size());


    }

    @Test
    void findById() {
        Owner returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName("Semplinski");

        Optional<Owner> optionalReturn = Optional.of(returnOwner);

        when( ownerRepository.findById(any())).thenReturn(optionalReturn);


        Owner semplinski = service.findById(1L);

        assertEquals("Semplinski", semplinski.getLastName());
        verify(ownerRepository).findById(any());

    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}