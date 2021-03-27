package br.com.standard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import br.com.standard.util.TextUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Cliente extends BaseEntity {

	@NotNull
	@NotEmpty
	@Length(max = 150)
	@Column(nullable = false, length = 150)
	private String nome;

	@Length(min = 10, max = 30)
	@Column(length = 30)
	private String fone;

	@Email
	@NotNull
	@NotEmpty
	@Length(max = 150)
	@Column(nullable = false, length = 150)
	private String email;

	@NotNull
	@NotEmpty
	@Length(max = 9)
	@Column(nullable = false, length = 9)
	private String cep;

	@NotNull
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false, length = 200)
	private String endereco;

	@NotNull
	@NotEmpty
	@Length(max = 30)
	@Column(nullable = false, length = 30)
	private String numero;

	@NotNull
	@NotEmpty
	@Length(max = 100)
	@Column(nullable = false, length = 100)
	private String bairro;

	@NotNull
	@NotEmpty
	@Length(max = 100)
	@Column(nullable = false, length = 100)
	private String cidade;

	@NotNull
	@NotEmpty
	@Length(max = 80)
	@Column(nullable = false, length = 80)
	private String estado;

	public String getCepFormatado() {

		return TextUtils.maskCep(this.cep);
	}

	public String getFoneFormatado() {

		return TextUtils.maskPhone(this.fone);
	}
}
