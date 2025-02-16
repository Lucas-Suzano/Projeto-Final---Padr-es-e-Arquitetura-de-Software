package observer;

import java.util.ArrayList;
import java.util.List;

public class ProgramObserver {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.notify(message);
        }
    }
}
