package com.tokioschool.proyecto.domain;

import java.util.ArrayList;

public class Army<T extends Character> {
    private ArrayList<T> elements;

    public Army(){
        elements=new ArrayList<>();
    }

    public T get(int index){
        return elements.get(index);
    }

    public void add(T element){ elements.add(element);
    }

    public int getSize(){
        return elements.size();
    }

    public String remove(T element){
        elements.remove(element);
        return element.dead();
    }

    public void setPosition(T element,int index){
        elements.set(index,element);
    }

    public void reset(){
        elements.clear();
    }

}