package com.project.sf.qna.service;

import java.util.List;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.AnswerPost;
import com.project.sf.qna.QuestionPost;

public interface AnswerPostService {

  void registerAnswerPost(AnswerPost answerPost);

  List<QuestionPost> loadNotAnsweredPost(Pager pager);

}
