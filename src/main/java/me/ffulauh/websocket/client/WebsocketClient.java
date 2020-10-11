package me.ffulauh.websocket.client;

import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ffulauh on 2017/5/23.
 */
public class WebsocketClient {
    public static void main(String[] args) {
        List<Transport> transports=new ArrayList<Transport>(2);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(new RestTemplateXhrTransport());

        SockJsClient sockJsClient=new SockJsClient(transports);
//        sockJsClient.doHandshake(new MyWeb)
    }
}
