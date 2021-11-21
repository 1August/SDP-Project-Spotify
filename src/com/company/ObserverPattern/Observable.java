package com.company.ObserverPattern;

public interface Observable {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObserver();


}
