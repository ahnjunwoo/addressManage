package com.address.manage.Controller;

import com.address.manage.entity.AddressManage;
import com.address.manage.repository.AddressManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/address")
public class AddressManageController {
    @Autowired
    private AddressManageRepository addressManageRepository;
    @PostMapping("")
    private ResponseEntity<AddressManage> addressAdd(@RequestBody @Valid AddressManage addressManage) {
        AddressManage result = addressManageRepository.save(addressManage);
        result.add(linkTo(AddressManageController.class).slash(result.getId()).withRel("detail"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
