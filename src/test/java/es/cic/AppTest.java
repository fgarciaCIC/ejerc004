package es.cic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    int f = 4, b = 4, c = 3, d = 1;
	
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        int a[][] = {{1}, {1, 2}, { 1, 2, 3}, new int[2]};

        int suma = 0;

        PEPE: for (int i=0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                suma = suma + a[i][j];
            }

        }
        
        List<String> datos = new ArrayList<String>();
        
        datos.add("Hola");
        datos.add("Adios");
        
        assertThat(
        		datos.stream()
        		.filter(t -> "Hola".equals(t))
        		.count()
        		, is(1l));
        
        List<String> cadenas = new ArrayList<>();
        for (int i = 0 ; i < datos.size(); i++) {
        	if (String.class.isAssignableFrom(datos.get(i).getClass())) {
        		cadenas.add(datos.get(i));        		
        	}
        }
        assertThat(
        		ejecutar(v -> v + 1, 3), is(4));
        
        
        int e = expressionNewton();
        
        
        assertThat("Esperaba que el tamaño de la lista fuera 2", suma , is(10));
        return;
    }
    
    
    

	private int expressionNewton() {
		return b = (c++/((f%d == 0)? 4: f));
	}

	public int ejecutar(Execute orden, int valor) {
		return orden.ejecuta(valor);		
	}

	public interface Execute {
		int ejecuta(int a);
	}
	
	public class MiPredicado implements Predicate<String> {

		@Override
		public boolean test(String t) {
			// TODO Auto-generated method stub
			return t.equals("Hola");
		}
		

		
	}
}
