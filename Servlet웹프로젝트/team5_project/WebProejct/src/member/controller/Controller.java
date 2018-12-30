package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public interface Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
}
