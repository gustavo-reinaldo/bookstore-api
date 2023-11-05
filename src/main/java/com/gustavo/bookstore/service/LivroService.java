package com.gustavo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.bookstore.domain.Livro;
import com.gustavo.bookstore.repositories.LivroRepository;
import com.gustavo.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	
}