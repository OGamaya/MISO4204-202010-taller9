package edu.taller9.cajero.aspectos;

import edu.taller9.cajero.model.Cuenta;

public aspect saldo_reducido {
	pointcut retirarDeCuenta(): call (void retirar(long));
	void around() throws Exception : retirarDeCuenta() {
		proceed();
		Cuenta c = (Cuenta)thisJoinPoint.getTarget();
		if (c.getSaldo() < 200000) {
			Object [] args = thisJoinPoint.getArgs();
			long retiro = (Long)args[0];
			c.consignar(retiro);
			throw new Exception("No puede quedar con menos de 200.000 en la cuenta");
		}
	}
}
