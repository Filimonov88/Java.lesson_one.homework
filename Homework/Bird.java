package ru.geekbrains.java_one.lesson_e.Homework;

public class Bird extends Beast {
    public Bird(String type, String name, float run, float jump, float swim) {
        super(type, name, run, jump, swim);
    }

    @Override
    protected boolean swimming(float swim) {
        return false;
    }
}
