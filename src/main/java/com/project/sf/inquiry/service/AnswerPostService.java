package com.project.sf.inquiry.service;

import com.project.sf.common.pager.AdminInquiryPostSearch;
import com.project.sf.inquiry.AnswerPost;
import com.project.sf.inquiry.QuestionPost;

import java.util.List;

public interface AnswerPostService {

  List<QuestionPost> loadAllPosts(AdminInquiryPostSearch pager);

  QuestionPost loadOldestNoAnswerPost(AdminInquiryPostSearch pager);

  void registerAnswerPost(AnswerPost answerPost);
}
