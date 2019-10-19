package db.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DependenciesEntityPK implements Serializable {
    private int scriptId;
    private int dependencyId;

    @Column(name = "script_id", nullable = false)
    @Id
    public int getScriptId() {
        return scriptId;
    }

    public void setScriptId(int scriptId) {
        this.scriptId = scriptId;
    }

    @Column(name = "dependency_id", nullable = false)
    @Id
    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DependenciesEntityPK that = (DependenciesEntityPK) o;

        if (scriptId != that.scriptId) return false;
        if (dependencyId != that.dependencyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scriptId;
        result = 31 * result + dependencyId;
        return result;
    }
}
