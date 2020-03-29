package edu.taller9.cajero.fabricas;

import java.util.LinkedList;
import java.util.List;

import edu.taller9.cajero.PropertyManager;
import edu.taller9.cajero.comandos.Comando;
import edu.taller9.cajero.comandos.ComandoCajero;
import edu.taller9.cajero.comandos.IniciarSesion;
import edu.taller9.cajero.comandos.ReporteAuditoria;
import edu.taller9.cajero.comandos.ReporteListaOperaciones;

public class FabricaComandosCajero {
	public static List<Comando> creaComandos() {
		List<Comando> comandos = new LinkedList<Comando>();

		if (PropertyManager.getProperty("ingreso")) {
			comandos.add(new IniciarSesion());
		}
		if (PropertyManager.getProperty("reporte_auditoria")) {
			comandos.add(new ReporteAuditoria());
		}
		if (PropertyManager.getProperty("listado_operaciones")) {
			comandos.add(new ReporteListaOperaciones());
		}
		return comandos;
	}
}
