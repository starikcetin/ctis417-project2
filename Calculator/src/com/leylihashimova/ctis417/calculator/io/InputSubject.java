package com.leylihashimova.ctis417.calculator.io;

import com.leylihashimova.ctis417.calculator.CalculatorException;

import java.util.ArrayList;
import java.util.Objects;

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
            if(obs != null) {
                obs.updateInput(input);
            }
        }
    }
}
