package com.pengkey.servlet;

import com.pengkey.filter.FieldFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Myservlet extends HttpServlet{
    private static Logger logger = LoggerFactory.getLogger(Myservlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("--------------------------MyServlet is init-------------------");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("--------------------------MyServlet is invoke doGet()-------------------");

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("--------------------------MyServlet is invoke doPost()-------------------");
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("--------------------------MyServlet is invoke service()-------------------");
        super.service(req, resp);
    }
}
