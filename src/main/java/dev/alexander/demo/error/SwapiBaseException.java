package dev.alexander.demo.error;

import java.util.UUID;
import lombok.Getter;

@Getter
public class SwapiBaseException extends RuntimeException {

    private final UUID errorId;

    public SwapiBaseException(String message){
        super(message);
        this.errorId = UUID.randomUUID();
    }
    
}

