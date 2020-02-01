package com.sam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sam.constants.AppConstants;
import com.sam.constants.CallType;
import com.sam.model.AadharCard;
import com.sam.service.AadharCardService;
import com.sam.utils.AppUtils;

public class AadharCardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(AadharCardServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = null;
		try {
			String callTypeStr = request.getHeader("callType");
			LOG.debug("Header params callType {}", callTypeStr);
			CallType callType = CallType.valueOf(callTypeStr);
			out = response.getWriter();
			Gson gson = AppUtils.getGsonInstance();
			switch (callType) {
			case AADHAR_CARD_SERVICE:
				String aadharCardStr = AppUtils.getBody(request);
				LOG.debug("aadharCardStr {},", aadharCardStr);
				AadharCardService aadharCardService = new AadharCardService();
				AadharCard aadharCard = aadharCardService.getAadharCard(aadharCardStr);
				out.print(gson.toJson(aadharCard));
				break;
			}
		} catch (Exception e) {
			out.print(AppConstants.FAILURE_MESSAGE);
			LOG.error("Servlet Exception {}", e);
		}
	}
}
