package com.lcsoares.parkapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity //mapeamento de entidade
@Table(name = "usuarios") //Identifica tabela no banco de dados
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    // A senha vai ser criptografada, o que significa que ela fiará maior que o real
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    // O tamanho definido (25) prevê a criação futura de mais perfis
    @Enumerated(EnumType.STRING) //Transforma a constante em String para salvar no BD
    @Column(name = "role", nullable = false, length = 25)
    private Role role;


    // Recursos de auditoria que são trabalhados no Spring Security

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao")
    private LocalDateTime dataModificacao;
    @Column(name = "criado_por")
    private String criadoPor; //Usuario que realizou a operação de insert na tabela
    @Column(name = "modificado_por")
    private String modificadoPor; //usuario que realizou a operação de update na tabela



    public enum Role {
        ROLE_ADMIN, ROLE_CLIENTE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
}
