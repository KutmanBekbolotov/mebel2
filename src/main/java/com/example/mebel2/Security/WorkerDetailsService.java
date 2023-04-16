package com.example.mebel2.Security;

import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkerDetailsService implements UserDetailsService{
    WorkerRepository workerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Worker> optionalWorker=  workerRepository.findUserByUsername(username);
        if(optionalWorker.isEmpty()){
            throw new UsernameNotFoundException("Такого пользователя не существует!");
        }
        else {
            return new WorkerDetails(optionalWorker.get());
        }
    }
}