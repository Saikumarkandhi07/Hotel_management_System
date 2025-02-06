package org.teca.hotel.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.AdminDao;
import org.teca.hotel.entity.AdminInformation;
import org.teca.hotel.entity.HotelInformation;
import org.teca.hotel.entity.PaymentInformation;
import org.teca.hotel.entity.UserInformation;

@Controller
public class AdminController {

	@Autowired
	private AdminDao adminDao;

	@RequestMapping("/adminlogin")
   public String getAdminLogin() {
	
		return "AdminLogin";
    }
	
	 @RequestMapping("/admindetails")
	public String getAdminDetails(String emailid,@RequestParam("password") String password,Model model) {
		 System.out.println();
		System.out.println("Admin EmailId -------> "+emailid);
		System.out.println("Admin Password -------> "+password);
		
		AdminInformation login = adminDao.adminLogin(emailid,password);
		if(login!=null) {
			System.err.println("Login Successfully ...!!!!!!");
			System.out.println();
			return "AdminOptions";
		}
		else {
			// System.out.println("Invalid details .....");
			System.err.println("Invalid details....!!!!");
			model.addAttribute("msg","Invalid Details");
			return "AdminLogin";
		}
	}
	 
	 @RequestMapping("/showalluserdetails")
	 public String allUserDetails(Model model) {
		List<UserInformation> alluser = adminDao.getAllUser();
		model.addAttribute("UserDetails", alluser);
	//	System.err.println("  **********  All User Details  *************");
	//	System.out.println(alluser);
		return "UsersList";
	 }
	 
	 @RequestMapping("/showallhoteldetails")
	 public String allHotelDetails(Model model) {
		 List<HotelInformation> allhotel = adminDao.getAllHotel();
//		 System.err.println("  **********   All Hotel Details  *************");
//		 System.out.println(allhotel);
		 model.addAttribute("HotelDetails", allhotel);
		 return "HotelList1";
	 }
	
	 @RequestMapping("/showallpaymentdetails")
	 public String allPaymentDetails(Model model) {
		 List<PaymentInformation> allpayment = adminDao.getAllPayment();
//		 System.err.println("  ***********  All Payment Details  ***********");
//		 System.out.println(allpayment);
		 model.addAttribute("PaymentDetails", allpayment);
		 return "PaymentList";
	 }
	 
	 @RequestMapping("/getupdateid")
	 public String getUpdateId(int id,Model model) {
		System.out.println(id);
		UserInformation userinformation = adminDao.getUserById(id);
		model.addAttribute("user", userinformation);
		System.out.println(userinformation);
 	return "UpdatedUserDetails";		 
	}
	 
	 @RequestMapping("/updated")
	 public String getUpdateDetails(UserInformation userinformation,Model model) {
		 UserInformation userInformation = adminDao.updateUserDetails(userinformation);
		 List<UserInformation> allUser = adminDao.getAllUser();
		 model.addAttribute("UserDetails", allUser);
		 System.out.println("Updated User Details : "+userInformation);
		 return "UsersList";
	 }
	 
	 @RequestMapping("/deleteUser")
	 public String deleteUser(int id,Model m) {
		  adminDao.deleteUserInformation(id);
		  List<UserInformation> allUser=adminDao.getAllUser();
		  m.addAttribute("UserDetails", allUser);
           return "UsersList";
	}
	 
	 @RequestMapping("/getupdatehotelid")
	 public String getUpdateHotelId(int id,Model model) {
		System.out.println("Hotel Id = "+id);
		HotelInformation hotelinformation = adminDao.getHotelById(id);
		model.addAttribute("hotel", hotelinformation);
		System.out.println(hotelinformation);
 	return "UpdatedHotelDetails";		 
	}
	 
	 @RequestMapping("/updatedHotel")
	 public String getUpdateHotelDetails(HotelInformation hotelinformation,Model model) {
		HotelInformation hotelInformation = adminDao.updateHotelDetails(hotelinformation);
		 List<HotelInformation> allhotel = adminDao.getAllHotel();
		 model.addAttribute("HotelDetails", allhotel);
		 System.out.println("Updated User Details : "+hotelInformation);
		 return "HotelList1";
	 }
	 
	 @RequestMapping("/deleteHotel")
	 public String deleteHotel(int id,Model model) {
		 adminDao.deleteHotelInformation(id);
		 List<HotelInformation> allHotel = adminDao.getAllHotel();
		 model.addAttribute("HotelDetails",allHotel);
		 return "HotelList1";
	 }
}
