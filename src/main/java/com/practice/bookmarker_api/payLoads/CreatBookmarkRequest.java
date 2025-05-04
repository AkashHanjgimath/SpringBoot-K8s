package com.practice.bookmarker_api.payLoads;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatBookmarkRequest {

    @NotNull(message = "Title Should not be empty")
    private String title;
    @NotNull(message = "Url Should not be empty")
    private String url;
}
