package br.senai.lab365.petshop.services;


import br.senai.lab365.petshop.models.Tutor;
import br.senai.lab365.petshop.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public Tutor cadastrarTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor atualizarTutor(Long id, Tutor tutor) {
        if (tutorRepository.findById(id).isPresent()) {
            tutor.setId(id);
            return tutorRepository.save(tutor);
        }
        return null;
    }

    public List<Tutor> listarTutores() {
        return tutorRepository.findAll();
    }

    public static Optional<Tutor> buscarTutorPorId(Long id) {
        return tutorRepository.findById(id);
    }

    public boolean deletarTutor(Long id) {
        return tutorRepository.deleteById(id);
    }
}
