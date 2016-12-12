package br.com.poi.poc.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import br.com.poi.poc.Planilha;
import br.com.poi.poc.service.ArtTableGeneratorService;

/**
 *
 * @author signorette
 */

@Service
public class ArtTableGeneratorServiceImpl implements ArtTableGeneratorService {

	@Override
	public File generatorXls() {

		final File file = new File("/home/signorette/ciet.png");
		try {
			final BufferedImage image = ImageIO.read(file);

			final Planilha planilha = new Planilha("teste");

			for (int y = 0; y < image.getHeight(); y++) {
				for (int x = 0; x < image.getWidth(); x++) {
					final int clr = image.getRGB(x, y);
					final int red = (clr & 0x00ff0000) >> 16;
				final int green = (clr & 0x0000ff00) >> 8;
				final int blue = clr & 0x000000ff;
				final byte[] rgb = new byte[3];
				rgb[0] = (byte) red; // red
				rgb[1] = (byte) green; // green
				rgb[2] = (byte) blue; // blue
				System.out.println(rgb[0] + "-" + rgb[1] + "-" + rgb[2] + "-");
				planilha.adicionarCorCelula(y, x, rgb);
				}
			}

			return planilha.getArquivo();


		} catch (final IOException e) {
			e.printStackTrace();
		}

		return null;
	}



}
