package edu.taller9.cajero.aspectos;

import java.util.Date;

import edu.taller9.cajero.LogOperaciones;
import edu.taller9.cajero.PropertyManager;
import edu.taller9.cajero.comandos.Comando;
import edu.taller9.cajero.comandos.IniciarSesion;
import edu.taller9.cajero.model.Cuenta;

public aspect reporte_auditoria {
	pointcut operaciones(): call (Cuenta ejecutar(*,*));

	// ejecución antes de ejecutar el método
	before(): operaciones() {
		Comando c = (Comando) thisJoinPoint.getTarget();
		Cuenta cuenta = (Cuenta) thisJoinPoint.getArgs()[1];
		String reporte = "Ejectando operación ->" + c.getNombre();
		reporte += "\n\t Hora : " + new Date();
		reporte += "\n\t Estado inicial de cuenta : " + cuenta;
		LogOperaciones.abrirAuditoria(reporte);
	}

	after() returning(Object resultado): operaciones() {
		Cuenta cuenta = (Cuenta) resultado;
		String record = "\n\t Estado final de cuenta  : " + resultado;
		String reporteFinal = LogOperaciones.cerrarAuditoria(record);
		if (cuenta != null) {
			LogOperaciones.addAudith(cuenta.getCedula(), reporteFinal);
		}
	}
}
