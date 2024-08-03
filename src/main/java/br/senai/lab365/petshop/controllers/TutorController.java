package br.senai.lab365.petshop.controllers;

import br.senai.lab365.petshop.models.Tutor;
import br.senai.lab365.petshop.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    public ResponseEntity<Tutor> cadastrar(@RequestBody Tutor tutor) {
        return ResponseEntity.ok(tutorService.cadastrarTutor(tutor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> atualizar(@PathVariable Long id, @RequestBody Tutor tutor) {
        Tutor tutorAtualizado = tutorService.atualizarTutor(id, tutor);
        if (tutorAtualizado != null) {
            return ResponseEntity.ok(tutorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> listarTutores() {
        return ResponseEntity.ok(tutorService.listarTutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscarPorId(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.buscarTutorPorId(id);
        if (tutor.isPresent()) {
            return ResponseEntity.ok(tutor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletar(@PathVariable Long id) {
        boolean sucesso = tutorService.deletarTutor(id);
        if (sucesso) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
