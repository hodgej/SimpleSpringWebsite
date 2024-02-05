package com.jackhodge.DataViewTool.messageBrokerIntegration;

import com.jackhodge.DataViewTool.model.PostTruckloadUpdateForm;
import com.jackhodge.DataViewTool.service.TruckloadAppendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//TODO: Delegate messageBrokerIntegration package to a microservice

@Component
public class TruckloadQueueConsumer {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private TruckloadAppendService truckloadAppendService;

    public TruckloadQueueConsumer(TruckloadAppendService truckloadAppendService) {
        this.truckloadAppendService = truckloadAppendService;
    }

    @JmsListener(destination = "truckload-post-queue")
    public void truckloadConsumer(PostTruckloadUpdateForm form){
        logger.info(form.toString());
        truckloadAppendService.processTruckloadUpdateForm(form);
    }
}
