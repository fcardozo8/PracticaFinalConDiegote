package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.function.Predicate;

import dominio.Gestor;

import dominio.Persona;

class Test {
	
	private ArrayList<Persona> personasFiltradas = new ArrayList<Persona>();
	private static Gestor gestor = Gestor.getInstancia();

	@org.junit.jupiter.api.Test
	void test_gestorInstancia() {
		Gestor gp1 = Gestor.getInstancia();
		Gestor gp2 = Gestor.getInstancia();
		
		assertTrue(gp1.equals(gp2));
		assertTrue(gp1==gp2);
	}
	
	@org.junit.jupiter.api.Test
	void testEqualsPersona() {
		Persona p1= new Persona("Jacinto","Villalobos","5266552");
		Persona p2= new Persona("Jacinto","Villalobos","1277455");
		
		
		assertEquals(p1,p2);
		
	}
	
	@org.junit.jupiter.api.Test
	void testEqualsPersona2() {
		Persona p1= new Persona("Ja","Villalobos","1277455");
		Persona p2= new Persona("Jacinto","Villalobos","1277455");
		
		
		assertNotEquals(p1,p2);
		
	}
	@org.junit.jupiter.api.Test
	void testAddPersona() {
		Gestor gp1= Gestor.getInstancia();
		gp1.clearPersonas();
		
		Persona p1= new Persona("Ja","Villalobos","1277455");
		Persona p2= new Persona("Jacinto","Villalobos","1277455");

		gp1.addPersona(p1);
		gp1.addPersona(p2);
		
		assertEquals(2,gp1.cantidadPersonas());
		
		
		
	}
	@org.junit.jupiter.api.Test
	void testAddPersona2() {
		
		Gestor gp1= Gestor.getInstancia();
		gp1.clearPersonas();
		
		Persona p1= new Persona("Jacinto","Villalobos","1277455");
		Persona p2= new Persona("Jacinto","Villalobos","1277455");

		gp1.addPersona(p1);
		gp1.addPersona(p2);
		
		assertEquals(1,gp1.cantidadPersonas());
		
		
	}
	
	@org.junit.jupiter.api.Test
	void testbuscarPersonaPorApellido() {
		
		Gestor gp1= Gestor.getInstancia();
		gp1.clearPersonas();
		
		Persona p1= new Persona("Esteban","VillaManaos","1277455");
		Persona p2= new Persona("Jacinto","Villalobos","1277455");

		gp1.addPersona(p1);
		gp1.addPersona(p2);
		
		Predicate<Persona> p = new Predicate<Persona>() {
			@Override
			public boolean test(Persona p) {
				return p.getApellido().matches("Villa") ;
				
			}	
		};	
		
		
		
		personasFiltradas = gestor.buscarPersona(p);
		assertEquals(2,personasFiltradas.size());
		ArrayList<Persona> aux = gestor.buscarPersona(s -> s.getApellido().contains("Villa"));
		

		
		
	}
	
	

}
