package es.cic;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BatidoraImplTest {

	private BatidoraImpl cut;
	
	private Calculadora dependencia;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cut = new BatidoraImpl();
		this.dependencia = mock(Calculadora.class); 
		this.cut.setCalculadora(dependencia);
	}

	@Test
	void testCalcularTiempos() {
		when(dependencia.sumar(4, 3)).thenReturn(7);
		
		
		cut.calcularTiempos(4, 3);
		
		
		assertThat("No es el tiempo esperado", cut.getTiempoTotal(), is(7)); 
		verify(dependencia, times(1)).sumar(4, 3);
	}

}
