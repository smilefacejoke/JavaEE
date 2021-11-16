package com.exp.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 54350
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {
    private String name;
    private String addr;
    private int cid;

}
