package posjavamavenhibernate;

import java.util.List;

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
		System.out.println(pessoa);

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

	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);
		pessoa.setNome("TesteUpdate");
		pessoa.setSobrenome("testeUpdate");
		pessoa.setLogin("teste3U");
		pessoa = daoGeneric.updateMerge(pessoa);
		System.out.println(pessoa);
	}
	
	@Test
	public void delete() {
		DaoGeneric<UsuarioPessoa> pessoaDao = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = pessoaDao.pesquisar(8L, UsuarioPessoa.class);
		pessoaDao.delete(pessoa);
		UsuarioPessoa pessoa1 = pessoaDao.pesquisar(8L, UsuarioPessoa.class);
		if(pessoa1 == null) {
			System.out.println("deletado com sucesso");
		}
		

	}
	@Test
	public void consultar() {
		DaoGeneric<UsuarioPessoa> usuarioDao = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = usuarioDao.listar(UsuarioPessoa.class);
		for (UsuarioPessoa pessoa : list) {
			System.out.println(pessoa);
			System.out.println("----------------------------------------------------------------");
		}
		
	}

}
