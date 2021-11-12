package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class implements Serializable {
    private Integer cid;

    private String cname;

    private static final long serialVersionUID = 1L;

}