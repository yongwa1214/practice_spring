package com.green.memoserver;


import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // 빈등록 & 요청과 응답도 처리해야하기 때문에 @RestController > JSon 즉 데이터를 주는게 목적
// @Controller 화면을 주는게 목적

//공통 URL
@RequestMapping("/api/memo") // 첫번째 /는 안적어도 알아서 들어감
@Slf4j // 로그 찍고 싶으면 sout말고 이걸 쓴다음 log.info("", )를 써준다
       // 이건 어느 클래스에서 어느 부분에 로그가 찍히는지 알 수있다.
public class MemoController {
    private final MemoService memoService;
    private final MemoMapper memoMapper;

    //Create
    //(post) /api/memo, 응답으로는 저장 성공 내용들이 백엔드 서버에 출력
    @PostMapping
    public String postMemo(@RequestBody MemoPostReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result =  memoService.save(req);
        return result == 1 ? "저장 성공" : "저장 실패";
    }

    //Read
    //리스트 들고오기
    @GetMapping
    public List<MemoGetRes> getMemo(@ModelAttribute MemoGetReq req){
        log.info("req={}",req);
        return memoService.findAll(req);
    }

    // 아이템 들고오기 디테일
    @GetMapping("{memoId}")
    public MemoGetOneRes getMemo(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        return memoService.findById(memoId);
    }

    //Update
    @PutMapping
    public String putMemo(@RequestBody MemoPutReq req){
        log.info("req{}:", req);
        return "수정완료";
    }

    //Delete
    @DeleteMapping
    public String delMemo(@RequestParam("memo_id") int memoId ){
        log.info("memo_id:{}", memoId);
        int result3 = memoService.deleteById(memoId);
        return "삭제 완료";
    }
}
