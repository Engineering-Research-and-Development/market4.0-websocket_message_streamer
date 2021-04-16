package it.eng.idsa.streamer.websocket.receiver.server;

import it.eng.idsa.streamer.WebSocketServerManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class FileRecreatorJob implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(FileRecreatorJob.class);

    @Override
    public void run() {
        try {
            logger.debug("Recreation operation started at: " + LocalDateTime.now());
            FileRecreatorBeanServer fileRecreatorBean = WebSocketServerManager.getFileRecreatorBeanWebSocket();
            fileRecreatorBean.setup();
            Thread fileRecreatorBeanThread = new Thread(fileRecreatorBean, "FileRecreator");
            fileRecreatorBeanThread.start();
            String recreatedMultipartMessage = WebSocketServerManager.recreatedMultipartMessageBeanWebSocket().remove();
            // Extract header and payload from the multipart message
            WebSocketServerManager.getMessageWebSocketResponse().setMultipartMessage(recreatedMultipartMessage);
        } catch (Exception e) {
            logger.error("Error received during FileRecreatorJob execution with stack: " + e.getMessage());
        }
    }

}
