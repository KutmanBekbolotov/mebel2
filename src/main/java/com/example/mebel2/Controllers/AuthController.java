package com.example.mebel2.Controllers;

import com.example.mebel2.Dto.Input.WorkerDto;
import com.example.mebel2.Entities.Worker;
import com.example.mebel2.Repositories.WorkerRepository;
import com.example.mebel2.Services.RegistrationService;
import com.example.mebel2.Services.WorkerService;
import com.example.mebel2.Util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.example.mebel2.Dto.Input.AuthDto;


import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;
    ModelMapper modelMapper;
    MessageSource messageSource;
    WorkerService workerService;
    RegistrationService registrationService;
    @PostMapping("/registration")
//    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "*"})
    @Operation(summary = "Registration", description = "This request creates a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Worker.class)))) })
    public Map<String, String> performRegistration(@RequestBody @Valid WorkerDto workerDto,
                                                   BindingResult bindingResult) {
        Worker worker = workerService.toEntity(workerDto);
        String message  = "";
        //Проверяет подходить ли по валидации
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            assert fieldError != null;
            message = messageSource.getMessage(fieldError,null);
            return Map.of("message: ", message);
        }
        //Проверяет нет такого человека уже
        if(workerService.findByUsername(worker.getUsername()).isPresent()) {
            message = "User by this username exists";
            return Map.of(worker.getUsername(), message);
        }
        //Проверяет подходящие ли роли!
        if(!(workerDto.getRole().equals("ROLE_ADMIN")) && ! (workerDto.getRole().equals("ROLE_Worker"))){
            message = "Wrong type of role!";
            return Map.of(worker.getRole(), message);
        }
        registrationService.register(worker);
        //Если все норм то токен выдает!
        message = jwtUtil.generateToken(worker.getUsername());
        return Map.of("jwt-token: ",message);
    }

    @PostMapping("/login")
//    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "*"})
    @Operation(summary = "Login", description = "This request is used for logging in")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = AuthDto.class)))) })
    public Map<String, String> performLogin(@RequestBody AuthDto authDto) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authDto.getUsername(),
                        authDto.getPassword());
        String message  = "";
        try {
            authenticationManager.authenticate(authInputToken);
        } catch (BadCredentialsException e) {
            message = "Incorrect credentials!";
            return Map.of("message",message);
        }

        message = jwtUtil.generateToken(authDto.getUsername());
        return Map.of("jwt-token",message);
    }




}
