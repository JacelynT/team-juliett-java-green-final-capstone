package com.techelevator.dao;

import com.techelevator.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCChildDAO implements ChildDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Child> listAllChildren(int familyAccountId) {
        List<Child> childList = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM child\n" +
                "WHERE user_id = ?\n";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, familyAccountId);
        while (result.next()){
            Child child = mapRowToChild(result);
            childList.add(child);
        }

        return childList;
    }


    private Child mapRowToChild(SqlRowSet result){
        Child child = new Child();
        child.setChildId(result.getInt("child_id"));
        child.setName(result.getString("child_name"));
        child.setIcon(result.getString("icon_name"));

        return child;
    }
}
