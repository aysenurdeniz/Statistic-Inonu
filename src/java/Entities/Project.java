package Entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long totalproject;
    private Long totalpayment;

    public Project() {
    }

    public Project(Long id, Long totalproject, Long totalpayment) {
        this.id = id;
        this.totalproject = totalproject;
        this.totalpayment = totalpayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalproject() {
        return totalproject;
    }

    public void setTotalproject(Long totalproject) {
        this.totalproject = totalproject;
    }

    public Long getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(Long totalpayment) {
        this.totalpayment = totalpayment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Project other = (Project) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", totalproject=" + totalproject + ", totalpayment=" + totalpayment + '}';
    }

}
