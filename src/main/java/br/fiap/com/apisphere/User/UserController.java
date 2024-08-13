package br.fiap.com.apisphere.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.fiap.com.apisphere.user.dto.UserFormRequest;
import br.fiap.com.apisphere.user.dto.UserResponse;



@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService service;

    

    @GetMapping
    public List<UserResponse> findAll(){
        return service
        .findAll()
        .stream()
        .map(UserResponse::fromModel)
        .toList();
        
        
        
        
    
    }    
    
    
    
    
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserFormRequest userForm, UriComponentsBuilder uriBuilder){
        var user = service.create(userForm.toModel());
        var uri = uriBuilder
                    .path("/users/{id}")
                    .buildAndExpand(user.getId())
                    .toUri();

        return ResponseEntity
                .created(uri)
                .body(UserResponse.fromModel(user));
    }
}
