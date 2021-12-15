package com.techelevator.controller;

import com.techelevator.dao.ChildDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Child;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ChildController {

    @Autowired
    private ChildDAO childDAO;
    private UserDAO userDAO;


    @RequestMapping(path = "/account", method  = RequestMethod.GET)
    public List<Child> listAllChildren(Principal familyAccount) {
        //int familyAccountId = userDAO.findIdByUsername(familyAccount.getName());
        int temporaryId = 1;
        return childDAO.listAllChildren(temporaryId);
    }

    @RequestMapping(path = "/account/add-child", method  = RequestMethod.POST)
    public Child addChild(@RequestBody Child child) {
        child.setFamilyId(1);
        child.setIcon("dog-solid.png");
        return childDAO.addChild(child);
    }

    @RequestMapping(path = "/account/get-child/{childId}", method = RequestMethod.GET)
    public Child retrieveChild(@PathVariable int childId){
        return childDAO.retrieveChild(childId);
    }
}
