package com.green.memoserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemoPostReq {
    private String title;
    private String ctnts;
}
