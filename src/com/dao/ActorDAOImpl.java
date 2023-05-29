package com.dao;

import java.util.List;

import com.entity.Actor;
import com.provider.ProviderManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class ActorDAOImpl implements ActorDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public void insertActor(Actor actor) {
		initRoutine();

		em.persist(actor);

		closingRoutine();

	}

	@Override
	public void updateActor(Actor actor) {
		initRoutine();

		em.merge(actor);

		closingRoutine();

	}

	@Override
	public void deleteActor(int actorId) {
		initRoutine();

		em.remove(em.find(Actor.class, actorId));

		closingRoutine();
	}

	@Override
	public List<Actor> getAllActors() {
		initRoutine();

		List<Actor> actors = em.createNamedQuery("Actor.findAll", Actor.class).getResultList();

		closingRoutine();
		return actors;
	}

	@Override
	public List<Actor> getAllActorByLastName(String lastName) {
		initRoutine();

		List<Actor> actors = em.createNamedQuery("Actor.findAllByLastName", Actor.class)
				.setParameter("lastName", lastName).getResultList();

		closingRoutine();
		return actors;
	}

	@Override
	public List<Actor> getAllActorLikeG() {
		initRoutine();

		List<Actor> actors = em.createNamedQuery("Actor.findLike", Actor.class).getResultList();

		closingRoutine();
		return actors;
	}

	@Override
	public List<Actor> getAllActorLikeParam(String prefix) {
		initRoutine();

		List<Actor> actors = em.createNamedQuery("Actor.findLikeParameter", Actor.class).setParameter(1, prefix)
				.getResultList();

		closingRoutine();
		return actors;
	}

	private void initRoutine() {
		emf = ProviderManager.getEntityManagerFactory();
		em = ProviderManager.getEntityManager(emf);
		ProviderManager.beginTransaction(em);
	}

	private void closingRoutine() {
		try {
			ProviderManager.commitTransaction(em);
		} catch (RollbackException rbe) {
			System.err.println("Transazione fallita");
			rbe.printStackTrace();
			ProviderManager.doRollback(em);
		} finally {
			ProviderManager.closeTransaction(em);
			ProviderManager.closeEntityManagerFactory(emf);
		}
	}

}
