package com.secure.horizon.dao;

import java.util.List;
import java.util.Optional;
import com.secure.horizon.model.Usuario;

public interface UsersDAO {

	List<Usuario> findAll();

	int addUser(Usuario usuario);

	Optional<Usuario> findById(int id);

	int deleteUser(int id);

	int updateUser(int id, Usuario usuario);
}
