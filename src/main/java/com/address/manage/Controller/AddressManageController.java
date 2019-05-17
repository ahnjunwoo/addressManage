package com.address.manage.Controller;

import com.address.manage.entity.AddressManage;
import com.address.manage.repository.AddressManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/address")
public class AddressManageController {
    @Autowired
    private AddressManageRepository addressManageRepository;
    @PostMapping("")
    private ResponseEntity<AddressManage> addressAdd(@RequestBody @Valid AddressManage addressManage) {
        AddressManage result = addressManageRepository.save(addressManage);
        result.add(linkTo(AddressManageController.class).withRel("list").withType("GET"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("")
    private ResponseEntity<List<AddressManage>> addressList() {
        List<AddressManage> result = addressManageRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("")
    private ResponseEntity<AddressManage> deleteAddress(@PathVariable("manageId") int manageId) {
        addressManageRepository.deleteById(manageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
