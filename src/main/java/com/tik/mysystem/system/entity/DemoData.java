package com.tik.mysystem.system.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "demo")
@Entity
public class DemoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "string")
    private String string;
    @Column(name = "date")
    private Date date;
    @Column(name = "doubleData")
    private Double doubleData;
}
