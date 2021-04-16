package it.eng.idsa.streamer.websocket.receiver.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Milan Karajovic and Gabriele De Luca
 */

public class ResponseMessageBufferBean {

    private BlockingQueue<byte[]> responseMessageQueue;

    private static ResponseMessageBufferBean instance;
    private static final Logger logger = LoggerFactory.getLogger(ResponseMessageBufferBean.class);


    private ResponseMessageBufferBean() {
        	this.responseMessageQueue = new ArrayBlockingQueue<>(1);
    }

    public static ResponseMessageBufferBean getInstance() {
        if (instance == null) {
            synchronized (ResponseMessageBufferBean.class) {
                if (instance == null) {
                    instance = new ResponseMessageBufferBean();
                }
            }
        }
        return instance;
    }

     public void add(byte[] msg) {
         try {
             responseMessageQueue.put(msg);
         } catch (InterruptedException e) {
            logger.error("ResponseMessageBufferBean error in add method  with stack: "+ e.getMessage());
         }
     }

     public byte[] remove() {
         try {
             return responseMessageQueue.take();
         } catch (InterruptedException e) {
            logger.error("ResponseMessageBufferBean error in remove method  with stack: "+ e.getMessage());
         } finally {
             //responseMessageQueue.clear();
         }
         return null;
     }
}
