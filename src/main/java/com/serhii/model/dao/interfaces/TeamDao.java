package com.serhii.model.dao.interfaces;

import com.serhii.model.entity.Team;

import java.util.List;

public interface TeamDao extends CRUDDao<Team> {
    Team findGameById(Long id);

    List<Team> findAll();
}
