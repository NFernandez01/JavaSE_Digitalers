package com.educacionit.interfaces;

import java.util.List;

public interface DAO<E,K> {
	
	boolean guardar(E e);
	
	boolean eliminar(E e);
	
	E buscar(K k);
	
	List<E> listar();
}