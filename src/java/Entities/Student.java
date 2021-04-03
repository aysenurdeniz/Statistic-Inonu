package Entities;

import Enums.Degree;
import Enums.Gender;
import Enums.HighDegree;
import Enums.StandardDegree;
import Enums.Status;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Enumerated(EnumType.STRING)
    private StandardDegree standardDegree;

    @Enumerated(EnumType.STRING)
    private HighDegree highDegree;

    @ManyToOne( fetch=FetchType.LAZY)
    @JoinColumn(name = "field_id")
    private Field field;

    public Student() {
    }

    public Student(Long id, Gender gender, Status status, Degree degree, StandardDegree standardDegree, HighDegree highDegree, Field field) {
        this.id = id;
        this.gender = gender;
        this.status = status;
        this.degree = degree;
        this.standardDegree = standardDegree;
        this.highDegree = highDegree;
        this.field = field;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public StandardDegree getStandardDegree() {
        return standardDegree;
    }

    public void setStandardDegree(StandardDegree standardDegree) {
        this.standardDegree = standardDegree;
    }

    public HighDegree getHighDegree() {
        return highDegree;
    }

    public void setHighDegree(HighDegree highDegree) {
        this.highDegree = highDegree;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.field, other.field)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", gender=" + gender + ", status=" + status + ", degree=" + degree + ", standardDegree=" + standardDegree + ", highDegree=" + highDegree + ", field=" + field + '}';
    }

}
