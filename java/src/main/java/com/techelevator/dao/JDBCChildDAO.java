package com.techelevator.dao;

import com.techelevator.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
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

    public Child addChild(Child child) {
        String sql = "INSERT INTO child (child_name, user_id, icon_name) VALUES (?,?,?);";

        jdbcTemplate.update(sql, child.getName(), child.getFamilyId(), child.getIcon());

        return child;
    }

    public Child retrieveChild(int childId) {
        Child child = new Child();
        String sql = "SELECT child.child_id, child.child_name, child.icon_name, sum(book_log.minutes)\n" +
                "FROM child\n" +
                "JOIN book_log ON child.child_id = book_log.child_id\n" +
                "WHERE child.child_id = ?\n" +
                "GROUP BY child.child_id, child.child_name, child.icon_name";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, childId);

        while (results.next()) {
            child = mapRowToChild(results);
            child.setMinutes(results.getInt("sum"));
        }

        return child;
    }


    private Child mapRowToChild(SqlRowSet result){
        Child child = new Child();
        child.setChildId(result.getInt("child_id"));
        child.setName(result.getString("child_name"));
        child.setIcon(result.getString("icon_name"));

        return child;
    }
}
