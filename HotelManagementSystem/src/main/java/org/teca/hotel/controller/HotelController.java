package org.teca.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.HotelDao;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HotelController {

	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/hotelregister")
	public String hotelRegistrationPage(Model model)
	{
		HotelInformation information=new HotelInformation();
		model.addAttribute("hotelinformation",information);
		return "AddHotel";
	}
	
	@RequestMapping("/hotelDetails")
	@ResponseBody
	public String hotelDetails(HotelInformation hotelInformation)
	{
		HotelInformation hotelregistration=hotelDao.hotelRegistration(hotelInformation);
		
		if(hotelregistration!=null) 
		{
			
			return "<h1>Registration Successfull!!.....</h1>";
		}
		else 
		{
			return "Invalid details";
		}
	}
	
	@RequestMapping("/gethotelbyid")
	public String getHotelId(int hotelid,HttpServletRequest request,Model model) {
		
		System.out.println("Hotel Id --> "+hotelid);
		HotelInformation hotelInformation = hotelDao.getHotelById(hotelid);
		HttpSession session = request.getSession();
		UserInformation information2 = (UserInformation) session.getAttribute("user");
		model.addAttribute("user", information2);
		session.setAttribute("hotel", hotelInformation);
		model.addAttribute("hotelname", hotelInformation.getHotelname());
		model.addAttribute("price", hotelInformation.getPrice());
//		System.out.println(information2);
//		System.out.println(information);
		
		return "BookHotel";
	}
	
	
	@RequestMapping("/HotelList")
	public String showHotelList(Model model) {
	    // Assuming you fetch the hotel details
	    List<HotelInformation> hotelDetails = hotelDao.getAllHotelDetails();
	    model.addAttribute("HotelDetails", hotelDetails);
	    return "HotelList";  // Return the view name, which should match the Thymeleaf template
	}

}

