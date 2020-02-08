package com.sam.manager;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sam.constants.AppConstants;

public class ScoreValidator {
	private static final Logger LOG = LoggerFactory.getLogger(ScoreValidator.class);

	public void validateScore(int score, HttpServletResponse response) {
		LOG.debug("Score {}", score);
		response.setHeader("SCORE", String.valueOf(score));
		if (score >= AppConstants.SCORE) {
			response.setHeader("IS_VALID", String.valueOf(true));
		} else {
			response.setHeader("IS_VALID", String.valueOf(false));
		}
	}
}
