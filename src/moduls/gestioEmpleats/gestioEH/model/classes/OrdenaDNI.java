package moduls.gestioEmpleats.gestioEH.model.classes;

import java.util.Comparator;
import moduls.gestioEmpleats.classes.Empleat;

public class OrdenaDNI implements Comparator<Empleat> {

	public int compare(Empleat e1, Empleat e2) {
		if(e1.getDni().compareTo(e2.getDni())>0)
			return 1;
		if(e1.getDni().compareTo(e2.getDni())<0)
			return -1;
		return 0;
		}

}
