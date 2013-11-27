package com.designPattern.oberver1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Observable;
import java.util.Observer;

public class TradingFool implements Observer {
	private String symbol;
	private float close;

	public TradingFool(Observable observable) {
		observable.addObserver(this);// ×¢²á¹ØÏµ
	}

	public void update(Observable observable, Object args) {
		if (observable instanceof StockData) {
			StockData stockData = (StockData) observable;
			this.symbol = stockData.getSymbol();
			this.close = stockData.getClose();
//			display();
			System.out.println("trading fool");
		}
	}

	public void display() {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		DecimalFormat priceFormat = new DecimalFormat("###.00", dfs);
		System.out.println("Trading Fool says... ");
		System.out.println("\t" + symbol + " is currently trading at $"
				+ priceFormat.format(close) + " per share.");
		System.out.println();
	}
}