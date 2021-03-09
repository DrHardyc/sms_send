package ru.agip.sms_send.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agip.sms_send.domain.User;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
