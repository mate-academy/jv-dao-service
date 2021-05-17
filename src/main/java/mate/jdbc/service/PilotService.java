package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Pilot;

public interface PilotService {
    Pilot create(Pilot pilot);

    Pilot get(Long id);

    List<Pilot> getAll();

    Pilot update(Pilot pilot);

    boolean delete(Long id);
}
