package com.project.sf.inquiry.service;

import com.project.sf.common.pager.Pager;
import com.project.sf.inquiry.model.QuestionPost;

import java.util.List;

public interface QuestionPostService {

  List<QuestionPost> loadQnaPosts(Pager pager);

  QuestionPost loadQnaPostDetailByNo(Long no);

  boolean checkPassword(Long no, String postPw);

  void modifyPost(QuestionPost questionPost);

  void deletePost(Long no);

  QuestionPost findQnaPostByNo(Long no);

  Long registerPost(QuestionPost questionPost);

}
