package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Block {
    public static final int MAX = 7;
    private final Timer timer;
    private int x;
    private int y ;
    private final List<Observer> observers = new ArrayList<Observer>();


    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.timer = new Timer();
        this.timer.schedule(task(),1000,500);
    }



    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void left(){
        if (x == 1)return ;
        x--;
        change();
    }

    public void right(){
        if(x == MAX) return;
        x++;
        change();
    }

    public void down(){
        if (y == 1)return ;
        y--;
        change();
    }

    public void up(){
        if(y == MAX) return;
        y++;
        change();
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
        change();
    }

    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                double r = Math.random();
                if(r> 0.4)return;
                else if ( r>.3) up();
                else if ( r>.2) down();
                else if ( r>.1) left();
                else right();
            }
        };
    }

    public void register(Observer observer){
        observers.add(observer);
    }

    private void change() {
        for(Observer observer : observers)
            observer.change();

    }



    public interface Observer {
        void change();
    }
}
