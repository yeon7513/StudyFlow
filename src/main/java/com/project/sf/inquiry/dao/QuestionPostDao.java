package com.project.sf.inquiry.dao;

import com.project.sf.common.pager.Pager;
import com.project.sf.inquiry.model.QuestionPost;

import java.util.List;
import java.util.Map;

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
