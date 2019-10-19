package db.dao;

import db.entities.ScriptsEntity;
import db.services.HibernateSessionFactoryUtil;

public class ScriptDAOImpl implements ScriptDAO {

    public ScriptsEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ScriptsEntity.class, id);
    }
}
