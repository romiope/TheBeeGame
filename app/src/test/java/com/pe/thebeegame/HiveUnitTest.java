package com.pe.thebeegame;

import com.pe.thebeegame.model.Hive;
import com.pe.thebeegame.model.bee.Queen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HiveUnitTest {

    @Test
    public void hiveCreationIsCorrect() throws Exception {
        Hive hive = new Hive();
        assertEquals(1+5+8, 1+hive.getWorkers().size()+hive.getDrones().size());
    }

    @Test
    public void hiveGameEndIsCorrect() throws Exception {
        Hive hive = new Hive();
        assertEquals(false, hive.isHiveDead());

        int maxHits = 1000;

        while (maxHits >= 0) {
            hive.attack();
            maxHits--;
        }
        assertEquals(true, hive.isHiveDead());
    }
}