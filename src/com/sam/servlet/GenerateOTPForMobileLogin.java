package com.sam.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.sam.constants.AppConstants;
import com.service.technolite.sms.SmsDetails;
import com.service.technolite.sms.SmsService;

public class GenerateOTPForMobileLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otp = request.getParameter("otp");
		String mobileNo = request.getParameter("mobileNo");
		SmsService smsService = new SmsService();

		InputStream resourceAsStream = GenerateOTPForMobileLogin.class.getClassLoader()
				.getResourceAsStream(AppConstants.technoliteSmsProperties);
		File file = new File(AppConstants.technoliteSmsProperties);
		FileUtils.copyInputStreamToFile(resourceAsStream, file);
		smsService.load(new File(AppConstants.technoliteSmsProperties));
		SmsDetails smsDetails = new SmsDetails();
		smsDetails.setMessage("Your OTP for SAM is " + otp);
		smsDetails.setNumber(mobileNo);
		smsService.sendSms(smsDetails);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
