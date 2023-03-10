import java.util.List;
import java.util.function.Function;

public class Familia {
	//Atributo
	private List<Double> consumosElectricos;

	
	//Constructor
    public Familia(List<Double> consumosElectricos) {
        this.consumosElectricos = consumosElectricos;
    }

    //Mét. get consumo
    public List<Double> getConsumosElectricos() {
        return consumosElectricos;
    }

    //Mét. que toma lambda como parámetro
    //Toma una lista de consumos eléctricos como entrada y
    //devuelve un Double.
    public double calcularConsumoElect( Function<List<Double>,Double> calcula) {
        return calcula.apply(this.consumosElectricos);
    }
	
	
}
