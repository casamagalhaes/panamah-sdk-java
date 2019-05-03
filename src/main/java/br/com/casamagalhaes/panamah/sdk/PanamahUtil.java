package br.com.casamagalhaes.panamah.sdk;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PanamahUtil {
	public static Gson buildGson() {
		return new GsonBuilder().registerTypeAdapter(Date.class, new GsonUTCDateAdapter()).create();
	}
}
