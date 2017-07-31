package com.fqy.observer;

import java.util.ArrayList;

//Use the subject interface to update all Observers.
public class StockGrabber implements Subject {
	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;

	public StockGrabber() {
		// Create an ArrayList to hold all observers.
		observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void unregister(Observer obs) {
		// Get the index of the obs to delete
		int observerIndex = observers.indexOf(obs);
		// Print out the msg: +1 to match common knowledge
		System.out.println("Observer " + (observerIndex + 1) + " deleted.");
		// Remove observer from the ArrayList
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObserver() {
		// Cycle through all observers and notify them of price changes
		for (Observer observer : observers) {
			observer.update(ibmPrice, aaplPrice, googPrice);
		}
	}

	// Change prices for all stocks and notifies observers of changes
	public void setIBMPrice(double newIBMPrice) {
		this.ibmPrice = newIBMPrice;
		notifyObserver();
	}

	public void setAAPLPrice(double newAAPLPrice) {
		this.aaplPrice = newAAPLPrice;
		notifyObserver();
	}

	public void setGOOGPrice(double newGOOGPrice) {
		this.googPrice = newGOOGPrice;
		notifyObserver();
	}
}
