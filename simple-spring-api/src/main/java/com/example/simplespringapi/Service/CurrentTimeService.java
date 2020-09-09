package com.example.simplespringapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrentTimeService {
    //java -jar -Dspring.profiles.active=prod target/simple-spring-api-0.0.1-SNAPSHOT.jar
    // dynamically changing enrollement  in artifact
    @Autowired
    Environment env;

    public String getCurrentDateAndTime(){
        String message= env.getProperty("message");
        LocalDateTime localDateTime = LocalDateTime.now();
        return message.concat(localDateTime.toString());
    }
}
