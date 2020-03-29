package edu.taller9.cajero.aspectos;

import java.util.Date;

import edu.taller9.cajero.LogOperaciones;
import edu.taller9.cajero.PropertyManager;
import edu.taller9.cajero.comandos.Comando;
import edu.taller9.cajero.comandos.IniciarSesion;
import edu.taller9.cajero.model.Cuenta;

public aspect listado_operaciones {
	pointcut operaciones(): call (Cuenta ejecutar(*,*));

	// ejecución antes de ejecutar el método
	before(): operaciones() {
		Comando c = (Comando)thisJoinPoint.getTarget();
		Cuenta cuenta = (Cuenta) thisJoinPoint.getArgs()[1];
		String reporte = "Ejectando operación ->"+ c.getNombre();
		reporte += "\n\t Estado inicial de cuenta : " +  cuenta;
		LogOperaciones.abrirOperacion(reporte);
	}

	after() returning(Object resultado): operaciones() {
		String record = "\n\t Estado final de cuenta  : " + resultado;
		String reporteFinal = LogOperaciones.cerrarOperacion(record);
		if (resultado != null) 
			LogOperaciones.addOperation(reporteFinal);
	}
}
