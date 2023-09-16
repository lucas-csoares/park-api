package com.lcsoares.parkapi.service;
import com.lcsoares.parkapi.entity.Usuario;
import com.lcsoares.parkapi.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //transforma a classe em um Bean gerenciado pelo Spring Booot
public class UsuarioService {

    // Para o processo do Lombok funcione com o Spring é necessário adicionar a variável na classe como final
    // (constante)
    private final UsuarioRepository usuarioRepository;

    @Transactional //Indica que o Spring Boot vai tomar conta da parte referente a transaçõo (abrir, fechar e
    // gerenciar)
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario); //método disponibilizado pela interface JPARepository
    }
}
