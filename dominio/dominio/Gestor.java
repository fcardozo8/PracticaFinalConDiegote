package dominio;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Gestor {
	private static Gestor gestor;
	private ArrayList<Persona> misPersonas;

	private Gestor() {
		misPersonas = new ArrayList<Persona>();
	}
	public static Gestor getInstancia() {
		if(gestor==null) gestor = new Gestor();
		return gestor;
	}
	
	public boolean addPersona(Persona p) {
		if(!YaEstaCargada(p))
			return misPersonas.add(p);
		return true;
	}
	
	public boolean addPersona(String nombre,String apellido,String dni  ) {
		Persona aux= new Persona(nombre,apellido,dni);
		if(!YaEstaCargada(aux))
			return misPersonas.add(aux);
		return true;
	}
	private boolean YaEstaCargada(Persona p) {
	
		return misPersonas.stream().filter(p2->p2.equals(p)).count()>0;
	}
	
	public int cantidadPersonas() {
		
		return misPersonas.size();
	}
	
	public void clearPersonas() {
		misPersonas = new ArrayList<Persona>() ;

    }
	
//	public static ArrayList<Persona> buscarPersona(String parteApellido){
//		
//		return misPersonas.stream().filter(apellido-> apellido.); 
//	}
	
//	public ArrayList<Persona> getPersonasxParteApellido(String parteApellido) {
//        Predicate <Persona> m = p -> p.getApellido().contains(parteApellido).;
////        gp.getProductos().stream().filter(m).forEach(System.out::println);
////        return gp.getProductos().stream().filter(m).count();
//        return (ArrayList<Persona>) this.misPersonas.stream().filter(m).collect(Collectors.toList());
//
//    }
	
	public ArrayList<Persona> buscarPersona(String parteApellido) {
//		return misPersonas.stream().filter(p).collect(Collectors.toCollection(ArrayList<Persona>::new));
		//		library.stream()
//				.map(book -> book.getAuthor())
//				.filter(author -> author.getAge() >= 50)
//				.distinct()
//				.limit(15)
//				.map(Author::getSurname)
//				.map(String::toUpperCase)
//				.collect(toList());
		return (ArrayList<Persona>) misPersonas.stream()
				.filter(p -> p.getApellido().contains(parteApellido))
				.collect(Collectors.toList());
	}

}



