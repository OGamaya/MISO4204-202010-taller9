package edu.taller9.cajero.model;

public class Cuenta {

	private String cedula;
	private String clave;
	private long saldo;
	
	// constructor que recibe la clave y el saldo de la cuenta
	public Cuenta(String numero, String clave, long saldo) {
		this.cedula = numero;
		this.clave  = clave;
		this.saldo  = saldo;
	}
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	// obtiene el número de cedula de la cuenta
	public String getCedula() {
		return cedula;
	}
	
	// obtiene el valor del saldo
	public long getSaldo() {
		return saldo;
	}
	
	// autentica al cliente
	public boolean autenticar(String claveDigitada) {
		return this.clave.equals(claveDigitada);
	}
	// hace una consignación
	public void consignar(long valor) throws Exception {
		
		// solo se hace la consignación si el valor es mayor que cero
		if (valor < 0) {
			throw new Exception("No se puede consignar un valor negativo");
		}
		this.saldo += valor;
	}
	
	// hace un retiro
	public void retirar(long valor) throws Exception {
		
		// solo se hace el retiro si el valor es mayor que cero
		// y el valor es mayor que el saldo actual
		if (valor < 0) {
			throw new Exception("No se puede retirar un valor negativo");
		}
		if (valor > this.saldo) {
			throw new Exception("No se puede retirar un valor mayor al saldo");
		}
		this.saldo -= valor;
	}

	@Override
	public String toString() {
		return "Cuenta [cedula=" + cedula + ", saldo=" + saldo + "]";
	}
	
	
		
}
