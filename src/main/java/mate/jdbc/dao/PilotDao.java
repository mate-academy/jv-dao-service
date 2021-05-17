package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Pilot;

public interface PilotDao {
    Pilot create(Pilot pilot);

    Optional<Pilot> get(Long id);

    List<Pilot> getAll();

    Pilot update(Pilot pilot);

    boolean delete(Long id);
}
