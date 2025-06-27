package com.green.memoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MemoGetOneRes {
    private int id;
    private String title;

    @JsonProperty("ctnts") // 이건 백엔드랑 프론트 이름 매핑 이렇게 하면 json응답이 ctnts로 넘어간다
    private String content;

    @JsonProperty("created_at")
    private String createdAt;
}
