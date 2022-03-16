package com.springehcache.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "human_resource")
public class HumanResource {

    // 부서
    public enum Department {
        Dev, Marketing, Sales, Manage
    }

    // 직급
    public enum Rank {
        Worker, Manager, DepartmentHead
    }

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "insert_time", insertable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "s")
    private Date insertTime;

    @Column(name = "update_time", insertable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "s")
    private Date updateTime;

    @Column(name = "delete_time")
    @JsonIgnore
    private Date deleteTime;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Department department;

    @Column(name = "rank")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Rank rank;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "salary")
    @NotNull
    private BigInteger salary;

    public Department getStringDepartment(String insertDepartment) {
        switch (insertDepartment.toLowerCase()) {
            case "dev" :
                return Department.Dev;
            case "marketing" :
                return Department.Marketing;
            case "sales" :
                return Department.Sales;
            case "manage" :
                return Department.Manage;
            default:
                return null;
        }
    }

}
