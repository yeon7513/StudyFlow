package com.project.sf.qna.dao;

import java.util.List;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.AnswerPost;
import com.project.sf.qna.QuestionPost;

public interface AnswerPostDao {

  void registerAnswerPost(AnswerPost answerPost);

  List<QuestionPost> loadNotAnsweredPost(Pager pager);

}
