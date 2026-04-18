package com.luiz.workshop_mongo.config;

import com.luiz.workshop_mongo.domain.Post;
import com.luiz.workshop_mongo.domain.User;
import com.luiz.workshop_mongo.dto.AuthorDTO;
import com.luiz.workshop_mongo.repository.PostRepository;
import com.luiz.workshop_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

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

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Chegando no destino", "O voo foi tranquilo, partiu hotel.", new AuthorDTO(u1));

        Post post3 = new Post(null, sdf.parse("23/03/2018"), "Dia de jogo!", "Acompanhando as estatísticas do Fluminense, vitória garantida.",new AuthorDTO(u2));
        Post post4 = new Post(null, sdf.parse("24/03/2018"), "Estudos avançando", "Revendo algumas fases de compiladores, assunto tenso.", new AuthorDTO(u2));

        Post post5 = new Post(null, sdf.parse("25/03/2018"), "Treino de hoje", "Fechando mais uma meia maratona, 21km no pace ideal.", new AuthorDTO(u3));
        Post post6 = new Post(null, sdf.parse("26/03/2018"), "Dúvida de equipamento", "O Fila Racer Speedzone serviu bem, 27.27cm exatos no tamanho 41.", new AuthorDTO(u3));

        Post post7 = new Post(null, sdf.parse("27/03/2018"), "Santarém", "Fim de tarde na orla de Santarém não tem igual.", new AuthorDTO(u4));
        Post post8 = new Post(null, sdf.parse("28/03/2018"), "Lembranças", "Bateu uma saudade enorme de Oriximiná hoje.", new AuthorDTO(u4));

        Post post9 = new Post(null, sdf.parse("29/03/2018"), "Infraestrutura", "Finalmente os containers do Mongo e do Postgres subiram liso no Docker.", new AuthorDTO(u5));
        Post post10 = new Post(null, sdf.parse("30/03/2018"), "Ambiente configurado", "WSL e IntelliJ rodando perfeitos juntos.", new AuthorDTO(u5));

        Post post11 = new Post(null, sdf.parse("01/04/2018"), "Projeto interativo", "Terminei de fazer o cartão com JS e CSS pra Jaiane, com a linha do tempo!", new AuthorDTO(u6));
        Post post12 = new Post(null, sdf.parse("02/04/2018"), "Fim de semana", "Aproveitando o dia de folga em casa.", new AuthorDTO(u6));

        Post post13 = new Post(null, sdf.parse("03/04/2018"), "Modelagem finalizada", "Ajustei o banco pra suportar a relação 1:N entre partos e bebês em caso de gêmeos.", new AuthorDTO(u7));
        Post post14 = new Post(null, sdf.parse("04/04/2018"), "Estrutura relacional", "Garantindo que duas pessoas possam compartilhar o mesmo endereço no modelo lógico.", new AuthorDTO(u7));

        Post post15 = new Post(null, sdf.parse("05/04/2018"), "Prototipagem UX", "O fluxo interativo da UBS Santa Clara ficou muito bom no Figma.", new AuthorDTO(u8));
        Post post16 = new Post(null, sdf.parse("06/04/2018"), "Estudos de UI", "As variáveis booleanas do Figma salvam muito tempo de design.", new AuthorDTO(u8));

        Post post17 = new Post(null, sdf.parse("07/04/2018"), "Setup portátil", "Instalei o Debian num cartão SD sem dar conflito com o SSD principal.", new AuthorDTO(u9));
        Post post18 = new Post(null, sdf.parse("08/04/2018"), "Dia de codar", "Aplicando o padrão DAO puro em Java com JDBC.", new AuthorDTO(u9));

        Post post19 = new Post(null, sdf.parse("09/04/2018"), "Ideias locais", "Desenhando os termos de serviço e a logo para o Paco'n.", new AuthorDTO(u10));
        Post post20 = new Post(null, sdf.parse("10/04/2018"), "Empreendedorismo", "O marketplace da comunidade vai sair do papel.", new AuthorDTO(u10));

        postRepository.saveAll(Arrays.asList(
                post1, post2, post3, post4, post5, post6, post7, post8, post9, post10,
                post11, post12, post13, post14, post15, post16, post17, post18, post19, post20
        ));

    }

}
