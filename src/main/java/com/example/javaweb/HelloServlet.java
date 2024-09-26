package com.example.javaweb;

import java.io.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
//@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>Thanks!</title></head>");
        out.write("<body>");

        // Demo purposes only - don't do this in production!
        String name = request.getParameter("name");
        String favFruit = request.getParameter("favFruit");
        String validationRegex = "^[a-zA-Z\\s]+";
        if(name.matches(validationRegex) && favFruit.matches(validationRegex)) {
            Person person = new Person();
            person.setName(name);
            person.setFavFruit(favFruit);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();

            out.write("<h1>Saved!</h1>");

            out.write("<table border ='1'>");
            out.write("<tr>");
            out.write("<th>Name          </th>");
            out.write("<th>Favorite Fruit</th>");
            out.write("</tr>");

            List<Person> people = em
                    .createQuery("Select p from Person p", Person.class)
                    .getResultList();
            for (Person p: people) {
                out.write("<tr>");
                out.write("<td>" + p.getName() +"</td>");
                out.write("<td>" + p.getFavFruit() +"</td>");
                out.write("</tr>");
            }

            out.write("</table>");
        } else {
            out.write("<h1>Sorry! I only accept letters!</h1>");
        }

        out.write("<br><a href=\"index.jsp\">Back to Form</a>");
        out.write("</body></html>");
    }
    public void destroy() {
    }
}