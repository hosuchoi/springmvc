package lake.pool.webmvc.sample.simplemvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents(){
        Event one = Event.builder()
                .name("spring web mvc 1차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 1, 10, 10, 0))
                .endDateTime(LocalDateTime.of(2020, 2, 20, 2, 0))
                .build();

        Event two = Event.builder()
                .name("spring web mvc 2차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 1, 10, 10, 0))
                .endDateTime(LocalDateTime.of(2020, 2, 20, 2, 0))
                .build();

        ArrayList<Event> list = new ArrayList<>();
        list.add(one);
        list.add(two);

        return List.of(one,two);
    }
}
