package it.eng.idsa.streamer;

import it.eng.idsa.streamer.websocket.receiver.MessageWebSocketResponse;
import it.eng.idsa.streamer.websocket.receiver.server.*;

/**
 * @author Milan Karajovic and Gabriele De Luca
 */

public class WebSocketServerManager {


    public static FrameBufferBean getFrameBufferWebSocket() {
        return FrameBufferBean.getInstance();
    }

    public static HttpWebSocketServerBean getHttpsServerWebSocket() {
        return HttpWebSocketServerBean.getInstance();
    }

    public static FileRecreatorBeanServer getFileRecreatorBeanWebSocket() {
        return FileRecreatorBeanServer.getInstance();
    }

    public static HttpWebSocketMessagingLogic getMessagingLogic() {
        return HttpWebSocketMessagingLogic.getInstance();
    }

    public static RecreatedMultipartMessageBean recreatedMultipartMessageBeanWebSocket() {
        return RecreatedMultipartMessageBean.getInstance();
    }

    public static ResponseMessageBufferBean responseMessageBufferWebSocket() {
        return ResponseMessageBufferBean.getInstance();
    }

    public static ResponseMessageSendPartialServer responseMessageSendPartialWebSocket() {
        return ResponseMessageSendPartialServer.getInstance();
    }

    public static FileRecreatorBeanExecutor fileRecreatorBeanExecutor() {
        return FileRecreatorBeanExecutor.getInstance();
    }

    public static MessageWebSocketResponse getMessageWebSocketResponse() {
        return MessageWebSocketResponse.getInstance();
    }

}
