package com.techelevator.dao;

import com.techelevator.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JDBCChildDAO implements ChildDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Child> listAllChildren(int familyAccountId) {
        List<Child> childList = new ArrayList<>();
        String sql = "SELECT child.child_id, child.child_name, SUM(child_book.minutes)\n" +
                "FROM child\n" +
                "JOIN child_book ON child.child_id = child_book.child_id\n" +
                "WHERE user_id = ?\n" +
                "GROUP BY child.child_id";
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
        child.setMinutes(result.getInt("sum"));


        return child;
    }
}
