package br.com.projeto.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public final class ImageUtils {

	public static BufferedImage crop(BufferedImage image, int type, int width, int height) {
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), type);
		
		Graphics2D graphics = newImage.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		
		graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		
		int x = image.getWidth() / 2 - width / 2;
		int y = image.getHeight() / 2 - height / 2;
		int w = ((x + width) > image.getWidth()) ? (image.getWidth() - x) : width;
		int h = ((y + height) > image.getHeight()) ? (image.getHeight() - y) : height;
		
		newImage = newImage.getSubimage(x, y, w, h);
		
		graphics.dispose();

	    return newImage;
	}

	public static BufferedImage scale(BufferedImage img, int type, int width, int height, boolean higherQuality) {

		BufferedImage ret = img;
		
		int w, h;
		
		if (higherQuality) {
			// Use multi-step technique: start with original size, then
			// scale down in multiple passes with drawImage()
			// until the target size is reached
			w = img.getWidth();
			
			// if need to scale up use the normal scale mode
			if (w < width)
				w = width;
			
			h = img.getHeight();
			
			// if need to scale up use the normal scale mode
			if (h < height)
				h = height;
		} else {
			// Use one-step technique: scale directly from original
			// size to target size with a single drawImage() call
			w = width;
			h = height;
		}
		
		Graphics2D graphics = null;
		
		BufferedImage tmp = null;
		
		do {
			if (higherQuality && w > width) {
				w /= 2;
				if (w < width) {
					w = width;
				}
			}

			if (higherQuality && h > height) {
				h /= 2;
				if (h < height) {
					h = height;
				}
			}

			tmp = new BufferedImage(w, h, type);
			
			graphics = tmp.createGraphics();
			graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			graphics.drawImage(ret, 0, 0, w, h, null);
			graphics.dispose();

			ret = tmp;
		} while (w != width || h != height);

		return ret;
	}	
}
