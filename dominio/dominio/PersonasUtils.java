package dominio;

import java.util.function.Predicate;

public class PersonasUtils {
	public static Predicate<Persona> filtroApellido(String parteApellido){
		
		return (Persona p) ->  {
			return p.getApellido().equals(parteApellido);
		};
	}

}
