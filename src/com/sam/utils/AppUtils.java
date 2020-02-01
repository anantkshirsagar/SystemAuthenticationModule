package com.sam.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbmanager.objectify.Objectify;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppUtils {

	private static final Logger LOG = LoggerFactory.getLogger(AppUtils.class.getName());

	private AppUtils() {
	}

	public static Object mapToClass(HttpServletRequest request, Class classType) throws IOException {
		String jsonObj = request.getReader().lines().collect(Collectors.joining());
		LOG.debug("Json {}", jsonObj);
		Gson gson = getGsonInstance();
		return gson.fromJson(jsonObj, classType);
	}

	public static <T> List<T> mapToList(HttpServletRequest request, Type jsonType) throws IOException {
		String jsonObj = request.getReader().lines().collect(Collectors.joining());
		LOG.debug("Json {}", jsonObj);
		Gson gson = getGsonInstance();
		return gson.fromJson(jsonObj, jsonType);
	}
	
	public static String getBody(HttpServletRequest request) throws IOException {
		return request.getReader().lines().collect(Collectors.joining());
	}

	public static Gson getGsonInstance() {
		GsonBuilder builder = new GsonBuilder();
		return builder.create();
	}

	public static boolean isStringEmpty(String string) {
		return string == null || string.isEmpty();
	}

	public static boolean isStringNotEmpty(String string) {
		return string != null && !string.isEmpty();
	}

	public static byte[] getObject(List<String> keywordsList) throws SQLException, IOException {
		return Objectify.serialize(keywordsList);
	}
}
