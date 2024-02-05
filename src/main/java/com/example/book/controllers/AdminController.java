//package com.example.book.controllers;
//
//import com.example.book.dto.AllReadersResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/bookapp")
//@RequiredArgsConstructor
//public class AdminController {
//
//    private final ReaderService readerService;
//
//    @GetMapping("/readers")
//    public List<AllReadersResponse> getAll(){
//        return readerService.getAll();
//    }
//}
