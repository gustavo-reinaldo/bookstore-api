package com.gustavo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.bookstore.domain.Categoria;
import com.gustavo.bookstore.domain.Livro;
import com.gustavo.bookstore.repositories.CategoriaRepository;
import com.gustavo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired 
	private LivroRepository livroRepository;
	
	
	public void instanciaBaseDeDados() {	
		Categoria cat1 = new Categoria(null, "Informatica","Livros de TI");
		Categoria cat2 = new Categoria(null, "Culinaria", "Livros de Culinaria");
		Categoria cat3 = new Categoria(null, "Esportes", "Livros de Esportes");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Panquecas", "Ana Maria Braga", "Como fazer Panquecas", cat2);
		Livro l3 = new Livro(null, "Futebol", "Galvao Bueno", "Historia do Futebol", cat3);
		Livro l4 = new Livro(null, "Desenvolvimento Ágil", "Robert C. Martin", "Lorem Ipsum", cat1);
		Livro l5 = new Livro(null, "Arroz", "Ana Maria Braga", "Como fazer arroz soltinho", cat2);
		
		
		
		cat1.getLivros().addAll(Arrays.asList(l1,l4));
		cat2.getLivros().addAll(Arrays.asList(l2, l5));
		cat3.getLivros().addAll(Arrays.asList(l3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
}
