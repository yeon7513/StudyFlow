package com.project.sf.inquiry.dao;

import com.project.sf.common.pager.AdminInquiryPostSearch;
import com.project.sf.inquiry.AnswerPost;
import com.project.sf.inquiry.QuestionPost;

import java.util.List;

public interface AnswerPostDao {

  void registerAnswerPost(AnswerPost answerPost);

  List<QuestionPost> loadAllPosts(AdminInquiryPostSearch pager);

  int totalCountPost(AdminInquiryPostSearch pager);

  QuestionPost loadOldestNoAnswerPost(AdminInquiryPostSearch pager);

  void updateAnswerState(Long postNo);
}
