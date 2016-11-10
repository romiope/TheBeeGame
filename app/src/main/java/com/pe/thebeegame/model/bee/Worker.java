package com.pe.thebeegame.model.bee;

import com.pe.thebeegame.model.bee.Bee;

public final class Worker extends Bee {

    public Worker() {
        super(75);
    }

    @Override
    public boolean hit() {
        return super.hit(10);
    }
}