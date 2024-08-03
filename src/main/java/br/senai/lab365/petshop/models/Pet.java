package br.senai.lab365.petshop.models;

public class Pet {
    private Long id;
    private String nome;
    private String raca;
    private Long tutorId;

    public Pet(Long id, String nome, String raca, Long tutorId) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.tutorId = tutorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public boolean isPresent() {
        return false;
    }
}