package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author 54350
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionBeans {

    private String[] books;
    private List<Student> students;
    private Map<Integer,Student> map;
    private Properties properties;

}
