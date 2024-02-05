package com.jackhodge.DataViewTool.messageBrokerIntegration;

import com.jackhodge.DataViewTool.model.PostTruckloadUpdateForm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Optional;

@RestController
public class TruckloadQueuePostController implements Serializable {

    private JmsTemplate jmsTemplate;

    public TruckloadQueuePostController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/api/queue/truckloads")
    public ResponseEntity<String> truckloadQueuePostRequest(@RequestBody PostTruckloadUpdateForm form){
        Optional<String> response;
        try {
            if(form.isValid()) {
                jmsTemplate.convertAndSend("truckload-post-queue", form);
                return ResponseEntity.ok("PostTruckloadUpdateForm added to queue");
            } else{
                response = Optional.of("Not Complete: PostTruckloadUpdateForm has null properties");
                return ResponseEntity.of(response);
            }
        } catch(JmsException e){
            response = Optional.of("Not Complete: Internal Server Error during truckload Queue Post Request: " + e);
            return ResponseEntity.of(response);
        }
    }

}
