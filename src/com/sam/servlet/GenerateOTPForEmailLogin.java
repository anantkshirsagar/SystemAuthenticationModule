package com.sam.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sam.constants.AppConstants;
import com.sam.service.EmailService;
import com.sendgrid.Response;
import com.service.email.EmailDetails;

public class GenerateOTPForEmailLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(GenerateOTPForEmailLogin.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otp = request.getParameter("otp");
		String email = request.getParameter("email");

		EmailService emailService = new EmailService();

		InputStream resourceAsStream = GenerateOTPForMobileLogin.class.getClassLoader()
				.getResourceAsStream(AppConstants.emailConfigurationProperties);
		File file = new File(AppConstants.emailConfigurationProperties);
		FileUtils.copyInputStreamToFile(resourceAsStream, file);
		emailService.load(file);
		EmailDetails emailDetails = new EmailDetails();
		emailDetails.setBody("Your OTP for SAM is " + otp);
		emailDetails.setSubject("This message is sent from SAM");
		emailDetails.setFrom("icbm.iot@gmail.com");
		emailDetails.setTo(email);
		try {
			Response sendEmail = emailService.sendEmail(emailDetails);
			LOG.debug("sendEmail {}", sendEmail.getStatusCode());
		} catch (Exception e) {
			LOG.error("Exception {}", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
