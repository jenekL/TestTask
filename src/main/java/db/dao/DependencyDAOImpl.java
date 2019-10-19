package db.dao;

import db.entities.DependenciesEntity;
import db.entities.ScriptsEntity;
import db.services.HibernateSessionFactoryUtil;

import java.util.List;

public class DependencyDAOImpl implements DependencyDAO {
    public List<DependenciesEntity> findAllById(int id) {
        return (List<DependenciesEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From DependenciesEntity where scriptId=:id").setParameter("id", id).list();
    }
}
