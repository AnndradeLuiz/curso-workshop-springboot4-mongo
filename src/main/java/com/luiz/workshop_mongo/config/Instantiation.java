package com.luiz.workshop_mongo.config;

import com.luiz.workshop_mongo.domain.Post;
import com.luiz.workshop_mongo.domain.User;
import com.luiz.workshop_mongo.dto.AuthorDTO;
import com.luiz.workshop_mongo.dto.CommentDTO;
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

        AuthorDTO au1 = new AuthorDTO(u1);
        AuthorDTO au2 = new AuthorDTO(u2);
        AuthorDTO au3 = new AuthorDTO(u3);
        AuthorDTO au4 = new AuthorDTO(u4);
        AuthorDTO au5 = new AuthorDTO(u5);
        AuthorDTO au6 = new AuthorDTO(u6);
        AuthorDTO au7 = new AuthorDTO(u7);
        AuthorDTO au8 = new AuthorDTO(u8);
        AuthorDTO au9 = new AuthorDTO(u9);
        AuthorDTO au10 = new AuthorDTO(u10);

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", au1);
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Chegando no destino", "O voo foi tranquilo, partiu hotel.", au1);
        Post post3 = new Post(null, sdf.parse("23/03/2018"), "Dia de jogo!", "Acompanhando as estatísticas do Fluminense, vitória garantida.", au2);
        Post post4 = new Post(null, sdf.parse("24/03/2018"), "Estudos avançando", "Revendo algumas fases de compiladores, assunto tenso.", au2);
        Post post5 = new Post(null, sdf.parse("25/03/2018"), "Treino de hoje", "Fechando mais uma meia maratona, 21km no pace ideal.", au3);
        Post post6 = new Post(null, sdf.parse("26/03/2018"), "Dúvida de equipamento", "O Fila Racer Speedzone serviu bem, 27.27cm exatos no tamanho 41.", au3);
        Post post7 = new Post(null, sdf.parse("27/03/2018"), "Santarém", "Fim de tarde na orla de Santarém não tem igual.", au4);
        Post post8 = new Post(null, sdf.parse("28/03/2018"), "Lembranças", "Bateu uma saudade enorme de Oriximiná hoje.", au4);
        Post post9 = new Post(null, sdf.parse("29/03/2018"), "Infraestrutura", "Finalmente os containers do Mongo e do Postgres subiram liso no Docker.", au5);
        Post post10 = new Post(null, sdf.parse("30/03/2018"), "Ambiente configurado", "WSL e IntelliJ rodando perfeitos juntos.", au5);
        Post post11 = new Post(null, sdf.parse("01/04/2018"), "Projeto interativo", "Terminei de fazer o cartão com JS e CSS pra Jaiane, com a linha do tempo!", au6);
        Post post12 = new Post(null, sdf.parse("02/04/2018"), "Fim de semana", "Aproveitando o dia de folga em casa.", au6);
        Post post13 = new Post(null, sdf.parse("03/04/2018"), "Modelagem finalizada", "Ajustei o banco pra suportar a relação 1:N entre partos e bebês em caso de gêmeos.", au7);
        Post post14 = new Post(null, sdf.parse("04/04/2018"), "Estrutura relacional", "Garantindo que duas pessoas possam compartilhar o mesmo endereço no modelo lógico.", au7);
        Post post15 = new Post(null, sdf.parse("05/04/2018"), "Prototipagem UX", "O fluxo interativo da UBS Santa Clara ficou muito bom no Figma.", au8);
        Post post16 = new Post(null, sdf.parse("06/04/2018"), "Estudos de UI", "As variáveis booleanas do Figma salvam muito tempo de design.", au8);
        Post post17 = new Post(null, sdf.parse("07/04/2018"), "Setup portátil", "Instalei o Debian num cartão SD sem dar conflito com o SSD principal.", au9);
        Post post18 = new Post(null, sdf.parse("08/04/2018"), "Dia de codar", "Aplicando o padrão DAO puro em Java com JDBC.", au9);
        Post post19 = new Post(null, sdf.parse("09/04/2018"), "Ideias locais", "Desenhando os termos de serviço e a logo para o Paco'n.", au10);
        Post post20 = new Post(null, sdf.parse("10/04/2018"), "Empreendedorismo", "O marketplace da comunidade vai sair do papel.", au10);

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2018"), au2);
        CommentDTO c2 = new CommentDTO("Aproveite muito!", sdf.parse("21/03/2018"), au3);
        post1.getComments().addAll(Arrays.asList(c1, c2));

        CommentDTO c3 = new CommentDTO("Qual hotel você ficou?", sdf.parse("22/03/2018"), au4);
        CommentDTO c4 = new CommentDTO("Descansa bem!", sdf.parse("22/03/2018"), au5);
        post2.getComments().addAll(Arrays.asList(c3, c4));

        CommentDTO c5 = new CommentDTO("Pra cima deles!", sdf.parse("23/03/2018"), au1);
        CommentDTO c6 = new CommentDTO("Vai ser 2x0 fácil.", sdf.parse("23/03/2018"), au6);
        post3.getComments().addAll(Arrays.asList(c5, c6));

        CommentDTO c7 = new CommentDTO("Essa matéria é osso.", sdf.parse("24/03/2018"), au7);
        CommentDTO c8 = new CommentDTO("Boa sorte na prova!", sdf.parse("24/03/2018"), au8);
        post4.getComments().addAll(Arrays.asList(c7, c8));

        CommentDTO c9 = new CommentDTO("Voando baixo!", sdf.parse("25/03/2018"), au9);
        CommentDTO c10 = new CommentDTO("Manda o pace depois.", sdf.parse("25/03/2018"), au10);
        post5.getComments().addAll(Arrays.asList(c9, c10));

        CommentDTO c11 = new CommentDTO("Uso o mesmo tênis, muito top.", sdf.parse("26/03/2018"), au1);
        CommentDTO c12 = new CommentDTO("Vale o investimento?", sdf.parse("26/03/2018"), au2);
        post6.getComments().addAll(Arrays.asList(c11, c12));

        CommentDTO c13 = new CommentDTO("Lugar lindo demais.", sdf.parse("27/03/2018"), au3);
        CommentDTO c14 = new CommentDTO("Saudades do Tapajós.", sdf.parse("27/03/2018"), au5);
        post7.getComments().addAll(Arrays.asList(c13, c14));

        CommentDTO c15 = new CommentDTO("Logo você visita.", sdf.parse("28/03/2018"), au6);
        CommentDTO c16 = new CommentDTO("Terra boa!", sdf.parse("28/03/2018"), au7);
        post8.getComments().addAll(Arrays.asList(c15, c16));

        CommentDTO c17 = new CommentDTO("Docker salva vidas.", sdf.parse("29/03/2018"), au8);
        CommentDTO c18 = new CommentDTO("Manda o arquivo docker-compose?", sdf.parse("29/03/2018"), au9);
        post9.getComments().addAll(Arrays.asList(c17, c18));

        CommentDTO c19 = new CommentDTO("Melhor setup de desenvolvimento.", sdf.parse("30/03/2018"), au10);
        CommentDTO c20 = new CommentDTO("Eu uso Ubuntu no WSL, roda liso.", sdf.parse("30/03/2018"), au1);
        post10.getComments().addAll(Arrays.asList(c19, c20));

        CommentDTO c21 = new CommentDTO("Ficou incrível!", sdf.parse("01/04/2018"), au2);
        CommentDTO c22 = new CommentDTO("Ela com certeza vai amar.", sdf.parse("01/04/2018"), au3);
        post11.getComments().addAll(Arrays.asList(c21, c22));

        CommentDTO c23 = new CommentDTO("Mais que merecido.", sdf.parse("02/04/2018"), au4);
        CommentDTO c24 = new CommentDTO("Vai maratonar alguma série?", sdf.parse("02/04/2018"), au5);
        post12.getComments().addAll(Arrays.asList(c23, c24));

        CommentDTO c25 = new CommentDTO("Solução muito bem pensada.", sdf.parse("03/04/2018"), au6);
        CommentDTO c26 = new CommentDTO("Isso evita muita dor de cabeça no código.", sdf.parse("03/04/2018"), au8);
        post13.getComments().addAll(Arrays.asList(c25, c26));

        CommentDTO c27 = new CommentDTO("Normalização perfeita.", sdf.parse("04/04/2018"), au9);
        CommentDTO c28 = new CommentDTO("Me ajudou no meu projeto também.", sdf.parse("04/04/2018"), au10);
        post14.getComments().addAll(Arrays.asList(c27, c28));

        CommentDTO c29 = new CommentDTO("Compartilha os prints depois?", sdf.parse("05/04/2018"), au1);
        CommentDTO c30 = new CommentDTO("Figma facilita muito a vida.", sdf.parse("05/04/2018"), au2);
        post15.getComments().addAll(Arrays.asList(c29, c30));

        CommentDTO c31 = new CommentDTO("Reduz a quantidade de telas absurdo.", sdf.parse("06/04/2018"), au3);
        CommentDTO c32 = new CommentDTO("Recurso excelente pra prototipagem.", sdf.parse("06/04/2018"), au4);
        post16.getComments().addAll(Arrays.asList(c31, c32));

        CommentDTO c33 = new CommentDTO("Setup raiz mesmo.", sdf.parse("07/04/2018"), au5);
        CommentDTO c34 = new CommentDTO("Ficou rápido pelo SD Card?", sdf.parse("07/04/2018"), au6);
        post17.getComments().addAll(Arrays.asList(c33, c34));

        CommentDTO c35 = new CommentDTO("Excelente pra entender a base de tudo.", sdf.parse("08/04/2018"), au7);
        CommentDTO c36 = new CommentDTO("Sofri muito com o ResultSet no começo.", sdf.parse("08/04/2018"), au8);
        post18.getComments().addAll(Arrays.asList(c35, c36));

        CommentDTO c37 = new CommentDTO("A logo ficou muito massa.", sdf.parse("09/04/2018"), au9);
        CommentDTO c38 = new CommentDTO("Sucesso na certa com esse projeto.", sdf.parse("09/04/2018"), au1);
        post19.getComments().addAll(Arrays.asList(c37, c38));

        CommentDTO c39 = new CommentDTO("Iniciativa top pra comunidade.", sdf.parse("10/04/2018"), au2);
        CommentDTO c40 = new CommentDTO("Conta comigo pro que precisar.", sdf.parse("10/04/2018"), au3);
        post20.getComments().addAll(Arrays.asList(c39, c40));

        postRepository.saveAll(Arrays.asList(
                post1, post2, post3, post4, post5, post6, post7, post8, post9, post10,
                post11, post12, post13, post14, post15, post16, post17, post18, post19, post20
        ));

        u1.getPosts().addAll(Arrays.asList(post1, post2));
        u2.getPosts().addAll(Arrays.asList(post3, post4));
        u3.getPosts().addAll(Arrays.asList(post5, post6));
        u4.getPosts().addAll(Arrays.asList(post7, post8));
        u5.getPosts().addAll(Arrays.asList(post9, post10));
        u6.getPosts().addAll(Arrays.asList(post11, post12));
        u7.getPosts().addAll(Arrays.asList(post13, post14));
        u8.getPosts().addAll(Arrays.asList(post15, post16));
        u9.getPosts().addAll(Arrays.asList(post17, post18));
        u10.getPosts().addAll(Arrays.asList(post19, post20));

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10));

    }

}
