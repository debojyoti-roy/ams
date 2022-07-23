package com.drps.ams.util;

import java.util.HashMap;
import java.util.Map;

public class ApiConstants {
	
	public static final int RESP_STATUS_SUCCESS = 100;	
	public static final int RESP_STATUS_FAIL = 0;
	public static final int RESP_STATUS_EXCEPTION = 200;
	public static final int RESP_STATUS_INVALID_EMAIL_EXCEPTION = 201;
	
	
	public static final int RESP_STATUS_NO_RECORD_FOUND_EXCEPTION = 220;
	public static final int RESP_STATUS_RECORD_ID_NOT_FOUND_EXCEPTION = 221;
	
	private static String RESP_STATUS_MSG_SUCCESS = "SUCCESS";
	private static String RESP_STATUS_MSG_NO_RECORD_FOUND = "Record not found";
	private static String RESP_STATUS_MSG_RECORD_ID_NOT_FOUND = "Record id not found";
	
	public static final Map<Integer, String> STATUS_MESSAGE = new HashMap<>();
	static {
		
		STATUS_MESSAGE.put(RESP_STATUS_SUCCESS, RESP_STATUS_MSG_SUCCESS);
		STATUS_MESSAGE.put(RESP_STATUS_NO_RECORD_FOUND_EXCEPTION, RESP_STATUS_MSG_NO_RECORD_FOUND);
		STATUS_MESSAGE.put(RESP_STATUS_RECORD_ID_NOT_FOUND_EXCEPTION, RESP_STATUS_MSG_RECORD_ID_NOT_FOUND);
	}
}
