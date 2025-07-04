package com.green.memoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MemoGetOneRes {
    @JsonProperty("memoId") // 오픈API 통신시 사용할지도? 받는 이름을 적어주면 됨
    private int id;

    private String title;

    @JsonProperty("ctnts") // 이건 백엔드랑 프론트 이름 매핑 이렇게 하면 json응답이 ctnts로 넘어간다
    private String content;


    private String createdAt;
}
