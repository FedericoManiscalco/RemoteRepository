package com.dao;

import java.util.List;

import com.entity.Actor;

public interface ActorDAO {

	public void insertActor(Actor actor);

	public void updateActor(Actor actor);

	public void deleteActor(int actorId);

	public List<Actor> getAllActors();

	public List<Actor> getAllActorByLastName(String lastName);

	public List<Actor> getAllActorLikeG();

	public List<Actor> getAllActorLikeParam(String prefix);

}
