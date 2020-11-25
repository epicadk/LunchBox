package com.tip.lunchbox.model.server.response;

import java.util.List;

// Required for Moshi
@SuppressWarnings("unused")
public class CommentsResponseContainer {
    private List<CommentsResponse> comments;

    public List<CommentsResponse> getComments() {
        return comments;
    }
}
