package org.jcb.dojo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.jcb.dojo.dominio.Imovel;

public class ImovelDao extends DAOEntityManagerGenerico<Imovel, Long> {

	public ImovelDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		super(em);
	}

	public List<Imovel> recuperarTodosFetch() {
		return getEm().createNamedQuery("Imovel.recuperarTodosFetch").getResultList();
	}

	public List<Imovel> recuperarPaginado(int primeiroRegistro, int quantidade) {
		return getEm().createNamedQuery("Imovel.recuperarTodosFetch", Imovel.class).setFirstResult(primeiroRegistro)
				.setMaxResults(primeiroRegistro + quantidade).getResultList();
	}
	
	public Long conta(){
		return getEm().createQuery("select count(i) from Imovel i", Long.class).getSingleResult();
	}
}
