package tk.lens.solution.web.webflux.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.lens.solution.web.webflux.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
    
}