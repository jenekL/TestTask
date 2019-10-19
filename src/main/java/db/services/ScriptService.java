package db.services;

import db.dao.ScriptDAO;
import db.dao.ScriptDAOImpl;
import db.entities.ScriptsEntity;

public class ScriptService {
    private ScriptDAO scriptDAO = new ScriptDAOImpl();

    public ScriptService() {
    }

    public ScriptsEntity findById(int id){
        return scriptDAO.findById(id);
    }
}
