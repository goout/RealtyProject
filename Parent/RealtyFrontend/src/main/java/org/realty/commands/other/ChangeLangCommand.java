package org.realty.commands.other;

import org.realty.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Vovan
 * Date: 24.08.12
 * Time: 10:39
 */
public class ChangeLangCommand implements Command {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     return request.getRequestURI();
  }
}
