import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaCosumoElect {
	public static void main(String[] args) {
		
        //Lista de consumos eléctricos x persona que habita
		//CONSUMO MENSUAL =   Potencia (W) * horas de uso por día *días uso al mes
        List<Double> consumos = new ArrayList<>();
        	consumos.add(200.0);
        	consumos.add(400.0);
        	consumos.add(300.0);

        // Creamos una instancia de familia
        Familia fam = new Familia(consumos);

        
        //Lambda para calcular el consumo total de electricidad
        Function<List<Double>, Double> Total = consumosLista -> {
            double suma = 0.0;
            for (Double consumo : consumosLista) {
                suma += consumo;
            }
            return suma;
        };

        //Lambda para calcular el consumo promedio de electricidad
        Function<List<Double>, Double> Promedio = consumosLista -> {
            double suma = 0.0;
            for (Double consumo : consumosLista) {
                suma += consumo;
            }
            return suma / consumosLista.size();
        };

      

        // Consumo total de electricidad utilizando Lambda
        double total = fam.calcularConsumoElect(Total);
        System.out.println("Consumo total de electricidad de fam: " + total);
        
        // Consumo promedio de electricidad Lambda
        double promedio = fam.calcularConsumoElect(Promedio);
        System.out.println("Consumo promedio de electricidad de fam: " + promedio);

	}
}
