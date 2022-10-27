package com.example.springbootexercise221027.controller;

import com.example.springbootexercise221027.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value ="/hello2", method = RequestMethod.POST)
    public String hello2() {
        return "Hello World2";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map ->
                sb.append(map.getKey()+":"+map.getValue()+"\n"));
        return sb.toString();
    }

    @PostMapping("/member2")
    public String PostMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PostMapping("/member3")
    public ResponseEntity<MemberDto> PostMemberDto2(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
