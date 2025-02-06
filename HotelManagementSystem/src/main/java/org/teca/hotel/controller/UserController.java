package org.teca.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.teca.hotel.dao.HotelDao;
import org.teca.hotel.dao.UserDao;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/registration")
	public String UserRegistrationPage(Model model) {
		UserInformation information = new UserInformation();
		model.addAttribute("userinformation",information);
		return "AddUsers";
	}
	
	@RequestMapping("/userdetails")
	public String userDetails(UserInformation userInformation,Model model) {
//		modelandview.setViewName("Login");
//		modelandview.addObject("msg","Invalid Details");

        UserInformation registration =userDao.userRegistration(userInformation);
		
		ModelAndView modelAndView=new ModelAndView();
		if(registration!=null) 
		{
			return "Login";
		}
		else 
		{
			model.addAttribute("msg","Invalid Details");
			return "AddUsers";
		}
	}
	
	@RequestMapping("/loginpage")
	public String loginPage() {
		return "Login";

	}
	
	@RequestMapping("/userlogin")
	public String userLoginDetails(String emailid,String password,Model model,HttpServletRequest request)
	{
		
		UserInformation information=userDao.userLogin(emailid, password);
		HttpSession session = request.getSession();
		
		// Store the user information in session object to make us in hotel controller class
		session.setAttribute("user", information);
		if(information !=null)
	    {
			List<HotelInformation> allHotelDetails=hotelDao.getAllHotelDetails();
			//System.out.println(allHotelDetails);
			model.addAttribute("HotelDetails",allHotelDetails);
			return "HotelList";
			
		}
		else
		{
			model.addAttribute("msg", "Invalid Details.....");
			return "Login";
		}
		
		
	}

	@RequestMapping("/searchByCity")
	public String getCity(String city, Model m) {
		System.out.println("City "+city);
		List<HotelInformation> byCity = hotelDao.getHotelDetailsByCity(city);
		 System.out.println("ByCity "+byCity);
		m.addAttribute("HotelDetails", byCity);
         return "HotelList";
	}
}
