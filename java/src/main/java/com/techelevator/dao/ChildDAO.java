package com.techelevator.dao;

import com.techelevator.model.Child;

import java.util.List;

public interface ChildDAO {

    List<Child> listAllChildren(int familyAccountId);

}
