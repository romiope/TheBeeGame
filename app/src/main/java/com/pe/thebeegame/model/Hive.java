package com.pe.thebeegame.model;

import com.pe.thebeegame.model.bee.Bee;
import com.pe.thebeegame.model.bee.Drone;
import com.pe.thebeegame.model.bee.Queen;
import com.pe.thebeegame.model.bee.Worker;

import java.util.ArrayList;
import java.util.List;

public class Hive {

    private static int counter = 0;

    private List<Bee> bees = new ArrayList<>();

    final Queen queen = new Queen();

    public static int getCounter() {
        return counter;
    }

    public static <T extends Bee> int countHpSum(List<T> bees) {
        int result = 0;
        for(T b : bees) {
            result = result + b.getLifespan();
        }
        return result;
    }

    public Hive(){
        counter++;

        bees.add(queen);

        for(int i = 0; i != 5; i++) {
            bees.add(new Worker());
        }

        for(int i = 0; i != 8; i++) {
            bees.add(new Drone());
        }
    }

    public boolean isHiveDead() {
        return bees.isEmpty();
    }

    // return true if hive is dead
    public boolean attack() {
        if (bees.isEmpty()) {
            return true;
        }
        final Bee bee = bees.get(getRandomInRange(0, bees.size()));
        if (bee.hit()) {
            if (bee instanceof Queen) {
                bees.clear();
            } else {
                bees.remove(bee);
            }
        }
        return bees.isEmpty();
    }


    public Queen getQueen() {
        return queen;
    }

    public List<Worker> getWorkers() {
        final List<Worker> res = new ArrayList<>();
        for (final Bee w : bees) {
            if (w instanceof Worker) {
                res.add((Worker) w);
            }
        }
        return res;
    }

    public List<Drone> getDrones() {
        final List<Drone> res = new ArrayList<>();
        for (final Bee w : bees) {
            if (w instanceof Drone) {
                res.add((Drone) w);
            }
        }
        return res;
    }

    private int getRandomInRange(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}
