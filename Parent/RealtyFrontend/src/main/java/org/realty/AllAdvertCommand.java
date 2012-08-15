package org.realty;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.Advert;

public class AllAdvertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		List<Advert> alladverts = ad.findAll();
		
		for (Advert o : alladverts) {

			out.printf("%10d %9s %12s %15s\n", o.getAdvertId(), o.getCategory(),
					o.getDistrict(), o.getAdress());
		}
		
		request.setAttribute("alladverts", alladverts);
		
		return "Advert.jsp";

	}

}