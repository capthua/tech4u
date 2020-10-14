package me.ffulauh.javalang.cglib.officialsamples;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

public abstract class Bean implements Serializable {

    String sampleProperty;

    abstract public void addPropertyChangeListener(PropertyChangeListener listener);

    abstract public void removePropertyChangeListener(PropertyChangeListener listener);

    public String getSampleProperty(){
        return sampleProperty;
    }

    public void setSampleProperty(String value){
        this.sampleProperty = value;
    }

    @Override
    public String toString(){
        return "sampleProperty is " + sampleProperty;
    }
}
