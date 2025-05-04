package com.practice.bookmarker_api.payLoads;

import java.time.Instant;

public interface BookmarkVM {

    Long getId();
    String getTitle();
    String getUrl();
    Instant getCreatedAt();

}
