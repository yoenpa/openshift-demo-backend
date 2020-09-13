package com.example.demo.Repository;

import com.example.demo.Entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Usuario findByUserName(@Param("userName") String name);
    Usuario findOne(@Param("userName") String name);
    Usuario findByUserNameAndContrasenia(@Param("userName") String name, @Param("contrasenia") String contrasenia);
}
