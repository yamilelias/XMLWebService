<%@page contentType="text/xml" pageEncoding="UTF-8" %><%= new xmlgenerator.XMLStudents().getXLMByID(request.getParameter("id")) %>