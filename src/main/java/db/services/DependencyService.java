package db.services;

import db.dao.DependencyDAO;
import db.dao.DependencyDAOImpl;
import db.entities.DependenciesEntity;

import java.util.List;

public class DependencyService {
    private DependencyDAO dependencyDAO = new DependencyDAOImpl();

    public DependencyService() {
    }

    public List<DependenciesEntity> getByScriptId(int scriptId){
        return dependencyDAO.findAllById(scriptId);
    }
}
