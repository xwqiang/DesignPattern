package com.designPattern.oberver1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Observable;
import java.util.Observer;

public class BigBuyer implements Observer {
	private String symbol;
	private float close;
	private float high;
	private float low;
	private long volume;

	public BigBuyer(Observable observable) {
		observable.addObserver(this); // ×¢²á¹ØÏµ
	}

	public void update(Observable observable, Object args) {
		if (observable instanceof StockData) {
			StockData stockData = (StockData) observable;
			this.symbol = stockData.getSymbol();
			this.close = stockData.getClose();
			this.high = stockData.getHigh();
			this.low = stockData.getLow();
			this.volume = stockData.getVolume();
			System.out.println("big buyer ...");
//			display();
		}
	}

	public void display() {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		DecimalFormat volumeFormat = new DecimalFormat("###,###,###,###", dfs);
		DecimalFormat priceFormat = new DecimalFormat("###.00", dfs);
		System.out.println("Big Buyer reports... ");
		System.out.println("\tThe lastest stock quote for " + symbol + " is:");
		System.out.println("\t$" + priceFormat.format(close)
				+ " per share (close).");
		System.out.println("\t$" + priceFormat.format(high)
				+ " per share (high).");
		System.out.println("\t$" + priceFormat.format(low)
				+ " per share (low).");
		System.out.println("\t" + volumeFormat.format(volume)
				+ " shares traded.");
		System.out.println();
	}
}
