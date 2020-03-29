package edu.taller9.cajero;

import java.util.List;
import java.util.Scanner;

import edu.taller9.cajero.comandos.Comando;
import edu.taller9.cajero.comandos.IniciarSesion;
import edu.taller9.cajero.fabricas.FabricaComandosCajero;
import edu.taller9.cajero.fabricas.FabricaOperacinesCuenta;
import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

/**
 * Simulador de un Cajero de Banco
 */
public class Cajero {
	
	/**
	 * Programa principal
	 * @param args parámetros de línea de comandos. Son ignorados por el programa.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		// crea el banco
		Banco banco = new Banco();
		
		Cuenta clienteActual = null;
		
		// crea unas cuentas, para la prueba
		banco.agregarCuenta(new Cuenta("1", "1", 1000000));
		banco.agregarCuenta(new Cuenta("2", "2", 2000000));
		banco.agregarCuenta(new Cuenta("3", "3", 3000000));
		
		// crea los comandos que se van a usar en la aplicación
		List<Comando> comandos = FabricaComandosCajero.creaComandos();
		
		
		// Ciclo del Programa
		// ==================

		System.out.println("Cajero Autom�tico");
		System.out.println("=================");
		System.out.println();
		
		boolean fin = false;
		boolean hayCliente = false;
		do {
			
			// muestra los nombres de los comandos
			muestraMenuConComandos(comandos);
			System.out.println("X.- Salir");
			
			// la clase Console no funciona bien en Eclipse
			Scanner console = new Scanner(System.in);			
			String valorIngresado = console.nextLine();
			
			// obtiene el comando a ejecutar
			Comando comandoSeleccionado = retornaComandoSeleccionado(comandos, valorIngresado);
			if (comandoSeleccionado != null) {
				
				// intenta ejecutar el comando
				try {
					clienteActual = comandoSeleccionado.ejecutar(banco, clienteActual);
					if (comandoSeleccionado instanceof IniciarSesion) {
						hayCliente = true;
						comandos = FabricaOperacinesCuenta.creaComandos();
					}
					
				} catch (Exception e) {
					// si hay una excepción, muestra el mensaje
					System.err.println(e.getMessage());
				}
				
			} 
			// si no se obtuvo un comando, puede ser la opción de salir
			else if (valorIngresado.equalsIgnoreCase("X")) {
				if (hayCliente) {
					comandos = FabricaComandosCajero.creaComandos();
					clienteActual = null;
					hayCliente = false;
				} else {
					fin = true;
				}
			}
			
			System.out.println();
		} while ( !fin );
		
		System.out.println("Gracias por usar el programa.");
	}
	
	
	// Muestra el listado de comandos, para mostrar un menú al usuario
	// muestra el índice en el arreglo de comandos y el nombre del comando
	private static void muestraMenuConComandos(List<Comando> comandos) {
		System.out.println("**********************************************\n");
		// muestra los nombres de los comandos 
		for (int i=0; i < comandos.size(); i++) {
			System.out.println(i + ".-" + comandos.get(i).getNombre());
		}
	}
	
	
	// dado el texto ingresado por el usuario, retorna el comando correspondiente
	// retorna null si el texto no es un número o no existe ningún comando con ese índice
	private static Comando retornaComandoSeleccionado(List<Comando> comandos, String valorIngresado) {
		
		Comando comandoSeleccionado = null;
		
		// el valorIngresado es un número ?
		if (valorIngresado.matches("[0-9]")) {			
			int valorSeleccionado = Integer.valueOf(valorIngresado);
			// es un índice válido para la lista de comandos
			if (valorSeleccionado < comandos.size()) {
				comandoSeleccionado = comandos.get(valorSeleccionado);
			}
		}
		
		return comandoSeleccionado;
	}
	
}
