package com.ewinner.ssmptest.Controller;

import com.ewinner.ssmptest.Common.Models.Staff;
import com.ewinner.ssmptest.Interfaces.IStaffServiceMP;
import com.ewinner.ssmptest.Services.StaffServiceMP;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/StaffsMP")
public class StaffMPController {
    private final StaffServiceMP staffServiceMP;
    // private final IStaffServiceMP staffServiceMP;

    public StaffMPController(StaffServiceMP staffServiceMP) {
        this.staffServiceMP = staffServiceMP;
    }

    @PutMapping
    public Boolean saveStaff(@RequestBody Staff staff) {
        return staffServiceMP.saveOrUpdate(staff);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStaff(@PathVariable Integer id) {
        return staffServiceMP.removeById(id);
    }

    @PostMapping
    public Boolean updateStaff(@RequestBody Staff staff) {
        return staffServiceMP.saveOrUpdate(staff);
    }

    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable Integer id) {
        return staffServiceMP.getById(id);
    }

    @GetMapping
    public List<Staff> getAllStaffs() {
        // return staffServiceMP.getBaseMapper().selectList(null);
        return staffServiceMP.list();
    }
}