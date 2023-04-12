package co.develhope.ServiziEmail1.entities;

import lombok.Data;

/**
 * Ho creato la classe NotificationDTO che contiene le seguenti variabili. contactId, title e text.
 */
@Data
public class NotificationDTO {

    private String contactId;
    private String title;
    private String text;
}
