package com.myapp.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.AdminData;

@Repository
public class AdminLoginRepositoryImpl implements AdminLoginRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public AdminData validateLoggedInAdmin(String userName) {
		// TODO Auto-generated method stub
		System.out.println("input login id:" + userName);
		String SQL = "SELECT * FROM admincredentials WHERE USERNAME = ?";

		return jdbcTemplate.query(SQL, new Object[] { userName }, new ResultSetExtractor<AdminData>() {

			@Override
			public AdminData extractData(ResultSet rs) throws SQLException, DataAccessException {
				AdminData adminData = new AdminData();
				while (rs.next()) {
					adminData.setPassword(rs.getString("password"));
					adminData.setUsername(rs.getString("username"));
				}
				return adminData;

			}

		});

	}

}
