package com.example.mebel2.Entities;

import com.example.mebel2.Enums.WORKER_ROLE;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
public class Worker{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;
    @Enumerated(EnumType.STRING)
    WORKER_ROLE workerRole;

}
