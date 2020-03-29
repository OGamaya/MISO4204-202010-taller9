package edu.taller9.cajero.comandos;

import edu.taller9.cajero.model.Banco;
import edu.taller9.cajero.model.Cuenta;

/**
 * Interfaz usada para permitir agregar y modificar los comandos
 * que se usan en el cajero
 */
public interface Comando {
	
	/**
	 * Retorna el nombre del comando, tal como va a aparece en pantalla
	 * @return Nombre del comando
	 */
	public String getNombre();
	
	/**
	 * Ejecuta el comando solicitado por el usuario
	 * @param contexto    Instancia de Banco que contiene las operaciones a utilizar 
	 * @param actual  Cuenta del usuario que est� en el cajero
	 * @return Cuenta modificada
	 * @throws Exception  Excepción que representa errores definidos por la lógica de negocio
	 */
	public Cuenta ejecutar(Banco contexto, Cuenta actual) throws Exception;

}
