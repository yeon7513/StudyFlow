package com.project.sf.qna.dao;

import java.util.List;
import com.project.sf.common.pager.AdminQnaPostSearch;
import com.project.sf.qna.AnswerPost;
import com.project.sf.qna.QuestionPost;

public interface AnswerPostDao {

  void registerAnswerPost(AnswerPost answerPost);

  List<QuestionPost> loadAllPosts(AdminQnaPostSearch pager);

  int totalCountPost(AdminQnaPostSearch pager);

}
