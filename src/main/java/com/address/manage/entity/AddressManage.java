package com.address.manage.entity;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "address_manage")
@Data
public class AddressManage extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @Email
    private String email;

    @NotEmpty
    private int number;

    @NotEmpty
    private String countryCode;

    private String label;
}
