package main.circuits;

import main.signals.Signal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by King on 2014-12-13.
 */
public class Circuit {

    private ArrayList<Porte> portes;
    private ArrayList<Signal> signals;

    public Circuit(){
        portes = new ArrayList<Porte>();
        signals = new ArrayList<Signal>();
    }

    public void addSignal(Signal s){
        signals.add(s);
    }

    public void addPorte(Porte p){
        portes.add(p);
    }

    /*public void simule(int tMax){

    }*/

    public void actualiseSignals(){
        for (Signal s : signals){
            s.actualise();
        }
    }

    public void activatePortes(){
        for (Porte p : portes){
            p.activate();
        }
    }

    public ArrayList<Signal> getSignals(){
        return signals;
    }

}
