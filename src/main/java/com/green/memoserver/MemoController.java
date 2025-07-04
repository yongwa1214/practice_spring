package com.green.memoserver;


import com.green.memoserver.config.model.ResultResponse;
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

    //insert, update, delete는 ResultResponse를 사용할 때 integer를 주면됨(영향 받은 행)(무조건은 아님)

    //Create
    //(post) /api/memo, 응답으로는 저장 성공 내용들이 백엔드 서버에 출력
    @PostMapping
    public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req) { //JSON로 넘어오는구나
        log.info("req={}", req);
        int result = memoService.save(req);
        String result2 = (result == 1) ? "등록 성공": "등록 실패";
        return new ResultResponse<>(result2, result);
    }

    //Read
    //리스트 들고오기
    @GetMapping
    public ResultResponse <List<MemoGetRes>> getMemo(@ModelAttribute MemoGetReq req){
        log.info("req={}",req);
        List<MemoGetRes> result = memoService.findAll(req);
        String message = String.format("Rows: %d", result.size());
        return new ResultResponse<>(message, result);
    }


    // 아이템 들고오기 디테일
    @GetMapping("{memoId}")
    public ResultResponse<MemoGetOneRes> getMemo(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        MemoGetOneRes result = memoService.findById(memoId);
        return new ResultResponse<>("조회 성공", result);
    }

    //Update
    @PutMapping
    public ResultResponse<Integer> putMemo(@RequestBody MemoPutReq req){
        int result = memoService.modify(req);
        String result2 = (result == 1) ? "수정 성공": "수정 실패";
        return new ResultResponse<>(result2, result);
    }

    //Delete
    @DeleteMapping
    public ResultResponse<Integer> delMemo(@RequestParam("memo_id") int memoId ){
        log.info("memo_id:{}", memoId);
        int result = memoService.deleteById(memoId);
        String result2 = (result == 1) ? "삭제 성공": "삭제 실패";
        return new ResultResponse<>(result2, result); // 여기선 정상적인 것만 취급하고 예외는 따로 처리한다
    }
}
