package com.tokioschool.proyecto.domain;

public class Hobbit extends Hero {

    public Hobbit(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public String dead() {
        return"Muere Hobbito " + getName() + "!";
    }
}
