package com.example.websocketbinancesampleservice;

import com.example.websocketbinancesampleservice.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MyStompSessionHandler.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        LOGGER.info("Connected to the WebSocket server");
        session.subscribe("/topic/trade", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return Trade.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                Trade trade = (Trade) payload;
                LOGGER.info("Received trade: {}", trade.toString());
                // Process the received trade using the TradeService
            }
        });
    }
    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        LOGGER.error("Error on WebSocket connection", exception);
    }

    public void setMessageConverter(MappingJackson2MessageConverter mappingJackson2MessageConverter) {
    }
}
