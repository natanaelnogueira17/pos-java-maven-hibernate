package posjavamavenhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class DaoGeneric <E>{
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
		
	}
	
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(),id);
		return e;
		
	}	

	
	public E pesquisar(Long id, Class<E> entidade) {
		E e =  (E) entityManager.find(entidade, id);
		return e;
	}
	
	public E  updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		return entidadeSalva;
		
	}
	
	public void delete (E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createNativeQuery("delete from " +entidade.getClass().getSimpleName().toLowerCase()+" where id ="+id).executeUpdate();
		transaction.commit();

	}
	
	public List<E>listar(Class<E>entidade){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<E>retorno =  entityManager.createQuery("from "+entidade.getName()).getResultList();
		transaction.commit();
		return retorno;
	}
	
	public EntityManager getEntitymanager() {
		return entityManager;
	}
}
