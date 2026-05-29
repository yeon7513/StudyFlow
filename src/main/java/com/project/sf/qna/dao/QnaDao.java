package com.project.sf.qna.dao;

import java.util.List;
import java.util.Map;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.QuestionPost;

public interface QnaDao {

  List<QuestionPost> loadQnaPosts(Pager pager);

  QuestionPost loadQnaPostDetailByNo(Long no);

  int checkPassword(Map<String, Object> params);

  void modifyPost(QuestionPost questionPost);

  void deletePost(Long no);

  QuestionPost findQnaPostByNo(Long no);

  Long registerPost(QuestionPost questionPost);

  int totalCountPost(Pager pager);

}
