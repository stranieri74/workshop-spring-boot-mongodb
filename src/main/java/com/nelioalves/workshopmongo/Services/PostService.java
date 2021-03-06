package com.nelioalves.workshopmongo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.Services.exception.ObjectNotFoundException;
import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return  user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
		//return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 *60 *60 *1000);
		return repo.fullSearch(text, minDate, maxDate);
		//return repo.findByTitleContainingIgnoreCase(text);
	}

}
