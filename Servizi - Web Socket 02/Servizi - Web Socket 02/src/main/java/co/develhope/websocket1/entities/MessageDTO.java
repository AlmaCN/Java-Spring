package co.develhope.websocket1.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDTO {

    private String type;
    private String message;
}