package notes.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final static int MAX = 10;
    private final static int DEFAULT = 5;
    private int aNumber = DEFAULT;
    List<Observer> aObservers = new ArrayList<>();

    void setNumber(int pNumber){
        if (pNumber < 1){
            aNumber = 1;
        }
        else if (pNumber > MAX){
            aNumber = MAX;
        }
        else {
            aNumber = pNumber;
        }
        notifyObservers();
    }

    int getNumber(){
        return aNumber;
    }

    void addObserver(Observer pObserver){
        assert pObserver != null;
        aObservers.add(pObserver);
        notifyObservers();
    }

    private void notifyObservers(){
        for (Observer observer: aObservers){
            observer.numberSelected(aNumber);
        }
    }

}
