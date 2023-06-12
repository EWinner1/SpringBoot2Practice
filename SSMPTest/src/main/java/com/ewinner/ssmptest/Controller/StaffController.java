package com.ewinner.ssmptest.Controller;

import com.ewinner.ssmptest.Common.Models.Staff;
import com.ewinner.ssmptest.Interfaces.IStaffService;
import com.ewinner.ssmptest.Services.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Staffs")
public class StaffController {
    private final IStaffService staffService;
    // private final StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }
    @PutMapping
    public Boolean saveStaff(@RequestBody Staff staff) {
        return staffService.save(staff);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStaff(@PathVariable Integer id) {
        return staffService.delete(id);
    }

    @PostMapping
    public Boolean updateStaff(@RequestBody Staff staff) {
        return staffService.update(staff);
    }

    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable Integer id) {
        return staffService.getById(id);
    }

    @GetMapping
    public List<Staff> getAllStaffs() {
        // return staffServiceMP.getBaseMapper().selectList(null);
        return staffService.getAll();
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public List<Staff> getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        return staffService.getPage(currentPage, pageSize);
    }
}
