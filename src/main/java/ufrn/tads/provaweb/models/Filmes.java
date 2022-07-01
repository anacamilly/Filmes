package ufrn.tads.provaweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ufrn.tads.provaweb.errors.ApiMessages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filmes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = ApiMessages.ERRO_TITULO)
    @Size(min = 5)
    String titulo;

    @NotBlank(message = ApiMessages.ERRO_DIRETOR)
    @Size(min = 5)
    String diretor;

    @NotBlank(message = ApiMessages.ERRO_LANCAMENTO)
    String lancamento;

    @NotBlank(message = ApiMessages.ERRO_PRECO)
    String preco;

    @NotBlank(message = ApiMessages.ERRO_IMAGEM)
    String imagemUri;

    @NotBlank(message = ApiMessages.ERRO_SINOPSE)
    @Size(min = 15)
    String sinopse;

    @NotBlank(message = ApiMessages.ERRO_AVALIACAO)
    int avaliacao;

}