package com.myapp.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.UserData;

@Repository
public class UserLoginRepositoryImpl implements UserLoginRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	String rlun;

	@Override
	public UserData validateLoggedInUser(String userName) {

		System.out.println("input login id:" + userName);
		String SQL = "SELECT * FROM CREDENTIALS WHERE USERNAME = ?";
		// return jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(UserData.class),
		// userName);

		return jdbcTemplate.query(SQL, new Object[] { userName }, new ResultSetExtractor<UserData>() {

			@Override
			public UserData extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserData userData = new UserData();
				while (rs.next()) {
					userData.setUsername(rs.getString("username"));
					rlun = userData.getUsername();
					userData.setPassword(rs.getString("password"));
				}
				return userData;

			}

		});

	}

}