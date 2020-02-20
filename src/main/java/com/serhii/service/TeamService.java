package com.serhii.service;

import com.serhii.model.dao.DaoFactory;
import com.serhii.model.dao.interfaces.TeamDao;
import com.serhii.model.entity.Team;
import org.apache.log4j.Logger;
import java.util.List;


public class TeamService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Team> findAll() {
        try (TeamDao dao = daoFactory.createTeamDao()) {
            return dao.findAll();
        }
    }
}
