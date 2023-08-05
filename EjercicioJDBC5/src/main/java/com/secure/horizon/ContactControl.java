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

import com.secure.horizon.dao.ContactDAO;
import com.secure.horizon.model.Contacto;

@RestController
@RequestMapping("api/contactos")
public class ContactControl {
	private final ContactDAO contactDao;

	public ContactControl(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}

	@PostMapping("/add")
	public void addContact(@Validated @RequestBody Contacto contacto) {
		contactDao.addContact(contacto);
	}

	@GetMapping("/all")
	public List<Contacto> findAll() {
		return contactDao.findAll();
	}

	@PutMapping("/update/{id}")
	public int updateContact(@Validated @RequestBody Contacto contacto, @PathVariable("id") int id) {
		return contactDao.updateContact(id, contacto);
	}

	@GetMapping("/delete/{id}")
	public int deleteContact(@PathVariable("id") int id) {
		return contactDao.deleteContact(id);
	}

	@GetMapping("/{id}")
	public Contacto findById(@PathVariable("id") int id) {
		return contactDao.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}
}
