/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.controller;

import com.mongo.dao.LoginDao;
import com.mongo.dao.ToDoDao;
import com.mongodb.BasicDBObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String url ="home.jsp";
        String action = request.getParameter("action");
        switch(action){
            case "delete":
                String _id = request.getParameter("task_id");
                String user_id = (String) request.getSession().getAttribute("id");
                
                ToDoDao.removeTask(_id);
                    List<BasicDBObject> toDoList = ToDoDao.getToDoList(user_id);
                    request.getSession().setAttribute("todo", toDoList);
                break;
            case "update":
                break;
            case "insert":
                break;
                
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String url = "home.jsp";
        String action = request.getParameter("action");
        switch(action){
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String id = LoginDao.validateLogin(username,password);
                if(id == null)
                    url="index.html";
                else{
                    request.getSession().setAttribute("id", id);
                    List<BasicDBObject> toDoList = ToDoDao.getToDoList(id);
                    request.getSession().setAttribute("todo", toDoList);
                }
                break;
            case "insert":
                String task = request.getParameter("todotext");
                String priority = request.getParameter("priority");
                String desc = request.getParameter("description");
                String user_id = (String) request.getSession().getAttribute("id");
                ToDoDao.saveTask(user_id,task,priority,desc);
                
                    List<BasicDBObject> toDoList = ToDoDao.getToDoList(user_id);
                    request.getSession().setAttribute("todo", toDoList);
                
                break;
                
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
