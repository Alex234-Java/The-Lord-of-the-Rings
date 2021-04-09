package com.tokioschool.proyecto.domain;

import java.util.Random;

public abstract class Beast extends Character {


    Beast(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public int attack(){
        Random random=new Random();
        int dice;

        dice=random.nextInt(90);

        return dice;
    }

}
