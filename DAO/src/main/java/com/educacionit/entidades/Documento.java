package com.educacionit.entidades;

import java.util.Objects;

public class Documento {
	private String tipo;
	private String numero;
	
	public Documento() {
		// TODO Auto-generated constructor stub
	}

	public Documento(String tipo, String numero) {
		super();
		this.tipo = tipo;
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(numero, other.numero) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Documento [ " + tipo + ", " + numero + "]";
	}
}