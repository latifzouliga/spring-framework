package com.cydeo.repsitory;

import com.cydeo.model.Comment;

public interface CommentRepository {

    void storeComment(Comment comment);
}
