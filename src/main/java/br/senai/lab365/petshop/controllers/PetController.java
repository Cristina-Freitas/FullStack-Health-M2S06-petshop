package br.senai.lab365.petshop.controllers;


import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> cadastrar(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.cadastrar(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizar(@PathVariable Long id, @RequestBody Pet pet) {
        Pet petAtualizado = petService.atualizar(id, pet);
        if (petAtualizado != null) {
            return ResponseEntity.ok(petAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{petId}/tutor/{tutorId}")
    public ResponseEntity<Void> associarTutor(@PathVariable Long petId, @PathVariable Long tutorId) {
        petService.associarTutor(petId, tutorId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listarPets() {
        return ResponseEntity.ok(petService.listarPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable Long id) {
        Optional<Pet> pet = petService.buscarPorId(id);
        if (pet.isPresent()) {
            return ResponseEntity.ok(pet.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletar(@PathVariable Long id) {
        boolean sucesso = petService.deletar(id);
        if (sucesso) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

