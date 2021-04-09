package com.tokioschool.proyecto.domain;

public class Battle<T extends Character, U extends Character> {
    private Army<T> firstArmy;
    private Army<U> secondArmy;
    private T firstFighter;
    private U secondFighter;
    private String fightText;
    private int i;

    public Battle(Army<T> heroesArmy, Army<U> beastsArmy) {
        fightText="";
        this.firstArmy = heroesArmy;
        this.secondArmy = beastsArmy;
        i = 1;

    }

    public String printFight() {
        while (firstArmy.getSize()!=0&& secondArmy.getSize()!=0) {
            fightText=fightText.concat("Turno " + i + ":"+System.lineSeparator());
            if (firstArmy.getSize() < secondArmy.getSize())
                for (int j = 0; j < firstArmy.getSize(); j++) {
                    fightText=fightText.concat("Lucha entre " + firstArmy.get(j) + " y " + secondArmy.get(j)+System.lineSeparator());
                    doDamage(j);
                }
            else{
                for (int j = 0; j < secondArmy.getSize(); j++){
                    fightText=fightText.concat("Lucha entre " + firstArmy.get(j) + " y " + secondArmy.get(j)+System.lineSeparator());
                    doDamage(j);
                }
            }
            if(firstArmy.getSize()==0)
                fightText=fightText.concat("The BEASTS have Won the battle!!"+System.lineSeparator());
            if(secondArmy.getSize()==0)
                fightText=fightText.concat("The HEROES have Won the battle!!"+System.lineSeparator());
            i++;
        }
        return fightText;

    }

    public void doDamage(int index){
        if(firstArmy.getSize()>0&& secondArmy.getSize()>0) {
            firstFighter = firstArmy.get(index);
            secondFighter = secondArmy.get(index);
            int heroDamage = firstFighter.attack();
            int beastDamage = secondFighter.attack();
            int heroStartingArmor = firstFighter.getArmor();


            if (secondFighter instanceof Orc)
                firstFighter.setArmor(firstFighter.getArmor() - (firstFighter.getArmor() * 10 / 100));
            if (firstFighter instanceof Hobbit && secondFighter instanceof Goblin)
                heroDamage -= 5;
            if (firstFighter instanceof Elf && secondFighter instanceof Orc)
                heroDamage += 10;

            int damageDealt = heroDamage - secondFighter.getArmor();
            if (damageDealt < 0)
                damageDealt = 0;
            else
                secondFighter.setLife(secondFighter.getLife() - damageDealt);

            fightText = fightText.concat(firstFighter.getName() + " saca " + heroDamage + " y le quita " + damageDealt +
                    " de vida a " + secondFighter.getName() + System.lineSeparator());


            damageDealt = beastDamage - firstFighter.getArmor();
            if (damageDealt < 0)
                damageDealt = 0;
            else
                firstFighter.setLife(firstFighter.getLife() - damageDealt);

            fightText = fightText.concat(secondFighter.getName() + " saca " + beastDamage + " y le quita " + damageDealt +
                    " de vida a " + firstFighter.getName() + System.lineSeparator());

            firstFighter.setArmor(heroStartingArmor);

            if (firstFighter.getLife() <= 0)
                fightText = fightText.concat(firstArmy.remove(firstFighter) + System.lineSeparator());
            if (secondFighter.getLife() <= 0)
                fightText = fightText.concat(secondArmy.remove(secondFighter) + System.lineSeparator());


        }
    }
}
