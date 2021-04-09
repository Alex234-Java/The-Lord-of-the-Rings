package com.tokioschool.proyecto.domain;

public class Goblin extends Beast {

    public Goblin(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public String dead(){
        return"Muere Trasgo "+getName()+"!";
    }
}
