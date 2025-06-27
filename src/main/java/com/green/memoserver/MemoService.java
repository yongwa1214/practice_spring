package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // 이거 안쓰면 final 어쩌구 빨간줄 뜸
                         // di 받고싶은 애들만 final 을 붙여서 사용할 수도 있음
                         // final 이 붙은 애들만 생성자 만들어줌
                         // @ AllArgsConstructor과 함께 사용할 수 없음
@Service // 빈등록을 해야 스프링이 객체 주소값을 갖고 있고 그걸 줄 수 있다. 기본 빈등록은 @Component
public class MemoService {
    //DI 받는 법 3가지
    // 1. 필드 주입
    // 2. setter 주입(메소드 주입)
    // 3. 생성자 주입 (추천)

    private final MemoMapper memoMapper;

    public int save(MemoPostReq p){
        return memoMapper.save(p);
    }

    public List<MemoGetRes> findAll(MemoGetReq req){
        return memoMapper.findAll(req);
    }

    public MemoGetOneRes findById(int id) {
        return memoMapper.findById(id);
    }

    public int deleteById(int id){
        return memoMapper.deleteById(id);
    }

    public int modify(MemoPutReq req){ // 수정하면 json으로 받음 객체라는뜻
        return memoMapper.modify(req);
    }

}
