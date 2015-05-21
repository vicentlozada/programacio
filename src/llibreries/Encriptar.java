/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llibreries;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Vicent
 */
public class Encriptar {
    
    
    	public static String encriptarTokenMD5(String name){
            String cadena_encriptada = DigestUtils.md5Hex(name);
            return cadena_encriptada;
	}
	
	public static boolean validarTokenMD5(String cadena, String cadena_encriptada){
		if(encriptarTokenMD5(cadena).equals(cadena_encriptada))
			return true;
		return false;
	}
}
