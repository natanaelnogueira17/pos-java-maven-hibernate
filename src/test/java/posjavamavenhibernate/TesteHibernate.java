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
		pessoa.setNome("ernani ");
		pessoa.setSenha("1234");
		pessoa.setSobrenome("santos");
		pessoa.setIdade(20L);
		daoGeneric.salvar(pessoa);
		System.out.println(pessoa);

	}

	@Test
	public void testeBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);

		pessoa = daoGeneric.pesquisar(pessoa);

		//System.out.println(pessoa);

	}

	@Test
	public void testeBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);

		//System.out.println(pessoa);
	}

	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);
		pessoa.setNome("TesteUpdate");
		pessoa.setSobrenome("testeUpdate");
		pessoa.setLogin("teste3U");
		pessoa = daoGeneric.updateMerge(pessoa);
		//System.out.println(pessoa);
	}
	
	@Test
	public void delete() {
		DaoGeneric<UsuarioPessoa> pessoaDao = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = pessoaDao.pesquisar(8L, UsuarioPessoa.class);
		pessoaDao.delete(pessoa);
		UsuarioPessoa pessoa1 = pessoaDao.pesquisar(8L, UsuarioPessoa.class);
		
		

	}
	@Test
	public void consultar() {
		DaoGeneric<UsuarioPessoa> usuarioDao = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> list = usuarioDao.listar(UsuarioPessoa.class);
		for (UsuarioPessoa pessoa : list) {
			System.out.println(pessoa);
			System.out.println("----------------------------------------------------------------");
		}
		System.out.println("terminou aqui consultar");
		
	}
	
	@Test
	public void testeQueryList() {
		DaoGeneric<UsuarioPessoa> usuarioDao = new DaoGeneric<>();
		List <UsuarioPessoa> list = usuarioDao.getEntitymanager().createQuery("from UsuarioPessoa").getResultList();
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("////////////////////////////////////////////////");
		}
		System.out.println("terminou aqui testeQueryList");

	}
	
	
	@Test
	public void testeQueryListMaxResult() {
		DaoGeneric<UsuarioPessoa> usuarioDao = new DaoGeneric<>();
		List <UsuarioPessoa> list = usuarioDao.getEntitymanager()
				.createQuery("from UsuarioPessoa order by id")
				.setMaxResults(2)
				.getResultList();
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("////////////////////////////////////////////////");
		}
		System.out.println("terminou aqui testeQueryListMaxResult ");

	}
	
	@Test
	public void testeQueryListParameter() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		List<UsuarioPessoa>list = daoGeneric.getEntitymanager().createQuery("from UsuarioPessoa where sobrenome = :sobrenome")
				.setParameter("sobrenome", "santos").getResultList();
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("///////////////////////////////////");
			
		}
		System.out.println("terminou aqui  testeQueryListParameter");


	}
	
	@Test
	public void testeQuerySomaIdade() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		Long somaIdade = (Long) daoGeneric.getEntitymanager().createQuery("select sum(u.idade) from UsuarioPessoa u").getSingleResult();
		System.out.println("Soma de todas as idades é : " +somaIdade);
	}

}
