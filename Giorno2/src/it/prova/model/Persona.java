package it.prova.model;

public class Persona {
    private String nome;
    private String cognome;
    private int age;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getAge() {
        return age;
    }

    public boolean isGreater(Persona persona) {
        return this.age > persona.getAge();
    }

}
