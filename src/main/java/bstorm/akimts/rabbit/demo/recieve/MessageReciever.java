package bstorm.akimts.rabbit.demo.recieve;

import bstorm.akimts.rabbit.demo.models.Facture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever {

    private final Logger logger = LoggerFactory.getLogger(MessageReciever.class);

    @RabbitListener(queues = "facture_queue")
    public void recieveFacture(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Facture f = mapper.readValue(message, Facture.class);
        logger.info("FACTURE RECIEVED - " + f);
    }

    @RabbitListener(queues = "compta_queue")
    public void recieveCompta(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Facture f = mapper.readValue(message, Facture.class);
        logger.info("COMPTA RECIEVED - " + f);
    }

}
