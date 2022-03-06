package com.yongqin.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yongqin.mybank.ApplicationLauncher;
import com.yongqin.mybank.context.Application;
import com.yongqin.mybank.models.Transaction;
import com.yongqin.mybank.services.TransactionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class myBankServlet extends HttpServlet{
    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

        this.transactionService = ctx.getBean(TransactionService.class);
        this.objectMapper = ctx.getBean(ObjectMapper.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getRequestURI().equalsIgnoreCase("/")){
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print("<html>\n" +
                    "<body>\n" +
                    "<h1>Hello World</h1>\n" +
                    "<p>This is my Bank Page!</p>\n" +
                    "</body>\n" +
                    "</html>");
        }else if(req.getRequestURI().equalsIgnoreCase("/transactions")){
            resp.setContentType("application/json; charset=UTF-8");
            List<Transaction> transactions = transactionService.findAll();
            resp.getWriter().print(objectMapper.writeValueAsString(transactions));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(req.getParameter("amount")));
            String ref = req.getParameter("reference");

            Transaction transaction = transactionService.create(amount,ref);;

            resp.setContentType("application/json; charset=UTF-8");
            String json = objectMapper.writeValueAsString(transaction);
            resp.getWriter().print(json);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }
    }
}
