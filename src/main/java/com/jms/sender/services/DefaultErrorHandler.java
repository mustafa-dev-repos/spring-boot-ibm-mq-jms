package com.jms.sender.services;

import java.util.concurrent.TimeUnit;

import org.springframework.util.ErrorHandler;

public class DefaultErrorHandler implements ErrorHandler {

   // private static Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @Override
    public void handleError(Throwable t) {
        //log.warn("spring jms custom error handling example");
        //log.error(t.getCause().getMessage());
    	System.out.println(t.getCause().getMessage());
    	try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
