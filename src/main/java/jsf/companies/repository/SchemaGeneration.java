package jsf.companies.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jsf.companies.model.Empresa;

public class SchemaGeneration {
    public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("companies");

	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	List<Empresa> lista = entityManager
		.createQuery("from Empresa", Empresa.class)
		.getResultList();

	System.out.println(lista);

	entityManager.close();
	entityManagerFactory.close();
    }
}
