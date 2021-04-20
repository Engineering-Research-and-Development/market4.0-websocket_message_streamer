package it.eng.idsa.streamer.websocket.sender.client;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Milan Karajovic and Gabriele De Luca
 */

public class ResponseMessageBufferClient {

	private BlockingQueue<byte[]> responseMessageQueue;
    private static ResponseMessageBufferClient instance;
    private static final Logger logger = LoggerFactory.getLogger(ResponseMessageBufferClient.class);

    private ResponseMessageBufferClient() {
        this.responseMessageQueue = new ArrayBlockingQueue<>(1);
    }

    public static ResponseMessageBufferClient getInstance() {
        if (instance == null) {
            synchronized (ResponseMessageBufferClient.class) {
                if (instance == null) {
                    instance = new ResponseMessageBufferClient();
                }
            }
        }
        return instance;
    }



    public void add(byte[] msg) {
        try {
            responseMessageQueue.put(msg);
        } catch (InterruptedException e) {
           logger.error("ResponseMessageBufferClient error in add method with stack: "+ e.getMessage());
        }
    }

    public byte[] remove() {
        try {
            return responseMessageQueue.take();
        } catch (InterruptedException e) {
            logger.error("ResponseMessageBufferClient error in remove method with stack: "+ e.getMessage());
        } finally {
            //responseMessageQueue.clear(); //with capacity 1 not mandatory
        }
        return null;
    }
}
