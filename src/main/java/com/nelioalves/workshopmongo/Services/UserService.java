package com.nelioalves.workshopmongo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.Services.exception.ObjectNotFoundException;
import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
	   return repo.findAll();	
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return  user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	//metodo de inserção
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	//metodo para apagar
	public void delete(String id) {
		//chama o find by id para verificar se existe no banco
		findById(id);
		repo.deleteById(id);
	}
	
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
	}
}
