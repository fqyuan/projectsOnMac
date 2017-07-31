package com.fqy.observer;

public interface Subject {
	public void register(Observer obs);

	public void unregister(Observer obs);

	public void notifyObserver();
}
