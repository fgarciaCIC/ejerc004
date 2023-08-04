package es.cic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;

public class FicheroImpl implements Fichero {

	@Override
	public BufferedReader abrirFichero(String nombreFichero) throws IOException {
		String nombreFicheroLimpio = FilenameUtils.normalize(nombreFichero);
		
		if (nombreFicheroLimpio == null) {
			throw new TransversalAttackException("Me han tratado de abrir un fichero sin permisos", nombreFichero);
		}
		
		String separador = "" + File.separatorChar;

		String ruta = "src" +
				separador +
				"test" +
				separador +
				"resources" +  
				separador +
				"ficherosAccesibles" +
				separador +
				nombreFicheroLimpio;
		
		Path p = Paths.get("src",
							separador,
							"test",
							separador,
							"resources", 
							separador,
							"ficherosAccesibles",
							separador,
							nombreFicheroLimpio).normalize();
		
		return Files.newBufferedReader(p);

		
//		InputStream is = new FileInputStream(p.toFile());
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader bf = new BufferedReader(isr);
//		return bf;
	}

}
