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
@Table(name = "PHYSICALSERVICE")
public class Physicalservice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long lab;
    private Long conference;
    private Long meeting;
    private Long dormitorycapacity;

    public Physicalservice() {
    }

    public Physicalservice(Long id, Long lab, Long conference, Long meeting, Long dormitorycapacity) {
        this.id = id;
        this.lab = lab;
        this.conference = conference;
        this.meeting = meeting;
        this.dormitorycapacity = dormitorycapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLab() {
        return lab;
    }

    public void setLab(Long lab) {
        this.lab = lab;
    }

    public Long getConference() {
        return conference;
    }

    public void setConference(Long conference) {
        this.conference = conference;
    }

    public Long getMeeting() {
        return meeting;
    }

    public void setMeeting(Long meeting) {
        this.meeting = meeting;
    }

    public Long getDormitorycapacity() {
        return dormitorycapacity;
    }

    public void setDormitorycapacity(Long dormitorycapacity) {
        this.dormitorycapacity = dormitorycapacity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Physicalservice other = (Physicalservice) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Physicalservice{" + "id=" + id + ", lab=" + lab + ", conference=" + conference + ", meeting=" + meeting + ", dormitorycapacity=" + dormitorycapacity + '}';
    }

}
