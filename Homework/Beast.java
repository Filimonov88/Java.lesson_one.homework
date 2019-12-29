package ru.geekbrains.java_one.lesson_e.Homework;

import java.util.Random;

public abstract class Beast {
    private String type;
    private String name;
    private final float run;
    private final float jump;
    private final float swim;
    private final Random random = new Random();
    protected Beast(String type, String name, float run, float jump, float swim){
        this.type = type;
        this.name = name;
        this.run = run + random.nextFloat() * run - run / 2;
        this.jump = jump + random.nextFloat() * jump - jump / 2;
        this.swim = swim + random.nextFloat() * swim - swim / 2;
    }

    public String getType() { return type; }

    public String getName() { return name; }

    public float getRun() { return run; }

    public float getJump() { return jump; }

    public float getSwim() { return swim; }

    protected boolean running(float run){
        return run <= this.run;
    }

    protected boolean jumping(float jump){
        return jump <= this.jump;
    }

    protected boolean swimming(float swim){
        return swim <= this.swim;
    }
}

