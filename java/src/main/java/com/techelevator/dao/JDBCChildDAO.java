package com.techelevator.dao;

import com.techelevator.model.Child;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCChildDAO implements ChildDAO{

    private JdbcTemplate jdbcTemplate;

    public List<Child> listAllChildren(int familyAccountId) {
        List<Child> childList = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM child " +
                "WHERE user.id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, familyAccountId);
        

        return childList;
    }

}
