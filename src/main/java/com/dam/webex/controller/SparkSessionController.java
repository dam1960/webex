package com.dam.webex.controller;

import ciscospark.Room;
import ciscospark.Spark;
import com.dam.webex.spark.SparkSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparkSessionController {

    private final SparkSession sparkSession;

    public SparkSessionController(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    @PostMapping("/start-session")
    public Spark startSession() {
        return sparkSession.buildSession();
    }

    @PostMapping("/create-room")
    public Room createRoom(Spark spark) {
        return sparkSession.createRoom(spark);
    }


}
