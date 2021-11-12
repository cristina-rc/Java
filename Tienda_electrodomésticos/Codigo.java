package TiendaElectrodomesticos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Codigo {

	private String codigo;
	
	
	public Codigo (String codigo){
				
			if(codigoCorrecto(codigo)) {
				
				this.codigo = codigo;
				
			}else {
				
				System.out.println("El c�digo no es correcto, debe contener letras may�sculas y/o n�meros");
			}
	}
	
	
	public boolean codigoCorrecto(String codigoIntroducido) {
		
		Pattern p=Pattern.compile("[A-Z0-9]{8}");
		Matcher m=p.matcher(codigoIntroducido);
		if(m.matches()) {
			
			return true;
			
		}else {
			
			return false;
		}
			
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return codigo;
	}
	
	
}
