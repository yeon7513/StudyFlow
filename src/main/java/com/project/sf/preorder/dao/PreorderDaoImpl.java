package com.project.sf.preorder.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PreorderDaoImpl implements PreorderDao {

  @Autowired
  SqlSession sql;



}
