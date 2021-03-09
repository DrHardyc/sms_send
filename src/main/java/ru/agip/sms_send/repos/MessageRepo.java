package ru.agip.sms_send.repos;

import org.springframework.data.repository.CrudRepository;
import ru.agip.sms_send.domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByText(String text);

}
