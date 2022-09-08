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
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class ManufacturerDaoImpl implements ManufacturerDao {
    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        String createManufacturerQuery = "INSERT INTO manufacturers (name, country) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createManufacturerStatement
                     = connection.prepareStatement(createManufacturerQuery, Statement.RETURN_GENERATED_KEYS)) {
            createManufacturerStatement.setString(1, manufacturer.getName());
            createManufacturerStatement.setString(2, manufacturer.getCountry());
            createManufacturerStatement.executeUpdate();
            ResultSet resultSet = createManufacturerStatement.getGeneratedKeys();
            if (resultSet.next()) {
                manufacturer.setId(resultSet.getObject(1, Long.class));
            }
            return manufacturer;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create manufacturer. " + manufacturer, e);
        }
    }

    @Override
    public Optional<Manufacturer> get(Long id) {
        String getManufacturerQuery = "SELECT * FROM manufacturers"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getManufacturerStatement
                     = connection.prepareStatement(getManufacturerQuery)) {
            getManufacturerStatement.setLong(1, id);
            ResultSet resultSet = getManufacturerStatement.executeQuery();
            Manufacturer manufacturer = null;
            if (resultSet.next()) {
                manufacturer = getManufacturer(resultSet);
            }
            return Optional.ofNullable(manufacturer);
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get manufacturer by id " + id, e);
        }
    }

    @Override
    public List<Manufacturer> getAll() {
        String getAllManufacturerQuery = "SELECT * FROM manufacturers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getAllStatement
                     = connection.prepareStatement(getAllManufacturerQuery)) {
            List<Manufacturer> manufacturers = new ArrayList<>();
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                manufacturers.add(getManufacturer(resultSet));
            }
            return manufacturers;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of manufacturers "
                    + "from manufacturers table.", e);
        }
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        String updateManufacturerQuery = "UPDATE manufacturers SET name = ?, country = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateManufacturerStatement
                     = connection.prepareStatement(updateManufacturerQuery)) {
            updateManufacturerStatement.setString(1, manufacturer.getName());
            updateManufacturerStatement.setString(2, manufacturer.getCountry());
            updateManufacturerStatement.setLong(3, manufacturer.getId());
            updateManufacturerStatement.executeUpdate();
            return manufacturer;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update a manufacturer "
                    + manufacturer, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteManufacturerQuery = "UPDATE drivers SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement deleteStatement
                     = connection.prepareStatement(deleteManufacturerQuery)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete a manufacturer by id " + id, e);
        }
    }

    private Manufacturer getManufacturer(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String country = resultSet.getString("country");
        return new Manufacturer(id, name, country);
    }
}
