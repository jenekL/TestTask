package db.dao;

import db.entities.DependenciesEntity;

import java.util.List;

public interface DependencyDAO {
    List<DependenciesEntity> findAllById(int id);
}
