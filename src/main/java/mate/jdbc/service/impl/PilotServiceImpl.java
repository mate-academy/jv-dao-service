package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.PilotDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Pilot;
import mate.jdbc.service.PilotService;

@Service
public class PilotServiceImpl implements PilotService {
    @Inject
    private PilotDao pilotDao;

    @Override
    public Pilot create(Pilot pilot) {
        return pilotDao.create(pilot);
    }

    @Override
    public Pilot get(Long id) {
        return pilotDao.get(id).orElseThrow(() ->
                new DataProcessingException("Can't get pilot from DB by id = " + id));
    }

    @Override
    public List<Pilot> getAll() {
        return pilotDao.getAll();
    }

    @Override
    public Pilot update(Pilot pilot) {
        return pilotDao.update(pilot);
    }

    @Override
    public boolean delete(Long id) {
        return pilotDao.delete(id);
    }
}
