package org.teca.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teca.hotel.dao.BookingDao;
import org.teca.hotel.dao.PaymentDao;
import org.teca.hotel.entity.BookingInformation;
import org.teca.hotel.entity.PaymentInformation;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	BookingDao bookingDao;

//	@RequestMapping("/payment")
//	@ResponseBody
//	public String paymentdetails(PaymentInformation payment,HttpServletRequest request) {
//		PaymentInformation paymentDetails = paymentDao.getPaymentDetails(payment);
//		
////		BookingInformation information = (BookingInformation) request.getSession().getAttribute("bookingInformation");
////		
//		//bookingDao.getBookingInfo(information);
//		if(paymentDetails!=null) {
//			return "paymentConf";
//			//System.out.println("Payment Successfull.....!");
//		}
//		else {
//			return "<center><h1>Invalid details.......!</h1></center>";	
//		}
//	}
	
	
	@RequestMapping("/payment")
	public String paymentDetails(PaymentInformation payment, HttpServletRequest request, Model model) {
	    PaymentInformation paymentDetails = paymentDao.getPaymentDetails(payment);

	    if (paymentDetails != null) {
	        model.addAttribute("paymentDetails", paymentDetails); // Pass any required data to the view
	        return "paymentConf"; // This refers to the `paymentConf.html` Thymeleaf template
	    } else {
	        model.addAttribute("errorMessage", "Invalid payment details");
	        return "errorPage"; // A separate error page to handle invalid payments
	    }
	}

}
