package com.tokioschool.proyecto.domain;

public class Human extends Hero {

    public Human(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public String dead(){
        return"Muere Humano "+getName()+"!";
    }
}
