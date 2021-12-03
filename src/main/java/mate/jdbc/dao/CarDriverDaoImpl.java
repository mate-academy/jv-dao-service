package mate.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.CarDriver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class CarDriverDaoImpl implements CarDriverDao {
    @Override
    public CarDriver create(CarDriver carDriver) {
        String query = "INSERT INTO car_drivers (name, license_number) VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createCarDriverStatement
                        = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            createCarDriverStatement.setString(1, carDriver.getName());
            createCarDriverStatement.setString(2, carDriver.getLicenseNumber());
            createCarDriverStatement.executeUpdate();
            ResultSet resultSet = createCarDriverStatement.getGeneratedKeys();
            if (resultSet.next()) {
                carDriver.setId(resultSet.getObject(1, Long.class));
            }
            return carDriver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create new carDriver: " + carDriver, e);
        }
    }

    @Override
    public Optional<CarDriver> get(Long id) {
        String query = "SELECT * FROM car_drivers"
                + " WHERE id = (?) AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getCarDriverStatement
                        = connection.prepareStatement(query)) {
            getCarDriverStatement.setLong(1, id);
            ResultSet resultSet = getCarDriverStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getCarDriver(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create get carDriver by id: " + id, e);
        }
    }

    @Override
    public List<CarDriver> getAll() {
        String query = "SELECT * FROM car_drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllCarDriversStatement
                        = connection.prepareStatement(query)) {
            ResultSet resultSet = getAllCarDriversStatement.executeQuery();
            List<CarDriver> carDrivers = new ArrayList<>();
            while (resultSet.next()) {
                carDrivers.add(getCarDriver(resultSet));
            }
            return carDrivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all car_drivers!", e);
        }
    }

    @Override
    public CarDriver update(CarDriver carDriver) {
        String query = "UPDATE car_drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateCarDriversStatement
                        = connection.prepareStatement(query)) {
            updateCarDriversStatement.setString(1, carDriver.getName());
            updateCarDriversStatement.setString(2, carDriver.getLicenseNumber());
            updateCarDriversStatement.setLong(3, carDriver.getId());
            updateCarDriversStatement.executeUpdate();
            return carDriver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update car driver: " + carDriver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE car_drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteCarDriverStatement
                        = connection.prepareStatement(query)) {
            deleteCarDriverStatement.setLong(1, id);
            return deleteCarDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete car driver by id: " + id, e);
        }
    }

    private CarDriver getCarDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(1, Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        return new CarDriver(id, name, licenseNumber);
    }
}
