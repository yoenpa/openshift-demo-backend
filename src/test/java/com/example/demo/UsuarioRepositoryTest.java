package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.UsuarioRepository;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository userMongoRepository;

    
    @Before
    public void setUp() throws Exception {
        Usuario user1= new Usuario("Fapencio", "password", "1-9", "Anastacio", "Pajencio", "Horrencio" );
        //save product, verify has ID value after save
        this.userMongoRepository.save(user1);
        
        Usuario user2= new Usuario("Archibaldo", "prueba", "15.844.394-5", "Victor", "Merino", "Muñoz");
        this.userMongoRepository.save(user2);
    }

    @Test
    public void testFetchData(){
        /*Get all products, list should only have two*/
        Iterable<Usuario> users = userMongoRepository.findAll();
        for(Usuario p : users){
            System.out.println("Nombre: " + p.getUserName());
        }
        Usuario existe = userMongoRepository.findByUserNameAndContrasenia("Archibaldo", "prueba");
        if (existe == null) {
        	System.out.println("No existe");
        }
        else {
        	System.out.println("Existe");
        }
    }

    @After
    public void testDelete() throws Exception {
      /*this.userMongoRepository.deleteAll();*/
    }

}