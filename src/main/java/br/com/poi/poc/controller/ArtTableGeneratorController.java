package br.com.poi.poc.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poi.poc.service.ArtTableGeneratorService;

/**
 *
 * @author signorette
 */

@RestController
public class ArtTableGeneratorController {

	@Autowired
	private ArtTableGeneratorService artTableGeneratorService;

	@RequestMapping(name = "/generatorXls")
	public String generatorXls() {
		final File arquivo = artTableGeneratorService.generatorXls();
		return arquivo.getName();

	}

}
