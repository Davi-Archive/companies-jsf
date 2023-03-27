package jsf.companies.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import jsf.companies.model.Empresa;

public class Empresas implements Serializable {

    private static final long serialVersionUID = 715927844606707918L;

    @Inject
    private EntityManager manager;

    public Empresas() {
    }

    public Empresas(EntityManager manager) {
	this.manager = manager;
    }

    public Empresa porId(Long id) {
	return manager.find(Empresa.class, id);
    }

    public List<Empresa> pesquisar(String nome) {
	String jpql = "from Empresa where nomeFantasia like :nomeFantasia";

	TypedQuery<Empresa> query = manager.createQuery(jpql,
		Empresa.class);

	query.setParameter("nomeFantasia", nome + "%");

	return query.getResultList();
    }

    public Empresa guardar(Empresa empresa) {
	return manager.merge(empresa);
    }

    public void remover(Empresa empresa) {
	empresa = porId(empresa.getId());
	manager.remove(empresa);
    }
}
