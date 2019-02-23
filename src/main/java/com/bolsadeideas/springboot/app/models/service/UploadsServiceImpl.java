package com.bolsadeideas.springboot.app.models.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadsServiceImpl implements IUploadsService {

	private final static String UPLOADS_FOLDER = "uploads";

	@Override
	public Resource load(String filename) throws MalformedURLException {
		Path pathFoto = getPath(filename);
		Resource resource = null;
		resource = new UrlResource(pathFoto.toUri());
		if (!resource.exists() || !resource.isReadable()) {
			throw new RuntimeException("Error: no se puede cargar la imagen " + pathFoto.toString());
		}
		return resource;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path rooAbsolutePath = getPath(uniqueFilename);

		Files.copy(file.getInputStream(), rooAbsolutePath);
		return uniqueFilename;
	}

	@Override
	public boolean delete(String filename) {

		Path rootPath = getPath(filename);
		File archivo = rootPath.toFile();

		if (archivo.exists() && archivo.canRead()) {
			if (archivo.delete()) {
				return true;
			}
		}

		return false;
	}

	public Path getPath(String filename) {

		return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
	}

}
