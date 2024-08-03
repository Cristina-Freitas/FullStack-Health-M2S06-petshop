package br.senai.lab365.petshop.repositories;


import br.senai.lab365.petshop.models.Tutor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TutorRepository {

    private List<Tutor> tutores = new ArrayList<>();

    public Tutor save(Tutor tutor) {
        tutores.removeIf(t -> t.getId().equals(tutor.getId()));
        tutores.add(tutor);
        return tutor;
    }

    public List<Tutor> findAll() {
        return new ArrayList<>(tutores);
    }

    public Optional<Tutor> findById(Long id) {
        return tutores.stream().filter(tutor -> tutor.getId().equals(id)).findFirst();
    }

    public boolean deleteById(Long id) {
        return tutores.removeIf(tutor -> tutor.getId().equals(id));
    }
}

