package org.loopmc.skins;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.loopmc.skins.SkinUtils;

public class LoopSkins implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Loop Skins");

	@Override
	public void init() {

		LOGGER.info("Thank you for helping us help you help us help us all!");

		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();

		String playerName = "worldwidepixel";
		String uuidUrl = "https://api.mojang.com/users/profiles/minecraft/" + playerName;

		String returnedUuidData = SkinUtils.makeRequest(uuidUrl);

		LOGGER.info(returnedUuidData);

		JsonObject apiResponse = gson.fromJson(returnedUuidData, JsonObject.class);

		String playerUuid = apiResponse.get("id").getAsString();

		LOGGER.info(playerUuid);

		String skinsUrl = ("https://sessionserver.mojang.com/session/minecraft/profile/" + playerUuid);

		String returnedSkinData = SkinUtils.makeRequest(skinsUrl);

		LOGGER.info(returnedSkinData);

		JsonObject skinApiResponse = gson.fromJson(returnedSkinData, JsonObject.class);

		String valueBase64 = "If this is your result you are broken.";

		JsonArray propertiesArray = skinApiResponse.getAsJsonArray("properties");
		for (JsonElement propertyElement : propertiesArray) {
			JsonObject propertyObject = propertyElement.getAsJsonObject();
			if ("textures".equals(propertyObject.get("name").getAsString())) {
				valueBase64 = propertyObject.get("value").getAsString();
			}
		}

		LOGGER.info(valueBase64);

		byte[] base64Bytes = valueBase64.getBytes();
		byte[] decodedBaseBytes = Base64.getDecoder().decode(base64Bytes);
		//String decodedValue = new String(decodedBaseBytes, UTF_8);
		String decodedValue = new String(decodedBaseBytes, UTF_8);
		//JsonElement decodedJSON = new JsonParser().parse(decodedValue);

		JsonObject decodedJSON = JsonParser.parseString(decodedValue).getAsJsonObject();

		LOGGER.info(decodedJSON);


		LOGGER.info(decodedValue);

		String skinURL = "If this is your result you are broken.";
		String skinType = "If this is your result you are broken.";
		String capeURL = "If this is your result you are broken.";

		//TEXTURES ARRAY

		// Access the "textures" object
		JsonObject texturesObject = decodedJSON.getAsJsonObject("textures");

		// Access the "SKIN" object
		JsonObject skinObject = texturesObject.getAsJsonObject("SKIN");
		skinURL = skinObject.get("url").getAsString();

		// Access the "metadata" object
		JsonObject metadataObject = skinObject.getAsJsonObject("metadata");
		skinType = metadataObject.get("model").getAsString();

		// Access the "CAPE" object
		JsonObject capeObject = texturesObject.getAsJsonObject("CAPE");
		capeURL = capeObject.get("url").getAsString();


		LOGGER.info(skinURL);
		LOGGER.info(skinType);
		LOGGER.info(capeURL);



	};

/*	public void init() {
		LOGGER.info("This was a triumph");
	};
	public void init() {
		LOGGER.info("I'm making a note here");
	};
	public void init() {
		LOGGER.info("HUGE SUCCESS!");
	}; */
}
