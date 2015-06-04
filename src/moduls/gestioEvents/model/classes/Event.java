/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioEvents.model.classes;

import classes.Data;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

/**
 *
 * @author Vicent
 */
@XStreamAlias("Event")
public class Event implements Comparable<Event>, Serializable {

    @XStreamAlias("idevent")
    private int idevent;
    @XStreamAlias("login")
    private String login;
    @XStreamAlias("tipusevent")
    private String tipusevent;
    @XStreamAlias("dataidevent")
    private Data dataidevent;    
    @XStreamAlias("dataevent")
    private Data dataevent;
    @XStreamAlias("observacionsevent")
    private String observacionsevent;

    public Event(int idevent, String login, String tipusevent, Data dataidevent, Data dataevent, String observacionsevent) {
        this.idevent = idevent;
        this.login = login;
        this.tipusevent = tipusevent;
        this.dataidevent = dataidevent;
        this.dataevent = dataevent;
        this.observacionsevent = observacionsevent;
    }

    public Event(int idevent) {
        this.idevent = idevent;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTipusevent() {
        return tipusevent;
    }

    public void setTipusevent(String tipusevent) {
        this.tipusevent = tipusevent;
    }

    public Data getDataidevent() {
        return dataidevent;
    }

    public void setDataidevent(Data dataidevent) {
        this.dataidevent = dataidevent;
    }

    public Data getDataevent() {
        return dataevent;
    }

    public void setDataevent(Data dataevent) {
        this.dataevent = dataevent;
    }

    public String getObservacionsevent() {
        return observacionsevent;
    }

    public void setObservacionsevent(String observacionsevent) {
        this.observacionsevent = observacionsevent;
    }

    @Override
    public int compareTo(Event evnt) {// para ordenar
        if (this.getLogin().compareTo(evnt.getLogin()) > 0) {
            return 1;
        }
        if (this.getLogin().compareTo(evnt.getLogin()) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object e) {        
        return getLogin().equals(((Event) e).getLogin());    
    }

    @Override
    public String toString() {
        return "Event{" + "idevent=" + idevent + ", login=" + login + ", tipusevent=" + tipusevent + ", dataidevent=" + dataidevent + ", dataevent=" + dataevent + ", observacionsevent=" + observacionsevent + '}';
    }



}
