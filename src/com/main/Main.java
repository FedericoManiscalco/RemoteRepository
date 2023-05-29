package com.main;

import com.dao.ActorDAO;
import com.dao.ActorDAOImpl;
import com.entity.Actor;

public class Main {

	public static void main(String[] args) {

		ActorDAO dao = new ActorDAOImpl();

		dao.insertActor(new Actor("Brad", "Pitt"));

		dao.insertActor(new Actor("Ciccio", "Gamer"));

		dao.updateActor(new Actor(202, "Miguel", "Cerquas"));

		dao.deleteActor(201);

		System.out.println("SELECT * FROM actor\n");
		dao.getAllActors().forEach(System.out::println);

		System.out.println("SELECT * FROM actor WHERE name = parametro\n");
		dao.getAllActorByLastName("Guiness").forEach(System.out::println);

		System.out.println("SELECT * FROM actor WHERE lastName like 'M%'\n");
		dao.getAllActorLikeParam("M%").forEach(System.out::println);

	}

}
