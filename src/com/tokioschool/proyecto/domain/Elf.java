package com.tokioschool.proyecto.domain;

public class Elf extends Hero {

    public Elf(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public String dead(){
        return "Muere Elfo "+getName()+"!";
    }


}
