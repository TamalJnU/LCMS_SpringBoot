package tamal.lcms_spring_boot.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.User;
import tamal.lcms_spring_boot.model.UserDTO;
import tamal.lcms_spring_boot.repos.UserRepository;
import tamal.lcms_spring_boot.util.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        final List<User> users = userRepository.findAll(Sort.by("id"));
        return users.stream()
                .map((user) -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());   //.toList() cilo age
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map((user) -> mapToDTO(user, new UserDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setDepartmentId(user.getDepartmentId());
        userDTO.setDepartment(user.getDepartment());
        userDTO.setGender(user.getGender());
        userDTO.setPassword(user.getPassword());
        userDTO.setConfirmPassword(user.getConfirmPassword());
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setDepartmentId(userDTO.getDepartmentId());
        user.setDepartment(userDTO.getDepartment());
        user.setGender(userDTO.getGender());
        user.setPassword(userDTO.getPassword());
        user.setConfirmPassword(userDTO.getConfirmPassword());
        return user;
    }

}
