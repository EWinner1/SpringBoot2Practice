package com.ewinner.ssmptest.Controller;

import com.ewinner.ssmptest.Common.Models.Staff;
import com.ewinner.ssmptest.Common.Utils.Result;
import com.ewinner.ssmptest.Interfaces.IStaffService;
import com.ewinner.ssmptest.Services.StaffService;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/StaffsResult")
public class StaffControllerWithResult {
    private final IStaffService staffService;
    // private final StaffService staffService;

    public StaffControllerWithResult(StaffService staffService){
        this.staffService = staffService;
    }
    @PutMapping
    public Result saveStaff(@RequestBody Staff staff) {
        return new Result(staffService.save(staff), staff, null);
    }

    @DeleteMapping("/{id}")
    public Result deleteStaff(@PathVariable Integer id) {
        return new Result(staffService.delete(id), null, null);
    }

    @PostMapping
    public Result updateStaff(@RequestBody Staff staff) {
        return new Result(staffService.update(staff), staff, null);
    }

    @GetMapping("/{id}")
    public Result getStaff(@PathVariable Integer id) {
        return new Result(true, staffService.getById(id), null);
    }

    @GetMapping
    public Result getAllStaffs() {
        return new Result(true, staffService.getAll(), null);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Staff staff){
        return new Result(true, staffService.getPage(currentPage, pageSize, staff), null);
    }

}
