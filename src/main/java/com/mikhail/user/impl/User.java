package com.mikhail.user.impl;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.ticket.impl.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Size(max = 50)
    @NotBlank
    private String name;

    @Size(max = 50)
    @NotBlank
    private String surname;

    @Size(max = 50)
    @NotBlank
    @NaturalId
    @Column(nullable = false, unique = true)
    private String username;

    @Size(min = 5, max = 254)
    @NotBlank
    @NaturalId
    @Email
    @Column(length = 254, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
