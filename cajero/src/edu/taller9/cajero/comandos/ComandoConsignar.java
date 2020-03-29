package edu.taller9.cajero.comandos;

import java.util.Scanner;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

/**
 * Comando usado para consignar dinero
 */
public class ComandoConsignar implements OperacionCuenta {

	@Override
	public String getNombre() {
		return "Consignar dinero";
	}

	@SuppressWarnings("resource")
	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta cuenta) throws Exception {
		
		System.out.println("Consignación de Dinero");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		Scanner console = new Scanner(System.in);			
		
		System.out.println("Ingrese el valor a consignar");
		String valor = console.nextLine();
	
		try {
			long valorNumerico = Long.parseLong(valor);
			cuenta.consignar(valorNumerico);
			System.out.println("\n====================================");
			System.out.println("      Su nuevo saldo es de "+cuenta.getSaldo());
			System.out.println("====================================");
			System.out.println();
		} catch (NumberFormatException e) {
			throw new Exception("Valor a consignar no válido : " + valor);
		}
		return cuenta;
	}

}
