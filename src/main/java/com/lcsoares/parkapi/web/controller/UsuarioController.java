package com.lcsoares.parkapi.web.controller;

import com.lcsoares.parkapi.entity.Usuario;
import com.lcsoares.parkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // A injeção de dependências para o usuarioService será feita via construtor
@RestController // Anotação que faz o Spring entender que a classe é um Bean gerenciado por ele eum Bean do tipo
// controller para requisições do tipo REST
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    // O tipo ResponseEntity<> encapsula a resposta de requisição para um tipo (nesse caso, Usuario)
    // O `ResponseEntity`vai encapsular o objeto Usuario, em seguida será transformado em um objeto JSON e enviado
    // para o cliente.
    //ResponseEntity guarda outras informações além do usuário, como código de resposta ou cabeçalho que você queira
    // enviar na resposta.
    // O objeto Usuario é o argumento pois a aplicação vai ter um JSON com os campos do objeto Usuario. Quando o JSON
    // for enviado para aplicação, o Spring junto a uma biblioteca de nome Jakson faz a conversão do objeto JSON em
    // um objeto Usuario
    // O método `criar()`não precisa de autenticação
    @PostMapping() // QUando o método for POST, cai no método
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        // Pegar objeto usuário recebido na requisição e salvar no BD
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
