package moduls.gestioEmpleats.gestioET.model.classes;

import java.util.Comparator;
import moduls.gestioEmpleats.classes.Empleat;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;

public class OrdenaSalari implements Comparator<Empleat>{
	
	public int compare(Empleat e1, Empleat e2) {
		if(((EmpleatFix)e1).getSou()>(((EmpleatFix)e2).getSou()))
			return 1;
		if(((EmpleatFix)e1).getSou()<(((EmpleatFix)e2).getSou()))
			return -1;
		return 0;
		}

}
