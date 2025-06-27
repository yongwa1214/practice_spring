package com.green.memoserver;

import com.green.memoserver.model.*;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    int save(MemoPostReq req);

    // 매개변수쪽에 줘 나가는건 이름 앞으로 나가 st
    // MemoGetReq를 받고(자료를 찾기 위해 받음) >> 쿼리만드는 곳까지 끌고 가는 쪽 controller > service> mapper
    // MemoGetRes로 줌 mapper>service > controller
    List<MemoGetRes> findAll (MemoGetReq req);
    MemoGetOneRes findById(int id);

    int modify(MemoPutReq req); // 결과값이 1인 이유: 영향받은 행이 1개라는뜻
    int deleteById(int id);
}

