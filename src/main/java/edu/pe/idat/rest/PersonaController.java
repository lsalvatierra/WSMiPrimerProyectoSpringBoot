package edu.pe.idat.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.model.Persona;

@RestController
public class PersonaController {
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hola mundo "+ name;
	}
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/getPersona")
	public Persona getPersona(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Persona(counter.incrementAndGet(), String.format(template, name));
	}

	
	
	@GetMapping("/getAllPersona")
	public  List<Persona> getAllPersona() {
		return listarPersona();
	}
	
	
	private List<Persona> listarPersona(){
		List<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas.add(new Persona(1, "Isis"));
		listaPersonas.add(new Persona(2, "Luis"));
		listaPersonas.add(new Persona(4, "Mario"));
		listaPersonas.add(new Persona(5, "Gustavo"));
		listaPersonas.add(new Persona(3	, "Diego"));
		return listaPersonas;
	}
	
}
