package com.tokioschool.proyecto.domain;

public abstract class Animal extends Character{

    Animal(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public int attack() {

        return 50;
    }

}
