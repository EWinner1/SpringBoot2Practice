package com.ewinner.ssmptest.Services;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ewinner.ssmptest.Common.Daos.StaffDao;
import com.ewinner.ssmptest.Common.Models.Staff;
import com.ewinner.ssmptest.Interfaces.IStaffServiceMP;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceMP extends ServiceImpl<StaffDao, Staff> implements IStaffServiceMP {

}
