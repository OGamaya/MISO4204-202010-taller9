package edu.taller9.cajero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogOperaciones {

	private static Map<String, List<String>> audith = new HashMap<String, List<String>>();
	private static ArrayList<String> operations = new ArrayList<String>();
	private static String operacion;
	private static String auditoria;
	
	
	public static void abrirOperacion(String record) {
		operacion  = record; 
	}
	
	public static String cerrarOperacion(String record) {
		return operacion + record; 
	}
	public static void abrirAuditoria(String record) {
		auditoria  = record; 
	}
	
	public static String cerrarAuditoria(String record) {
		return auditoria + record; 
	}
	
	public static void addAudith(String cuenta, String registro) {
		if (!audith.containsKey(cuenta))
			audith.put(cuenta, new ArrayList<String>());
		audith.get(cuenta).add(registro);
	}

	public static void addOperation(String registro) {
		operations.add(registro);
	}

	public static Map<String, List<String>> getAudith() {
		return audith;
	}

	public static ArrayList<String> getOperations() {
		return operations;
	}


}
