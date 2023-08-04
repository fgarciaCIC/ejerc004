package es.cic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class FileTransversalAbuseTest {
	private static final String FILE_TRANSVERSAL_NO_DISPONIBLE_TXT = "../fileTransversalNoDisponible.txt";
	private static final String FILE_DISPONIBLE_TXT = "fileDisponible.txt";
	private Fichero fichero;
	
	@BeforeEach
	public void setup() {
		this.fichero = new FicheroImpl(); 
	}
	
	@Test
	public void testAbrirFichero() throws IOException {
		BufferedReader f = fichero.abrirFichero(FILE_DISPONIBLE_TXT);
		
		assertThat(f, is(notNullValue()));
	}
	
	@Test
	public void testAbrirFicheroConTransversal() throws IOException {

		assertThrows(TransversalAttackException.class,
					 () -> fichero.abrirFichero(FILE_TRANSVERSAL_NO_DISPONIBLE_TXT)
		);
	}
	
	@Test
	public void normalizaProtegeCommonsUtils() {
		String pegote = FilenameUtils.normalize(FILE_TRANSVERSAL_NO_DISPONIBLE_TXT);

		assertThat(pegote, is(nullValue()));

	}
	
	@Test
	public void normalizaNoProtegePath() {
		Path pegote = Paths.get(FILE_TRANSVERSAL_NO_DISPONIBLE_TXT).normalize();

		assertThat(pegote, is(notNullValue()));

	}
	
}
