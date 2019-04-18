package br.com.pjr.exemplospringbootadminclient.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O nome é obrigatório!")
	@Column(nullable = false)
	private String nome;

	private String descricao;

	@NotNull(message = "O valor é obrigatório!")
	@Column(nullable = false)
	private BigDecimal valor;

	@NotNull(message = "A data de cadastro é obrigatório!")
	@Column(nullable = false)
	private Date dataCadastro;

}
