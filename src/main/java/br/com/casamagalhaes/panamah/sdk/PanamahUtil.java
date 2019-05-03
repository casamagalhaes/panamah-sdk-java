package br.com.casamagalhaes.panamah.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PanamahUtil {
	
	public static String stamp(Date d) {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(d);
	}

	public static Gson buildGson() {
		return new GsonBuilder().registerTypeAdapter(Date.class, new GsonUTCDateAdapter()).create();
	}
}
