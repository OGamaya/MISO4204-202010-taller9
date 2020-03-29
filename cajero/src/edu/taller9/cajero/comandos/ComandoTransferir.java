package edu.taller9.cajero.comandos;

import java.util.Scanner;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

/**
 * Comando usado para transferir dinero entre cuentas
 */
public class ComandoTransferir implements OperacionCuenta {

	@Override
	public String getNombre() {
		return "Transferir dinero";
	}

	@SuppressWarnings("resource")
	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta cuentaOrigen) throws Exception {
		
		System.out.println("Transferencia de Dinero");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		Scanner console = new Scanner(System.in);			
		
		// Ingresa los datos
		System.out.println("Ingrese el nümero de cuenta destino");
		String numeroCuentaDestino = console.nextLine();
		
		Cuenta cuentaDestino = contexto.buscarCuenta(numeroCuentaDestino);
		if (cuentaDestino == null) {
			throw new Exception("No existe cuenta con el nümero " + numeroCuentaDestino);
		}
		
		System.out.println("Ingrese el valor a transferir");
		String valor = console.nextLine();
	
		try {
			
			// se retira primero y luego se consigna
			// si no se puede retirar, no se hace la consignaciÃ³n
			
			long valorNumerico = Long.parseLong(valor);
			cuentaOrigen.retirar(valorNumerico);
			cuentaDestino.consignar(valorNumerico);
			System.out.println("\n====================================");
			System.out.println("      Transacción exitosa");
			System.out.println("====================================");
		} catch (NumberFormatException e) {
			throw new Exception("Valor a transferir no válido : " + valor);
		}
		return cuentaOrigen;
	}

}
