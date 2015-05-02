package web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public interface Command {

	String execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
	
}
