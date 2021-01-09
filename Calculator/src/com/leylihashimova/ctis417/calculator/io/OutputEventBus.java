package com.leylihashimova.ctis417.calculator.io;

import java.util.ArrayList;
import java.util.Objects;

public class OutputEventBus {
    private static OutputEventBus instance;

    private OutputEventBus() {}

    public static synchronized OutputEventBus getInstance() {
        if(instance == null) {
            instance = new OutputEventBus();
        }

        return instance;
    }

    private final ArrayList<IOutputEventListener> listeners = new ArrayList<>();

    public void addListener(IOutputEventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(IOutputEventListener listener) {
        listeners.remove(listener);
    }

    public void emit(String output) {
        listeners.stream().filter(Objects::nonNull).forEach(x -> x.onOutput(output));
    }
}
