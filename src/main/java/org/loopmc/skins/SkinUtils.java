package org.loopmc.skins;

import org.loopmc.skins.LoopSkins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SkinUtils {
	private static final Logger LOGGER = LogManager.getLogger("Loop Skins/Debug");

	public static String makeRequest(String providedUrl) {

		StringBuffer content = new StringBuffer();

		try {

			URL url = new URL(providedUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			//int responseCode = connection.getResponseCode();
			//LOGGER.info(responseCode);

			BufferedReader in = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			connection.disconnect();

		} catch (IOException e) {
			//LOGGER.info("I hate Java URLs.");
			LOGGER.info("[SkinUtils] API request failed.");
		}

		if (content.toString() != null) {
			return content.toString();
		} else {
			return "You made a mistake.";
		}


	}

}
