package org.teca.hotel.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teca.hotel.dao.BookingDao;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookingController {

	@Autowired
	private BookingDao bookingdao;
	

	@RequestMapping("/bookingdetails")
	public String getBookingDetails(BookingInformation information,Model model,HttpServletRequest request) {
		BookingInformation bookinformation = bookingdao.getBookingInfo(information);
		System.out.println("Booking Information ---> "+bookinformation);
		
		request.getSession().setAttribute("bookinformation",information);
		if(information.getBookingdate().isAfter(LocalDate.now())||information.getBookingdate().isEqual(LocalDate.now())) {
			
			System.out.println("Date is valid....!!!!!!!");
			
			model.addAttribute("price", information.getPrice());
			return "AfterHotelPayment";
		}  
		else {
			
			UserInformation information3 = (UserInformation) request.getSession().getAttribute("user");
			model.addAttribute("user", information3);
			
			HotelInformation hotelInformation = (HotelInformation) request.getSession().getAttribute("hotel");
			model.addAttribute("hotelname",hotelInformation.getHotelname());
			model.addAttribute("price",hotelInformation.getPrice());
			model.addAttribute("msg", "Invalid date...!!!");
			return "BookHotel";
		//	System.err.println("Invalid Date......");
		}

	}
}
