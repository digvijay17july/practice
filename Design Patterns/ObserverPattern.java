

import java.util.ArrayList;
import java.util.List;

/*
Implementation to change state in observable state and notify observers
 */
class Scratch {
    public static void main(String[] args) {
        Subject subject=new Subject();
        Observer observerOne=new SolidStateObserver(subject);
        Observer observerTwo=new LiquidStateObserver(subject);
        Observer observerThree=new GasStateObserver(subject);
        subject.setState("Semi Liquid");
    }
}
/*
Observer abstract class containing the subject as well as update method
 */
abstract class   Observer{
    protected Subject SUBJECT;
    abstract void update();
}
/*
subject class acting as Observable object
 */
class Subject{
  private List<Observer> observers;
  private String state;

    public Subject() {
        this.observers=new ArrayList<>();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        this.notifyAllObservers();
    }
    void notifyAllObservers(){
        observers.forEach(observer -> {
            observer.update();
        });
    }
    void attach(Observer observer){
        this.observers.add(observer);
    }

}
/*
Observer one
 */
class SolidStateObserver extends Observer{

    public SolidStateObserver(Subject subject) {
    this.SUBJECT=subject;
    this.SUBJECT.attach(this);
    }

    @Override
    void update() {
        System.out.println("Solid state is changed to "+this.SUBJECT.getState());
    }
}
/*
Observer Two
 */
class LiquidStateObserver extends Observer{

    public LiquidStateObserver(Subject subject) {
        this.SUBJECT=subject;
        this.SUBJECT.attach(this);
    }

    @Override
    void update() {
        System.out.println("Liquid subject is changed to "+this.SUBJECT.getState());
    }
}
/*
Observer Three
 */
class GasStateObserver extends Observer{

    public GasStateObserver(Subject subject) {
        this.SUBJECT=subject;
        this.SUBJECT.attach(this);
    }

    @Override
    void update() {
        System.out.println("Gas subject is changed to "+this.SUBJECT.getState());
    }
}
