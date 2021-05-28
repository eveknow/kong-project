package com.thanhtk.service.tracking.rabbit.listener;

import com.thanhtk.service.tracking.rabbit.listener.worker.WorkerManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TrackingListener {

    private static final Logger logger = LogManager.getLogger("JSON");

    @RabbitListener(queues = "#{trackingRabbitMQConfig.getInstanceRef().getQueues()}")
    private void process(Message message) {
        try {
            logger.info("Received Msg " + message.toString());
            String routingKey = message.getMessageProperties().getReceivedRoutingKey();
            WorkerManager.getWorker(routingKey).run(new String(message.getBody()));
        } catch (Exception e) {
            logger.error("Process message from queue is failed.", e);
        }
    }
}
