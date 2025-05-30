package com.practice.bookmarker_api.controller;


import com.practice.bookmarker_api.payLoads.BookmarkDTO;
import com.practice.bookmarker_api.payLoads.BookmarksDto;
import com.practice.bookmarker_api.payLoads.CreatBookmarkRequest;
import com.practice.bookmarker_api.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDto getBookmarks(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                     @RequestParam(name="query",defaultValue = "")String query){
        if(query==null|| query.trim().length()==0){
            return bookmarkService.getBookmark(page);
        }
        return bookmarkService.searchBookmark(query,page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid CreatBookmarkRequest request)
    {
        return bookmarkService.createBookmark(request);
    }
}
