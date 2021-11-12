package com.service;

import com.pojo.Class;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 54350
 */

public interface ClassService {
    List<Class> findAll();
}
