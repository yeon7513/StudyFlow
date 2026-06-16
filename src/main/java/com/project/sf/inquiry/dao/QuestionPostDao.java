package com.project.sf.inquiry.dao;

import java.util.List;
import java.util.Map;
import com.project.sf.common.pager.Pager;
import com.project.sf.inquiry.QuestionPost;

public interface QuestionPostDao {

  List<QuestionPost> loadQnaPosts(Pager pager);

  QuestionPost loadQnaPostDetailByNo(Long no);

  int checkPassword(Map<String, Object> params);

  void modifyPost(QuestionPost questionPost);

  void deletePost(Long no);

  QuestionPost findQnaPostByNo(Long no);

  Long registerPost(QuestionPost questionPost);

  int totalCountPost(Pager pager);

}
