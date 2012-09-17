package org.realty.commands.other;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.dto.AdvertDTO;
import org.realty.entity.Advert;
import org.realty.hibernate.AdvertHibDAO;


public class IndexGuestCommand implements Command {
    private AdvertHibDAO advH;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

       // AdvertJdbcDAO ad = new AdvertJdbcDAO();
        //List<Advert> alladverts = ad.findAll();
        List<Advert> alladverts = advH.getAllAdverts();

        List<AdvertDTO> allAdvertsDto = createDTO(alladverts);

        request.setAttribute("allAdvertsDto", allAdvertsDto);
			
		
		return "index.jsp";

	}


    public List<AdvertDTO> createDTO (List<Advert> adverts)  {

        List<AdvertDTO> adto = new ArrayList<AdvertDTO>();
        int i =0;
        for (Advert o : adverts) {
            AdvertDTO aDto = new AdvertDTO();
            aDto.setAddedDate(o.getAddedDate());
            aDto.setCategory(o.getCategory());
            aDto.setCoast(o.getCoast());
            aDto.setDescription(o.getDescription());

            adto.add(i,aDto);
            i++;
        }


       return adto;

    }

    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }


}