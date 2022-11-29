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
public class Appointment extends BaseEntity<Integer> {
    @ManyToOne()
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    private LocalDate date;
    private String hour;

    public Appointment( Doctor doctor, LocalDate date, String hour) {
        this.doctor = doctor;
        this.date = date;
        this.hour = hour;
    }

    public String toString() {
        String patientName = "_ ";
        if (patient!=null)
            patientName = this.getPatient().getFullName();
        return "Appointment(patient: " + patientName
                + ", doctor: " + this.getDoctor().getFullName()
                + ", date: " + this.getDate()
                +", hour: " +this.hour+ ")";
    }
}