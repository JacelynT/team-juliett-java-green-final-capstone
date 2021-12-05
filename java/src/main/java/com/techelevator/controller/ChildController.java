package com.techelevator.controller;

import com.techelevator.dao.ChildDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Child;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        int familyAccountId = userDAO.findIdByUsername(familyAccount.getName());
        return childDAO.listAllChildren(familyAccountId);
    }

}
