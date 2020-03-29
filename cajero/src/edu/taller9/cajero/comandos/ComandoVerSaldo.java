package edu.taller9.cajero.comandos;

import java.util.Scanner;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

/**
 * Comando usado para consignar dinero
 */
public class ComandoVerSaldo implements OperacionCuenta {

	@Override
	public String getNombre() {
		return "Consultar saldo";
	}

	@SuppressWarnings("resource")
	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta cuenta) throws Exception {
		
		System.out.println("\n====================================");
		System.out.println("      Su saldo es de: "+cuenta.getSaldo());
		System.out.println("====================================");
		System.out.println();
		return cuenta;
	}

}
