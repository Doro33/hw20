package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Patient extends BaseEntity<Integer> {
    private String fullName;
    @Column(unique = true,updatable = false,nullable = false)
    private String nationalCode;
    private String phoneNumber;
    private String password;
    @OneToMany(mappedBy = "patient")
    private Set<Prescription> prescriptions;
    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;

    public Patient(String fullName, String nationalCode, String password) {
        this.fullName = fullName;
        this.nationalCode = nationalCode;
        this.password = password;
        this.prescriptions = new HashSet<>();
        this.appointments = new HashSet<>();
    }

    public String toString() {
        return "Patient(name: " + this.getFullName()
                + ", nationalCode: " + this.getNationalCode()
                + ", phone number: " + this.getPhoneNumber()
                + ", password: " + this.getPassword() + ")";
    }
}