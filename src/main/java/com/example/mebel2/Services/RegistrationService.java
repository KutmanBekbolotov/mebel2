package com.example.mebel2.Services;
import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final PasswordEncoder passwordEncoder;
    private final WorkerRepository workerRepository;

    @Transactional
    public void register(Worker worker){
        String pass = passwordEncoder.encode(worker.getPassword());
        worker.setPassword(pass);
        workerRepository.save(worker);
    }
    public Worker currentUser (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails personDetails = (UserDetails) authentication.getPrincipal();
        String username =  personDetails.getUsername();
        Optional<Worker>userOptional = workerRepository.findUserByUsername(username);
        return userOptional.orElse(null);
    }

}
