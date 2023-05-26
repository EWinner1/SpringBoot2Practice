package com.ewinner.integration.Common.Implements;

import com.ewinner.integration.Common.Models.IBookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements IBookDao {
    @Override
    public void save() {
        System.out.println("Book Dao run...");
    }
}
