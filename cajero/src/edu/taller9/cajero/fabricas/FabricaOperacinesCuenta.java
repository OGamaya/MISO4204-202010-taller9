package edu.taller9.cajero.fabricas;

import java.util.LinkedList;
import java.util.List;

import edu.taller9.cajero.PropertyManager;
import edu.taller9.cajero.comandos.Comando;
import edu.taller9.cajero.comandos.ComandoConsignar;
import edu.taller9.cajero.comandos.ComandoPagoServicios;
import edu.taller9.cajero.comandos.ComandoRetirar;
import edu.taller9.cajero.comandos.ComandoTransferir;
import edu.taller9.cajero.comandos.ComandoVerSaldo;
import edu.taller9.cajero.comandos.OperacionCuenta;

public class FabricaOperacinesCuenta {

	public static List<Comando> creaComandos() {
		List<Comando> comandos = new LinkedList<Comando>();
		
		if (PropertyManager.getProperty("saldo")) {
			comandos.add(new ComandoVerSaldo());
		} 
		if (PropertyManager.getProperty("retiros")) {
			comandos.add(new ComandoRetirar());
		} 
		if (PropertyManager.getProperty("pagos_servicios")) {
			comandos.add(new ComandoPagoServicios());
		} 
		if (PropertyManager.getProperty("consignaciones")) {
			comandos.add(new ComandoConsignar());
		} 
		if (PropertyManager.getProperty("transferencias")) {
			comandos.add(new ComandoTransferir());
		}
			
		return comandos;
	}
}