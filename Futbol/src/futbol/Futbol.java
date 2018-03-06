/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol;

import java.util.ArrayList;

/**
 *
 * @author erick galindo chavez
 */

abstract class SeleccionFutbol {

	protected int id;
	protected String nombre;
	protected String apellidos;
	protected int edad;

	public SeleccionFutbol() {
	}

	public SeleccionFutbol(int id, String nombre, String apellidos, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void viajar() {
		System.out.println("Viajar (Clase Padre)");
	}

	public void concentrarse() {
		System.out.println("Concentrarse (Clase Padre)");
	}

	// IMPORTANTE -> METODO ABSTRACTO => no se implementa
	// en la clase abstracta pero si en la clases hijas
	public abstract void entrenamiento();

	public void partidoFutbol() {
		System.out.println("Asiste al Partido de Fútbol (Clase Padre)");
	}

}

class Entrenador extends SeleccionFutbol {

	private int idFederacion;

	public Entrenador() {
		super();
	}

	public Entrenador(int id, String nombre, String apellidos, int edad, int idFederacion) {
		super(id, nombre, apellidos, edad);
		this.setIdFederacion(idFederacion);
	}

	public int getIdFederacion() {
		return idFederacion;
	}

	public void setIdFederacion(int idFederacion) {
		this.idFederacion = idFederacion;
	}
	
	@Override
	public void entrenamiento() {
		System.out.println("Dirige un entrenamiento (Clase Entrenador)");
	}

	@Override
	public void partidoFutbol() {
		System.out.println("Dirige un Partido (Clase Entrenador)");
	}

	public void planificarEntrenamiento() {
		System.out.println("Planificar un Entrenamiento");
	}

}

class Futbolista extends SeleccionFutbol {

	private int dorsal;
	private String demarcacion;

	public Futbolista() {
		super();
	}

	public Futbolista(int id, String nombre, String apellidos, int edad, int dorsal, String demarcacion) {
		super(id, nombre, apellidos, edad);
		this.dorsal = dorsal;
		this.demarcacion = demarcacion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}

	@Override
	public void entrenamiento() {
		System.out.println("Realiza un entrenamiento (Clase Futbolista)");
	}

	@Override
	public void partidoFutbol() {
		System.out.println("Juega un Partido (Clase Futbolista)");
	}

	public void entrevista() {
		System.out.println("Da una Entrevista");
	}

}


class Masajista extends SeleccionFutbol {

	private String titulacion;
	private int aniosExperiencia;

	public Masajista() {
		super();
	}

	public Masajista(int id, String nombre, String apellidos, int edad, String titulacion, int aniosExperiencia) {
		super(id, nombre, apellidos, edad);
		this.titulacion = titulacion;
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	
	@Override
	public void entrenamiento() {
		System.out.println("Da asistencia en el entrenamiento (Clase Masajista)");
	}

	public void darMasaje() {
		System.out.println("Da un Masaje");
	}

}



public class Futbol {

    /**
     * @param args the command line arguments
     */
    // ArrayList de objetos SeleccionFutbol. Idenpendientemente de la clase hija a la que pertenezca el objeto
	public static ArrayList<SeleccionFutbol> integrantes = new ArrayList<SeleccionFutbol>();

	public static void main(String[] args) {
		
                    SeleccionFutbol zidane = new Entrenador(1, "Enzo", "Zidane", 30, 00012);
		SeleccionFutbol cristiano = new Futbolista(2, "Cristiano", "Ronaldo", 33, 8, "Extremo izquierdo");
		SeleccionFutbol Mourinho = new Masajista(3, "David", "Mourinho", 28, "Licenciado en Fisioterapia", 18);

		integrantes.add(zidane);
		integrantes.add(cristiano);
		integrantes.add(Mourinho);

		// CONCENTRACION
		System.out.println("Todos los integrantes comienzan una concentracion. (Todos ejecutan el mismo método)");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.print(integrante.getNombre() + " " + integrante.getApellidos() + " -> ");
			integrante.concentrarse();
		}

		// VIAJE
		System.out.println("\nTodos los integrantes viajan para jugar un partido. (Todos ejecutan el mismo método)");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.print(integrante.getNombre() + " " + integrante.getApellidos() + " -> ");
			integrante.viajar();
		}

		// ENTRENAMIENTO
		System.out.println("\nEntrenamiento: Todos los integrantes tienen su función en un entrenamiento (Especialización)");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.print(integrante.getNombre() + " " + integrante.getApellidos() + " -> ");
			integrante.entrenamiento();
		}

		// PARTIDO DE FUTBOL
		System.out.println("\nPartido de Fútbol: Todos los integrantes tienen su función en un partido (Especialización)");
		for (SeleccionFutbol integrante : integrantes) {
			System.out.print(integrante.getNombre() + " " + integrante.getApellidos() + " -> ");
			integrante.partidoFutbol();
		}

		// PLANIFICAR ENTRENAMIENTO
		System.out.println("\nPlanificar Entrenamiento: Solo el entrenador tiene el método para planificar un entrenamiento:");
		System.out.print(zidane.getNombre() + " " + zidane.getApellidos() + " -> ");
		((Entrenador) zidane).planificarEntrenamiento();

		// ENTREVISTA
		System.out.println("\nEntrevista: Solo el futbolista tiene el método para dar una entrevista:");
		System.out.print(cristiano.getNombre() + " " + cristiano.getApellidos() + " -> ");
		((Futbolista) cristiano).entrevista();

		// MASAJE
		System.out.println("\nMasaje: Solo el masajista tiene el método para dar un masaje:");
		System.out.print(Mourinho.getNombre() + " " + Mourinho.getApellidos() + " -> ");
		((Masajista) Mourinho).darMasaje();

	}
    
}
