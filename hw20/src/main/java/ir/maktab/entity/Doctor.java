package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Doctor extends BaseEntity<Integer> {
    private String fullName;
    private String phoneNumber;
    private String major;
    @ManyToOne
    private Clinic clinic;
    @OneToMany(mappedBy = "doctor")
    private Set<Prescription> prescriptions;
    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;

    public Doctor(String fullName, Clinic clinic) {
        this.fullName = fullName;
        this.clinic = clinic;
        this.prescriptions = new HashSet<>();
        this.appointments = new HashSet<>();
    }

    public String toString() {
        return "Doctor(name: " + this.getFullName() +
                ", phoneNumber: " + this.getPhoneNumber() +
                ", major: " + this.getMajor() +")";
    }
}