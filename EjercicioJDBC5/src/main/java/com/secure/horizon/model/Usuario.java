package com.secure.horizon.model;

import java.sql.Date;


public class Usuario  {
	private int id;
	private String nombreUsuario;
	private String run;
	private Date fechaNacimiento;

	// constructor
	public Usuario() {
		super();
	}

	public Usuario(int id, String nombreUsuario, String run, Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.run = run;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(int id, String nombreUsuario, String run, String fechaNacimiento) {
		super();
		Date modifiedDate = Date.valueOf(fechaNacimiento);
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.run = run;
		this.fechaNacimiento = modifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/*
	 * public Long calcularEdad() {
	 * 
	 * Date Hoy = new Date();
	 * 
	 * long timeDiff = Math.abs(Hoy.getTime() - fechaNacimiento.getTime()); long
	 * days = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS); long year =
	 * days / 365; return year; }
	 * 
	 * @Override public void mostrarEdad() { Long edad = calcularEdad();
	 * System.out.println("El usuario tiene " + edad + " años."); }
	 */
	// Métodos de validación de nombre y RUN
	/*
	 * Usuario:
	 * 
	 * - Nombre: obligatorio, mínimo 10 caracteres, máximo 50 - Fecha de nacimiento:
	 * obligatorio, independiente si lo declara como una fecha o * string, debe ser
	 * desplegado con el formato DD/MM/AAAA - RUN: corresponde a un número menor a
	 * 99.999.999
	 * 
	 */

}
