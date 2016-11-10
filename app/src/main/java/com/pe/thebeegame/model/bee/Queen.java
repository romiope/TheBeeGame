package com.pe.thebeegame.model.bee;

import com.pe.thebeegame.model.bee.Bee;

public final class Queen extends Bee {

    public Queen() {
        super(100);
    }

    @Override
    public boolean hit() {
        return super.hit(8);
    }
}