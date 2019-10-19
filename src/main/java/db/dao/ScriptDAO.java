package db.dao;

import db.entities.ScriptsEntity;

public interface ScriptDAO {
    ScriptsEntity findById(int id);
}
