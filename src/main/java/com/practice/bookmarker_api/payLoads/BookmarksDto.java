package com.practice.bookmarker_api.payLoads;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.bookmarker_api.models.Bookmark;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class BookmarksDto {


    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;


    public BookmarksDto(Page<BookmarkDTO> bookmarkPage)
    {
        this.setData(bookmarkPage.getContent());
        this.setTotalElements( bookmarkPage.getTotalElements());
        this.setTotalPages(bookmarkPage.getTotalPages());
        this.setCurrentPage(bookmarkPage.getNumber()+1);
        this.setFirst(bookmarkPage.isFirst());
        this.setLast(bookmarkPage.isLast());
        this.setHasNext(bookmarkPage.hasNext());
        this.setHasPrevious(bookmarkPage.hasPrevious());
    }



}
