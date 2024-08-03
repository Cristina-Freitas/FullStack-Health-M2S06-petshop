package br.senai.lab365.petshop.repositories;


import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.models.Tutor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PetRepository {
    private List<Pet> pets = new ArrayList<>();

    public Pet save(Pet pet) {
        pets.removeIf(p -> p.getId().equals(pet.getId()));
        pets.add(pet);
        return pet;
    }

    public List<Pet> findAll() {
        return new ArrayList<>(pets);
    }

    public Optional<Pet> findById(Long id) {
        return pets.stream().filter(pet -> pet.getId().equals(id)).findFirst();
    }

    public boolean deleteById(Long id) {
        return pets.removeIf(pet -> pet.getId().equals(id));
    }

    public void associateTutor(Long petId, Tutor tutor) {
        Optional<Pet> petOpt = findById(petId);
        if (petOpt.isPresent()) {
            Pet pet = petOpt.get();
            pet.setTutor(tutor);
            save(pet);
        }
    }
}


