package com.green.memoserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

//@Builder // 생성자 경우의 수 다 만들어줌

@Getter
@ToString
public class MemoGetReq {
    private String searchText;
    private Integer page;

//    public MemoGetReq(@BindParam("search_text") String searchText, Integer page) {
//        this.searchText = searchText;
//        this.page = page;
//    }

    @ConstructorProperties({"search_text","page"})
    public MemoGetReq(String searchText, Integer page) {
        this.searchText = searchText;
        this.page = page;
    }
}
