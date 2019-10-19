package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "dependencies", schema = "test", catalog = "")
@IdClass(DependenciesEntityPK.class)
public class DependenciesEntity {
    private int scriptId;
    private int dependencyId;

    @Id
    @Column(name = "script_id", nullable = false)
    public int getScriptId() {
        return scriptId;
    }

    public void setScriptId(int scriptId) {
        this.scriptId = scriptId;
    }

    @Id
    @Column(name = "dependency_id", nullable = false)
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

        DependenciesEntity that = (DependenciesEntity) o;

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
