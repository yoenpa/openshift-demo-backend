package com.example.demo.Service;

import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by cristian.pena on 29-09-2017.
 */
@Service
public class UsuarioService {
    private UsuarioRepository repoUsuario;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repoUsuario = repository;
    }

    public Collection<Usuario> getUsuarios() {
        return this.repoUsuario.findAll();
    }
    
    public Usuario findByName(String name) {
        return this.repoUsuario.findByUserName(name);
    }
    
    public void saveUser(Usuario usuario) {
    	this.repoUsuario.save(usuario);
    }
    
    public Usuario findByUserNameAndContrasenia(Usuario usuario) {
    	return this.repoUsuario.findByUserNameAndContrasenia(usuario.getUserName(), usuario.getContrasenia());
    }
    
}
