package edu.taller9.cajero.comandos;

import java.util.ArrayList;

import edu.taller9.cajero.LogOperaciones;
import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

public class ReporteListaOperaciones implements ComandoCajero {

	@Override
	public String getNombre() {
		return "Reporte de operaciones";
	}

	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta cuenta) throws Exception {

		System.out.println("Reporte de operaciones");
		for (String op : LogOperaciones.getOperations()) {
			System.out.println("\n========================================================================");
			System.out.println(op);
		}
		System.out.println("\nFin Reporte de operaciones");
		System.out.println("########################################################################=");
		
		return cuenta;
	}

}
