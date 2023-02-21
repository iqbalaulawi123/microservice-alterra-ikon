package com.example.websocketbinancesampleservice.model;

public class Trade {
    private String eventType;
    private Long eventTime;
    private String symbol;
    private Long tradeId;
    private Double price;
    private Double quantity;
    private Long tradeTime;
    private Boolean buyerMaker;

    // Constructor, getters and setters omitted for brevity

    @Override
    public String toString() {
        return "Trade{" +
                "eventType='" + eventType + '\'' +
                ", eventTime=" + eventTime +
                ", symbol='" + symbol + '\'' +
                ", tradeId=" + tradeId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", tradeTime=" + tradeTime +
                ", buyerMaker=" + buyerMaker +
                '}';
    }
}
