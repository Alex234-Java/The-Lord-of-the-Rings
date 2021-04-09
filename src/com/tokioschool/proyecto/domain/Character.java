package com.tokioschool.proyecto.domain;

public abstract class Character {

    private String name;
    private int life;
    private int armor;

    Character(String name, int life, int armor){
        this.name=name;
        this.life=life;
        this.armor=armor;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getArmor() {
        return armor;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public abstract String dead();
    public abstract int attack();

    @Override
    public String toString(){
        return (getName()+"(Vida="+getLife()+" Armadura="+getArmor()+")");
    }


}
