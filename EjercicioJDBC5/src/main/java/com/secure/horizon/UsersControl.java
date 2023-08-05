package com.secure.horizon;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.horizon.dao.UsersDAO;
import com.secure.horizon.model.Usuario;

@RestController
@RequestMapping("api/usuarios")
public class UsersControl {
	private final UsersDAO usersDao;

	public UsersControl(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}

	@PostMapping("/add")
	public void addUser(@Validated @RequestBody Usuario usuario) {
		usersDao.addUser(usuario);
	}

	@GetMapping("/all")
	public List<Usuario> findAll() {
		return usersDao.findAll();
	}

	@PutMapping("/update/{id}")
	public int updateUser(@Validated @RequestBody Usuario usuario, @PathVariable("id") int id) {
		return usersDao.updateUser(id, usuario);
	}

	@GetMapping("/delete/{id}")
	public int deleteUser(@PathVariable("id") int id) {
		return usersDao.deleteUser(id);
	}

	@GetMapping("/{id}")
	public Usuario findById(@PathVariable("id") int id) {
		return usersDao.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}
}
