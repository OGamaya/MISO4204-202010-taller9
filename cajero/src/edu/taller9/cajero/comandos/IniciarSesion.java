package edu.taller9.cajero.comandos;

import java.util.Scanner;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

public class IniciarSesion implements ComandoCajero {

	@Override
	public String getNombre() {
		return "Ingresar";
	}

	@Override
	public Cuenta ejecutar(Banco contexto, Cuenta actual) throws Exception {
		System.out.println("Digite sus datos");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		Scanner console = new Scanner(System.in);			
		
		// Ingresa los datos
		System.out.println("Ingrese el número de cédula");
		String numeroDeCuenta = console.nextLine();
		
		// Ingresa los datos
		System.out.println("Ingrese su clave");
		String claveDeCuenta = console.nextLine();
		
		Cuenta tmp = contexto.buscarCuenta(numeroDeCuenta);
		if (tmp == null) {
			throw new Exception("No hay cuentas asociadas a la cédula " + numeroDeCuenta);
		}
		if (tmp.autenticar(claveDeCuenta)) {
			return tmp;
		} else {
			throw new Exception("Los datos ingresados son incorrectos");
		}
	}

}
