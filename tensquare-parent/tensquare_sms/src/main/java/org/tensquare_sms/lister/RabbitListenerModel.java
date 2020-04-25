package org.tensquare_sms.lister;

import java.util.HashMap;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue_02")
public class RabbitListenerModel {
	@RabbitHandler
	public void InMessage(HashMap<String,String> map) {
		System.out.println("直接模式已经获得"+map);
	}
}
