package alex.sfgpetclinic.controllers;

import alex.springframework.model.Owner;
import alex.springframework.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class ownerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    ownerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner o1 = new Owner();
        o1.setId(1L);
        Owner o2 = new Owner();
        o2.setId(2L);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners")).andExpect(status().isOk())
        .andExpect(view().name("/owners/index"));



    }

    @Test
    void returnError() {
    }
}