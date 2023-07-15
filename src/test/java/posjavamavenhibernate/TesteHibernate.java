package posjavamavenhibernate;

import org.junit.Test;

import posjavamavenhibernate.dao.DaoGeneric;
import posjavamavenhibernate.model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setLogin("teste4");
		pessoa.setNome("natanael ");
		pessoa.setSenha("1234");
		pessoa.setSobrenome("santos");		
		daoGeneric.salvar(pessoa);
		
	}
	@Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
		


	}
	@Test
	public void testeBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);
				
		System.out.println(pessoa);
		


	}
}
