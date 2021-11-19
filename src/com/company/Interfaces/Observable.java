package com.company.Interfaces;

public interface Observable {
    void register(Observer observer);
    void unregister( Observer observer);
    void notifyObserver();
}
