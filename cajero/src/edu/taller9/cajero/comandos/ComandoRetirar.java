package edu.taller9.cajero.comandos;

import java.util.Scanner;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

/**
 * Comando usado para retirar dinero
 */
public class ComandoRetirar implements OperacionCuenta {

	@Override
	public String getNombre() {
		return "Retirar dinero";
	}

	@SuppressWarnings("resource")
	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta cuenta) throws Exception {
		
		System.out.println("Retiro de Dinero");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		Scanner console = new Scanner(System.in);			
		
		System.out.println("Ingrese el valor a retirar");
		String valor = console.nextLine();
	
		try {
			long valorNumerico = Long.parseLong(valor);
			cuenta.retirar(valorNumerico);
			System.out.println("\n====================================");
			System.out.println("      Su nuevo saldo es de "+cuenta.getSaldo());
			System.out.println("====================================");
		} catch (NumberFormatException e) {
			throw new Exception("Valor a retirar no válido : " + valor);
		}
		return cuenta;
	}

}
