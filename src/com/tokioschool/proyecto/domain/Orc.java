package com.tokioschool.proyecto.domain;

public class Orc extends Beast {

    public Orc(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public String dead(){
        return"Muere Orco "+getName()+"!";
    }
}
