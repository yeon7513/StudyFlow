package com.project.sf.qna.service;

import java.util.List;
import com.project.sf.common.pager.Pager;
import com.project.sf.qna.QuestionPost;

public interface QnaService {

  List<QuestionPost> loadQnaPosts(Pager pager);

  QuestionPost loadQnaPostDetailByNo(Long no);

  boolean checkPassword(Long no, String postPw);

  void modifyPost(QuestionPost questionPost);

  void deletePost(Long no);

  QuestionPost findQnaPostByNo(Long no);

  Long registerPost(QuestionPost questionPost);

}
