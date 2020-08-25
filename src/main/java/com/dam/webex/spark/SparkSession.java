package com.dam.webex.spark;

import ciscospark.Message;
import ciscospark.Room;
import ciscospark.Spark;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class SparkSession {

    private String accessToken;

    public Spark buildSession() {
        Spark spark = Spark.builder()
                .baseUrl(URI.create("https://api.ciscospark.com/v1"))
                .accessToken(accessToken)
                .build();

        return spark;
    }

    public Room createRoom(Spark spark) {
        Room room = new Room();
        room.setTitle("Hello World");
        room = spark.rooms().post(room);

        return room;
    }

    public Message postMessage(Spark spark, Room room) {
        Message message = new Message();
        message.setRoomId(room.getId());
        spark.messages().post(message);

        return message;
    }

}
