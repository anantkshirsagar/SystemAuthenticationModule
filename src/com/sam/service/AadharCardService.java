package com.sam.service;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sam.constants.AadharCardDetails;
import com.sam.model.AadharCard;

public class AadharCardService {

	private static final Logger LOG = LoggerFactory.getLogger(AadharCardService.class);
	private static final String SPACE = " ";

	public AadharCard getAadharCard(String aadharCardStr) throws JAXBException {
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(AadharCardDetails.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AadharCardDetails aadharCardDetails = (AadharCardDetails) jaxbUnmarshaller
				.unmarshal(new StringReader(aadharCardStr));
		LOG.debug("Aadhar card details {}", aadharCardDetails);
		return convertAadharCardDetailsToAadharCard(aadharCardDetails);
	}

	public AadharCard convertAadharCardDetailsToAadharCard(AadharCardDetails aadharCardDetails) {
		AadharCard aadharCard = new AadharCard();
		aadharCard.setAadharCardNo(aadharCardDetails.getUid());
		StringBuilder address = new StringBuilder(aadharCardDetails.getHouse() + " ");
		address.append(aadharCardDetails.getStreet()).append(SPACE);
		address.append(aadharCardDetails.getLm()).append(SPACE);
		address.append(aadharCardDetails.getLoc()).append(SPACE);
		address.append(aadharCardDetails.getVtc()).append(SPACE);
		address.append(aadharCardDetails.getPo()).append(SPACE);
		aadharCard.setAddress(address.toString());
		aadharCard.setDateOfBirth(aadharCardDetails.getDob());
		aadharCard.setDistrict(aadharCardDetails.getDist());
		aadharCard.setGender(aadharCardDetails.getGender());
		aadharCard.setName(aadharCardDetails.getName());
		aadharCard.setPincode(aadharCardDetails.getPc());
		aadharCard.setState(aadharCardDetails.getState());
		aadharCard.setSubDistrict(aadharCardDetails.getSubdist());
		aadharCard.setYearOfBirth(aadharCardDetails.getYob());
		return aadharCard;
	}
}
