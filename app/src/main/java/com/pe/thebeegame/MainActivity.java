package com.pe.thebeegame;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pe.thebeegame.model.Hive;
import com.pe.thebeegame.model.bee.Drone;
import com.pe.thebeegame.model.bee.Worker;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Hive hive = new Hive();

    private TextView roundNumberTv;

    private TextView queenHp;

    private View workerContainer;
    private TextView workerCounter;
    private TextView workerHp;

    private View droneContainer;
    private TextView droneCounter;
    private TextView droneHp;

    private View beesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        updateViews();
    }

    private void bindViews() {
        beesContainer = findViewById(R.id.bees_container);
        roundNumberTv = (TextView) findViewById(R.id.round_number_tv);

        View queenContainer = findViewById(R.id.queen_container);
        queenHp = (TextView) queenContainer.findViewById(R.id.overal_tv);

        workerContainer = findViewById(R.id.worker_container);
        workerCounter = (TextView) workerContainer.findViewById(R.id.count_tv);
        workerHp = (TextView) workerContainer.findViewById(R.id.overal_tv);

        droneContainer = findViewById(R.id.drone_container);
        droneCounter = (TextView) droneContainer.findViewById(R.id.count_tv);
        droneHp = (TextView) droneContainer.findViewById(R.id.overal_tv);
    }

    private void updateViews() {
        roundNumberTv.setText("Round : "+Hive.getCounter());

        queenHp.setText("hp: " + hive.getQueen().getLifespan());

        final List<Worker> workers = hive.getWorkers();
        workerContainer.setVisibility(workers.isEmpty() ? View.INVISIBLE : View.VISIBLE);
        workerCounter.setText("count: " + Integer.toString(workers.size()));
        workerHp.setText("hp: " + Integer.toString(Hive.countHpSum(workers)));

        final List<Drone> drones = hive.getDrones();
        droneContainer.setVisibility(drones.isEmpty() ? View.INVISIBLE : View.VISIBLE);
        droneCounter.setText("count: " + Integer.toString(drones.size()));
        droneHp.setText("hp: " + Integer.toString(Hive.countHpSum(drones)));
    }


    public void onPlayClick(View view) {
        view.setVisibility(View.INVISIBLE);
        findViewById(R.id.main_container).setVisibility(View.VISIBLE);
    }

    public void onHitClick(View view) {
        if (hive.attack()) {
            Toast.makeText(this, "Hive killed", Toast.LENGTH_LONG).show();
            hive = new Hive();
        }
        beesContainer.setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_orange_dark));
        beesContainer.postDelayed(new Runnable() {
            @Override
            public void run() {
                beesContainer.setBackgroundColor(ContextCompat.getColor(getBaseContext(), android.R.color.holo_green_light));
            }
        }, 100);
        updateViews();
    }

}
