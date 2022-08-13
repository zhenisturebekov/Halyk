package kz.halykbank.testtaskhalyk.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;

    //Табельный номер
    @Column(name = "PER_NUM")
    private int personnelNumber;

    //ФИО
    @Column(name = "FIO")
    @Size(max = 150)
    private String fullName;

    //Дата рождения в формате 2022-08-13
    @Column(name = "BIRTH_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    //Роль
    @Column(name = "ROLE")
    @Size(max = 50)
    private String role;
}
