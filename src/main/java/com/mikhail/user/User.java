package com.mikhail.user;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.ticket.Ticket;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NaturalId
    @NotBlank
    @Column(name = "iam_Id", unique = true, nullable = false)
    private String iamId;

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

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
