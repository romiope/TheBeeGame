package com.pe.thebeegame.model.bee;

public abstract class Bee {
    private int lifespan;

    Bee(int maxLifespan){
        lifespan = maxLifespan;
    }

    final boolean isDead(){
        return lifespan == 0;
    }

    // return true if is dead
    final boolean hit(int value) {
        lifespan = lifespan - value;
        if (lifespan < 0) {
            lifespan = 0;
        }
        return isDead();
    }

    public final int getLifespan() {
        return lifespan;
    }

    public abstract boolean hit();
}
