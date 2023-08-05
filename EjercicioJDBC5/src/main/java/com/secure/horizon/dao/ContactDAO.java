package com.secure.horizon.dao;

import java.util.List;
import java.util.Optional;

import com.secure.horizon.model.Contacto;

public interface ContactDAO {
	List<Contacto> findAll();

	int addContact(Contacto contacto);

	Optional<Contacto> findById(int id);

	int deleteContact(int id);

	int updateContact(int id, Contacto contacto);
}
