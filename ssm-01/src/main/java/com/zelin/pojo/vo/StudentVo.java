package com.zelin.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ------------------------------
 * 功能：查询参数对象
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/10-9:51
 * ------------------------------
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {
    private String sname;
    private String addr;
    private int cid;
}
