package alex.springframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
            joinColumns =@JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "vet_specialty_id"))
    private Set<VetSpecialty> specialties = new HashSet<>();

    public Set<VetSpecialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<VetSpecialty> specialties) {
        this.specialties = specialties;
    }
}
