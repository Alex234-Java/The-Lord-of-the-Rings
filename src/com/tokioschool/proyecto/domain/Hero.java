package com.tokioschool.proyecto.domain;

import java.util.Random;

public abstract class Hero extends Character{


    Hero(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public int attack(){
        Random random=new Random();
        int dice1,dice2;

        dice1=random.nextInt(100);
        dice2=random.nextInt(100);

        return Math.max(dice1, dice2);

    }


}
