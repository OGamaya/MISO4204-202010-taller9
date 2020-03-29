package edu.taller9.cajero.comandos;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

/**
 * Comando usado para listar las cuentas 
 */
public class ComandoListarCuentas implements Comando {

	@Override
	public String getNombre() {
		return "Listar Cuentas";
	}

	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta actual) throws Exception {
		
		System.out.println("Listado de Cuentas");
		System.out.println();
	
		for (Cuenta cuenta : contexto.getCuentas()) {
			System.out.println(cuenta.getCedula() + " : $ " + cuenta.getSaldo());
		}

		return actual;
	}

}
