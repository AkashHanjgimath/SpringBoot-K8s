package com.practice.bookmarker_api.controller;


import com.practice.bookmarker_api.payLoads.BookmarksDto;
import com.practice.bookmarker_api.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDto getBookmarks(@RequestParam(name = "page",defaultValue = "1")Integer page){
        return bookmarkService.getBookmark(page);
    }
}
