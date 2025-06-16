package it.epicode.W6_D1_BE_Exercise.service;

import com.cloudinary.Cloudinary;
import it.epicode.W6_D1_BE_Exercise.dto.UserDto;
import it.epicode.W6_D1_BE_Exercise.exeption.NotFoundException;
import it.epicode.W6_D1_BE_Exercise.model.User;
import it.epicode.W6_D1_BE_Exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Cloudinary cloudinary;

    public User saveUser(UserDto dto) {
        User d = new User();
        d.setNome(dto.getNome());
        d.setCognome(dto.getCognome());
        d.setEmail(dto.getEmail());
        d.setPassword(dto.getPassword());
        return UserRepository.save(d);
    }

    public List<User> getAllDipendenti() {
        return UserRepository.findAll();
    }

    public void deleteUser(int id) throws NotFoundException{
        User userDaRimuovere = getUser(id);

        userRepository.delete(userDaRimuovere);
    }
}
