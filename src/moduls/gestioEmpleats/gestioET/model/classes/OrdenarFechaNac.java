package moduls.gestioEmpleats.gestioET.model.classes;

import java.util.Comparator;
import moduls.gestioEmpleats.classes.Empleat;

public class OrdenarFechaNac implements Comparator<Empleat>{

	public int compare(Empleat e1, Empleat e2) {
		if(e1.getDatanaixement().comparaData(e2.getDatanaixement())>0)
			return 1;
		if(e1.getDatanaixement().comparaData(e2.getDatanaixement())<0)
			return -1;
		return 0;
		}
	
}
