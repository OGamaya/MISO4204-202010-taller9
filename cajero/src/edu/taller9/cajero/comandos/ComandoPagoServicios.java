package edu.taller9.cajero.comandos;

import java.util.Scanner;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

public class ComandoPagoServicios implements OperacionCuenta {

	@Override
	public String getNombre() {
		return "Pagar servicios";
	}

	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta cuenta) throws Exception {
		System.out.println("Pago de Servicios Públicos");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		Scanner console = new Scanner(System.in);			
		
		// Ingresa los datos
		System.out.println("Ingrese el servicio que va a pagar (Gas, Luz, Agua)");
		String numeroCuentaDestino = console.nextLine();
		
				
		System.out.println("Ingrese el valor a pagar");
		String valor = console.nextLine();
	
		try {
			
			// se retira el pago de la cuenta
			
			long valorNumerico = Long.parseLong(valor);
			cuenta.retirar(valorNumerico);
			System.out.println("\n====================================");
			System.out.println("      Pago realizado exitosamente");
			System.out.println("====================================");
			System.out.println();
			return cuenta;
		} catch (NumberFormatException e) {
			throw new Exception("Valor a transferir no válido : " + valor);
		}
	}

}
