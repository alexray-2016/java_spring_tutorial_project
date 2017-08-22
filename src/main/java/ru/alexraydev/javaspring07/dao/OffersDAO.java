package ru.alexraydev.javaspring07.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("offersDao")
public class OffersDAO {

    private RowMapper<Offer> rowMapper = new RowMapper<Offer>() {
        @Override
        public Offer mapRow(ResultSet resultSet, int i) throws SQLException {
            Offer offer = new Offer();

            offer.setId(resultSet.getInt("id"));
            offer.setName(resultSet.getString("name"));
            offer.setEmail(resultSet.getString("email"));
            offer.setText(resultSet.getString("text"));

            return offer;
        }
    };

    private NamedParameterJdbcTemplate jdbcTemplate;

    public OffersDAO() {
        System.out.println("Successfully loaded OffersDAO");
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Offer> getOffers() {

        return jdbcTemplate.query("SELECT * FROM OFFERS", rowMapper);
    }

    public Offer get(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject("SELECT * FROM OFFERS WHERE id = :id", params, rowMapper);
    }

    public boolean delete(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbcTemplate.update("DELETE FROM OFFERS WHERE id = :id", params) == 1;
    }

    public boolean create(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

        return jdbcTemplate.update("INSERT INTO OFFERS (NAME, TEXT, EMAIL) VALUES (:name, :text, :email)", params) == 1;
    }

    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

        return jdbcTemplate.update("UPDATE OFFERS SET name = :name, text = :text, email = :email WHERE id = :id", params) == 1;
    }
}
