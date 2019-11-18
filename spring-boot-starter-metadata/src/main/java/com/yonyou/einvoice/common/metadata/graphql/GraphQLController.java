package com.yonyou.einvoice.common.metadata.graphql;

import graphql.servlet.GraphQLServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * graphql的controller，用于指定graphql服务的url
 *
 * @author liuqiangm
 */
@Slf4j
@Controller
public class GraphQLController {


  @Autowired
  @Qualifier("graphQLServlet")
  private GraphQLServlet servlet;

  @Autowired
  @Qualifier("testGQLServlet")
  private GraphQLServlet testServlet;


  /**
   * graphql接口
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   * @author liuqiangm
   */
  @RequestMapping(value = "/onlineql", method = RequestMethod.POST)
  public void onlineql(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    servlet.service(request, response);
  }

  /**
   * testgql接口
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   * @author liuqiangm
   */
  @RequestMapping(value = "/testql", method = RequestMethod.POST)
  public void testql(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    testServlet.service(request, response);
  }

}