package moduls.gestioEmpleats.gestioET.model.classes;

import java.util.Comparator;
import moduls.gestioEmpleats.classes.Empleat;

public class OrdenaEdat implements Comparator<Empleat>{

	public int compare(Empleat e1, Empleat e2) {
		if(e1.getEdat()>(e2.getEdat()))
			return 1;
		if(e1.getEdat()<(e2.getEdat()))
			return -1;
		return 0;
		}
	
}
