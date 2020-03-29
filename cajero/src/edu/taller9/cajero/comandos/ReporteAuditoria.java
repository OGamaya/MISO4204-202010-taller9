package edu.taller9.cajero.comandos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.taller9.cajero.LogOperaciones;
import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

public class ReporteAuditoria implements ComandoCajero {

	@Override
	public String getNombre() {
		return "Reporte de Auditoría";
	}

	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta cuenta) throws Exception {
		System.out.println("Reporte de Auditoría");
		Map<String, List<String>> operaciones = LogOperaciones.getAudith();
		for (Map.Entry<String, List<String>> entry : operaciones.entrySet()) {
			System.out.println("\n========================================================================");
			System.out.println("     Cedula -> " + entry.getKey());
			System.out.println("========================================================================");
			for (String op : entry.getValue()) {
				System.out.println(op);
				System.out.println("*************************");
			}
			System.out.println("========================================================================");
		}
		System.out.println("\nFin Reporte de Auditoría");
		System.out.println("########################################################################");
		return cuenta;
	}

}
