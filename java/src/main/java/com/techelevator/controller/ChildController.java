package com.techelevator.controller;

import com.techelevator.dao.ChildDAO;
import com.techelevator.model.Child;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ChildController {

    private ChildDAO childDAO;

    @RequestMapping(path = "/account", method  = RequestMethod.GET)
    public List<Child> listAllChildren() {
        return childDAO.listAllChildren();
    }

}
