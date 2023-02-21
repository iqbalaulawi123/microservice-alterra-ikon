package com.example.websocketbinancesampleservice.controller;

import com.example.websocketbinancesampleservice.model.Trade;
import com.example.websocketbinancesampleservice.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @MessageMapping("/btcusdt@trade")
    public void handleTrade(Trade trade) {
        tradeService.processTrade(trade);
    }
}
