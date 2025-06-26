package com.green.memoserver.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
//@Setter 없어도됨
public class MemoGetRes {
    private int id;
    private String title;
    private String createdAt;

}
