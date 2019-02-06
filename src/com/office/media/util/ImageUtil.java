package com.office.media.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.Part;

/**
 *
 * @author Zayar Thant
 */
public class ImageUtil {

	public static boolean isValidImage(Part part) {
		if (null != part) {
			return part.getContentType().equals("image/jpeg") || part.getContentType().equals("image/png")
					|| part.getContentType().equals("image/gif");
		}
		return false;
	}

	public static boolean uploadImage(Part part, String fileName) {
		if (part != null) {
			Path file = Paths.get(fileName);
			try (InputStream inputStream = part.getInputStream()) {
				Files.copy(inputStream, file, StandardCopyOption.REPLACE_EXISTING);
				return true;
			} catch (IOException e) {
				return false;
			}
		}
		return false;
	}

	public static String generateImageName(String s) {
		Random rand = new Random();
		return rand.nextInt(1000) + new Date().getTime() + s;
	}

	public static void deleteImage(String fullFileUrl) {
		if (null == fullFileUrl || fullFileUrl.isEmpty())
			return;
		Path file = Paths.get(fullFileUrl);
		try {
			Files.delete(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
