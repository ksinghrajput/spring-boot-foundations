package com.codewithkishan.onlinestore.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoint;

    @OneToOne
    @JoinColumn(name = "id")
    @ToString.Exclude
    private User user;

}
