package com.designPattern.oberver1;

import java.util.Observable;

public class StockData extends Observable {
	private String symbol;
	private float close;
	private float high;
	private float low;
	private long volume;

	public StockData() {
	}

	public String getSymbol() {
		return symbol;
	}

	public float getClose() {
		return close;
	}

	public float getHigh() {
		return high;
	}

	public float getLow() {
		return low;
	}

	public long getVolume() {
		return volume;
	}

	public void sendStockData() {
		setChanged();
		notifyObservers();
	}

	public void setStockData(String symbol, float close, float high, float low,
			long volume) {
		this.symbol = symbol;
		this.close = close;
		this.high = high;
		this.low = low;
		this.volume = volume;
		sendStockData();
	}
}