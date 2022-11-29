package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Clinic extends BaseEntity<Integer> {
    private String name;
    private String phoneNumber;
    @OneToMany(mappedBy = "clinic")
    @ToString.Exclude
    private Set<Doctor> doctors;

    public Clinic(String name) {
        this.name = name;
        this.doctors = new HashSet<>();
    }
}