package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prescription extends BaseEntity<Integer> {
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    private LocalDate date;
    private String description;

    public Prescription(Patient patient, Doctor doctor, LocalDate date, String description) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.description = description;
    }

    public String toString() {
        return "Prescription(patient: " + this.getPatient().getFullName()
                + ", doctor: " + this.getDoctor().getFullName()
                + ", date: " + this.getDate()
                + ", description: " + this.getDescription() + ")";
    }
}