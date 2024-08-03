package br.senai.lab365.petshop.services;


import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet cadastrar(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet atualizar(Long id, Pet pet) {
        if (petRepository.findById(id).isPresent()) {
            pet.setId(id);
            return petRepository.save(pet);
        }
        return null;
    }

    public List<Pet> listarPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> buscarPorId(Long id) {
        return petRepository.findById(id);
    }

    public boolean deletar(Long id) {
        return petRepository.deleteById(id);
    }
}

