package posjavamavenhibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="UsuarioPessoa.todos", query = "select u from  UsuarioPessoa u")
})
public class UsuarioPessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String sobrenome;
	private String login;
	private String senha;
	private Long idade;
	
	@OneToMany(mappedBy = "pessoa",fetch = FetchType.EAGER)
	private List<TelefoneUser> telefoneusers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public Long getIdade() {
		return idade;
	}
	
	

	public List<TelefoneUser> getTelefoneusers() {
		return telefoneusers;
	}

	public void setTelefoneusers(List<TelefoneUser> telefoneusers) {
		this.telefoneusers = telefoneusers;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", login=" + login
				+ ", senha=" + senha + ", idade=" + idade + "]";
	}
	
	
}
