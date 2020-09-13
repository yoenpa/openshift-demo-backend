package com.example.demo.Controller;

import com.example.demo.Entity.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by cristian.pena on 29-09-2017.
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "rest")
public class UsuarioController {

    private UsuarioService oUsuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.oUsuarioService = usuarioService;
    }

    @RequestMapping(value="/usuarios", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<Usuario>> getUsuarios() {
        Collection<Usuario> lUsuarios = (Collection<Usuario>) this.oUsuarioService.getUsuarios();
        if(lUsuarios.isEmpty()){
            return new ResponseEntity<Collection<Usuario>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Collection<Usuario>>(lUsuarios, HttpStatus.OK);
    }

	@RequestMapping(value = "/usuarios/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Usuario> getUser(@PathVariable("name") String name) {
        Usuario usuario = this.oUsuarioService.findByName(name);
        if (usuario == null) {
            return new ResponseEntity<Usuario>(HttpStatus.OK);
        }else {
        	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        
    }
    
    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> createUser(@RequestBody Usuario usuario) {
    	
    	Usuario create = oUsuarioService.findByName(usuario.getUserName());
        if (create == null) {
        	System.out.println("No existe");
            oUsuarioService.saveUser(usuario);
            return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        }
        else {
        	System.out.println("Ya existe");
            return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> login(@RequestBody Usuario usuario){
    	Usuario login = oUsuarioService.findByUserNameAndContrasenia(usuario);
    	if (login == null){
    		System.out.println("Login incorrecto");
    		return new ResponseEntity<HttpStatus>(HttpStatus.FORBIDDEN);
    	}else {
    		System.out.println("Se loguearon");
    		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    	}

    }
    




//    @Autowired
//    UserService userService;  //Service which will do all data retrieval/manipulation work
//
//
//    //-------------------Retrieve All Users--------------------------------------------------------
//
//    @RequestMapping(value = "/user/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUsers() {
//        List<User> users = userService.findAllUsers();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }
//
//
//    //-------------------Retrieve Single User--------------------------------------------------------
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//        System.out.println("Fetching User with id " + id);
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
//
//
//
//    //-------------------Create a User--------------------------------------------------------
//
//    @RequestMapping(value = "/user/", method = RequestMethod.POST)
//    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating User " + user.getName());
//
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//
//        userService.saveUser(user);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//
//    //------------------- Update a User --------------------------------------------------------
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        System.out.println("Updating User " + id);
//
//        User currentUser = userService.findById(id);
//
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        currentUser.setName(user.getName());
//        currentUser.setAge(user.getAge());
//        currentUser.setSalary(user.getSalary());
//
//        userService.updateUser(currentUser);
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }
//
//    //------------------- Delete a User --------------------------------------------------------
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
//        System.out.println("Fetching & Deleting User with id " + id);
//
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("Unable to delete. User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        userService.deleteUserById(id);
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
//
//
//    //------------------- Delete All Users --------------------------------------------------------
//
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteAllUsers() {
//        System.out.println("Deleting All Users");
//
//        userService.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }

}
