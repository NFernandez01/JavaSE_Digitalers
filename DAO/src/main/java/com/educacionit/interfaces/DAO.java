package com.educacionit.interfaces;

import java.util.List;

public interface DAO<E,K> {
	
	boolean insertar(E e);
	
	boolean modificar(E e);
	
	boolean eliminar();
	
	E buscar(K k);
	
	List<E> listar();
}