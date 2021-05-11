package mate.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class ManufacturerDaoImpl implements ManufacturerDao {
    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        String insertManufacturerRequest = "INSERT INTO manufacturers (name, country) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement insertManufacturerStatement
                        = connection.prepareStatement(insertManufacturerRequest,
                        Statement.RETURN_GENERATED_KEYS)) {
            insertManufacturerStatement.setString(1, manufacturer.getName());
            insertManufacturerStatement.setString(2, manufacturer.getCountry());
            insertManufacturerStatement.executeUpdate();
            ResultSet resultSet = insertManufacturerStatement.getGeneratedKeys();
            if (resultSet.next()) {
                manufacturer.setId(resultSet.getObject(1, Long.class));
            }
            return manufacturer;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't create manufacturer. " + manufacturer + " ",
                    throwable);
        }
    }

    @Override
    public Optional<Manufacturer> get(Long id) {
        String selectManufacturerRequest = "SELECT * FROM manufacturers"
                + " WHERE id = (?) AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement selectManufacturerStatement
                        = connection.prepareStatement(selectManufacturerRequest)) {
            selectManufacturerStatement.setLong(1, id);
            ResultSet resultSet = selectManufacturerStatement.executeQuery();
            Manufacturer manufacturer = null;
            if (resultSet.next()) {
                manufacturer = getManufacturer(resultSet);
            }
            return Optional.ofNullable(manufacturer);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get manufacturer by id " + id + " ",
                    throwable);
        }
    }

    @Override
    public List<Manufacturer> getAll() {
        String selectAllManufacturersRequest = "SELECT * FROM manufacturers "
                + "WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement selectManufacturersStatement
                        = connection.prepareStatement(selectAllManufacturersRequest)) {
            List<Manufacturer> manufacturers = new ArrayList<>();
            ResultSet resultSet = selectManufacturersStatement.executeQuery();
            while (resultSet.next()) {
                manufacturers.add(getManufacturer(resultSet));
            }
            return manufacturers;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get a list of manufacturers "
                    + "from manufacturers table. ",
                    throwable);
        }
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        String updateManufacturerRequest = "UPDATE manufacturers SET name = ?, country = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateManufacturerStatement
                        = connection.prepareStatement(updateManufacturerRequest)) {
            updateManufacturerStatement.setString(1, manufacturer.getName());
            updateManufacturerStatement.setString(2, manufacturer.getCountry());
            updateManufacturerStatement.setLong(3, manufacturer.getId());
            updateManufacturerStatement.executeUpdate();
            return manufacturer;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't update a manufacturer "
                    + manufacturer + " ", throwable);
        }
    }

    @Override
    public boolean delete(Long id) {
        String removeManufacturerRequest
                = "UPDATE manufacturers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement removeManufacturerStatement
                        = connection.prepareStatement(removeManufacturerRequest)) {
            removeManufacturerStatement.setLong(1, id);
            return removeManufacturerStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't delete a manufacturer by id " + id + " ",
                    throwable);
        }
    }

    private Manufacturer getManufacturer(ResultSet resultSet) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(resultSet.getObject("id", Long.class));
        manufacturer.setName(resultSet.getString("name"));
        manufacturer.setCountry(resultSet.getString("country"));
        return manufacturer;
    }
}
