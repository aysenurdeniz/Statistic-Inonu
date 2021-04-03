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
@Table(name = "SOCIALSERVICE")
public class Socialservice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long outpatient;
    private Long dental;
    private Long emergency;
    private Long gym;

    public Socialservice() {
    }

    public Socialservice(Long id, Long outpatient, Long dental, Long emergency, Long gym) {
        this.id = id;
        this.outpatient = outpatient;
        this.dental = dental;
        this.emergency = emergency;
        this.gym = gym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(Long outpatient) {
        this.outpatient = outpatient;
    }

    public Long getDental() {
        return dental;
    }

    public void setDental(Long dental) {
        this.dental = dental;
    }

    public Long getEmergency() {
        return emergency;
    }

    public void setEmergency(Long emergency) {
        this.emergency = emergency;
    }

    public Long getGym() {
        return gym;
    }

    public void setGym(Long gym) {
        this.gym = gym;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Socialservice other = (Socialservice) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Socialservice{" + "id=" + id + ", outpatient=" + outpatient + ", dental=" + dental + ", emergency=" + emergency + ", gym=" + gym + '}';
    }

}
