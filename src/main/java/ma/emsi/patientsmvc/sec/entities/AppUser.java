package ma.emsi.patientsmvc.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.patientsmvc.sec.entities.AppRole;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id
    private String userId;
    @Column(unique = true)
    private String username;
    @Email
    private String email;
    private String password;
    private boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    //chercher automatiquement les infos pour gerer les droits d'acces
    private List<AppRole> appRoles=new ArrayList<>();


}
