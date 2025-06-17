package it.epicode.W6_D1_BE_Exercise.service;

import it.epicode.W6_D1_BE_Exercise.dto.UserDto;
import it.epicode.W6_D1_BE_Exercise.enumeration.Role;
import it.epicode.W6_D1_BE_Exercise.model.User;
import it.epicode.W6_D1_BE_Exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(UserDto userDto){
        User user = new User();
        user.setNome(userDto.getNome());
        user.setCognome(userDto.getCognome());
        user.setUsername(userDto.getUsername());
        //la password in chiaro che si trova nel dto, verrà passata come parametro al metodo encode dell'encoder
        //Bcrypt codificherà la password e genererà l'hash, questo hash viene settato sullo user e salvato su db
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setNome(String.valueOf(Role.USER));

        return userRepository.save(user);
    }

    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    public User getUser(int id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(id).
                orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public User updateUser(int id, UserDto userDto) throws ChangeSetPersister.NotFoundException {
        User userDaAggiornare = getUser(id);

        userDaAggiornare.setNome(userDto.getNome());
        userDaAggiornare.setCognome(userDto.getCognome());
        userDaAggiornare.setUsername(userDto.getUsername());
        if (!passwordEncoder.matches(userDto.getPassword(), userDaAggiornare.getPassword())){
            userDaAggiornare.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        return userRepository.save(userDaAggiornare);
    }

    public void deleteUser(int id) throws ChangeSetPersister.NotFoundException {
        User userDaCancellare = getUser(id);

        userRepository.delete(userDaCancellare);
    }
}
