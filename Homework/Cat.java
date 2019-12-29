package ru.geekbrains.java_one.lesson_e.Homework;

public class Cat extends Beast {
    public Cat(String type, String name, float run, float jump, float swim){
        super(type, name, run, jump, swim);
    }

    @Override
    protected boolean swimming (float swim){
        return false;
    }
}