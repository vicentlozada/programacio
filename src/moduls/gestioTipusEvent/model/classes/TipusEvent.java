/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls.gestioTipusEvent.model.classes;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

/**
 *
 * @author Vicent
 */
@XStreamAlias("TipusEvent")
public class TipusEvent implements Comparable<TipusEvent>, Serializable {

    @XStreamAlias("tipusevent")
    private String tipusevent;

    public TipusEvent(String tipusevent) {
        this.tipusevent = tipusevent;
    }

    public String getTipusevent() {
        return tipusevent;
    }

    public void setTipusevent(String tipusevent) {
        this.tipusevent = tipusevent;
    }


    @Override
    public int compareTo(TipusEvent te) {// para ordenar los empleados
        if (this.getTipusevent().compareTo(te.getTipusevent()) > 0) {
            return 1;
        }
        if (this.getTipusevent().compareTo(te.getTipusevent()) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object c) {
        return getTipusevent().equals(((TipusEvent) c).getTipusevent());
    }

    @Override
    public String toString() {
        return "TipusEvent{" + "tipusevent=" + tipusevent + '}';
    }
   

}
