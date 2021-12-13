package com.techelevator.dao;

import com.techelevator.model.Child;

import java.util.List;

public interface ChildDAO {

    public List<Child> listAllChildren(int familyAccountId);

    public Child addChild(Child child);

}
