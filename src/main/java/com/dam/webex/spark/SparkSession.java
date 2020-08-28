package com.dam.webex.spark;

import ciscospark.Message;
import ciscospark.Room;
import ciscospark.Spark;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class SparkSession {

    private final RestTemplate restTemplate;

    private String accessToken;

    public SparkSession(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Spark buildSession() {

        Spark spark = Spark.builder()
                .baseUrl(URI.create("https://api.ciscospark.com/v1"))
                .accessToken(accessToken)
                .build();

        return spark;
    }

    private String getAccessToken() {

//        restTemplate.postForObject("https://webexapis.com/v1/authorize", );
        return null;
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
