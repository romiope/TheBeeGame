package com.pe.thebeegame.model.bee;

import com.pe.thebeegame.model.bee.Bee;

public final class Drone extends Bee {

    public Drone() {
        super(50);
    }

    @Override
    public boolean hit() {
        return super.hit(8);
    }
}