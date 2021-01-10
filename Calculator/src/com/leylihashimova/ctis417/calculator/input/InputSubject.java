package com.leylihashimova.ctis417.calculator.input;

import java.util.ArrayList;

public class InputSubject {
    private final ArrayList<InputObserver> observers = new ArrayList<>();

    public void registerObserver(InputObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(InputObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String input) {
        for (var obs : observers) {
            if (obs != null) {
                obs.updateInput(input);
            }
        }
    }
}
