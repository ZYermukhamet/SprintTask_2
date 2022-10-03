package servlets;

import main.DBManager;
import main.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet(name = "DetailsServlet", value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Publication publication = DBManager.getPublication(id);

        Set<String> sources = DBManager.getSources();
        String sourceDescription = DBManager.getSourceDescription(publication.getNews().getSource());

        request.setAttribute("publication", publication);
        request.setAttribute("source_description", sourceDescription);
        request.setAttribute("sources", sources);
        request.getRequestDispatcher("JSPs/details.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
