package org.example.myapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path =  request.getParameterMap().containsKey("path") ? request.getParameter("path") : "/Users/macuser/angular/first";
        File file = new File(path);
        File[] files = file.listFiles();
        Map<String, List> states = new HashMap<>();
        for(File f: files){
            List<String> filesFolders = new ArrayList<String>();
            if (f.isDirectory()) {
                filesFolders.add("folder");
                filesFolders.add(f.getAbsolutePath());
                states.put(f.getName(), filesFolders);
            } else {
                filesFolders.add("file");
                filesFolders.add(f.getAbsolutePath());
                states.put(f.getName(), filesFolders);
            }
        }
        String parent = file.getParentFile().getAbsolutePath();
        request.setAttribute("list", states);
        request.setAttribute("parent", parent);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
