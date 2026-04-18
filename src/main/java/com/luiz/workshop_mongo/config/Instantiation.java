package com.luiz.workshop_mongo.config;

import com.luiz.workshop_mongo.domain.User;
import com.luiz.workshop_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "Ana Silva", "ana.silva@gmail.com");
        User u2 = new User(null, "Bruno Souza", "bruno.souza@hotmail.com");
        User u3 = new User(null, "Carlos Eduardo", "carlos.eduardo@yahoo.com");
        User u4 = new User(null, "Daniela Costa", "daniela.costa@gmail.com");
        User u5 = new User(null, "Eduardo Mendes", "eduardo.mendes@outlook.com");
        User u6 = new User(null, "Fernanda Lima", "fernanda.lima@gmail.com");
        User u7 = new User(null, "Gabriel Almeida", "gabriel.almeida@hotmail.com");
        User u8 = new User(null, "Helena Pereira", "helena.pereira@yahoo.com");
        User u9 = new User(null, "Igor Ribeiro", "igor.ribeiro@gmail.com");
        User u10 = new User(null, "Juliana Castro", "juliana.castro@outlook.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10));

    }

}
