package com.example.websocketbinancesampleservice.service;

import com.example.websocketbinancesampleservice.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeService.class);

    public void processTrade(Trade trade) {
        LOGGER.info("Processing trade: {}", trade.toString());
        // Perform any business logic on the trade
    }
}
