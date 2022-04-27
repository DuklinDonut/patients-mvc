package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import ma.emsi.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    //@Bean
    //Bean sert à executer la commande line suivante
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"Hassan",new Date(),false,112));
            patientRepository.save(
                    new Patient(null,"Mohammed",new Date(),false,321));

            patientRepository.save(
                    new Patient(null,"Yassmine",new Date(),false,165));

            patientRepository.save(
                    new Patient(null,"Hanae",new Date(),false,132));

            patientRepository.findAll().forEach(p ->{
                System.out.println(p.getNom());
            } );
        };
    }
    @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("user1","lamia@g.com","1234","1234");
            securityService.saveNewUser("user2","mohamed@g.com","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("user1","ADMIN");
            securityService.addRoleToUser("user2","USER");
            //securityService.addRoleToUser("hassan","USER");
        };
    }
}
