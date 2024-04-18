package hotel.demo.service;

import hotel.demo.domain.Hoteles;
import java.util.List;

public interface HotelesService {

    public List<Hoteles> getHoteles(boolean activo);

    // Se obtiene un Hoteles, a partir del id de un hoteles
    public Hoteles getHoteles(Hoteles hoteles);

    // Se inserta un nuevo hoteles si el id del hoteles esta vacío
    // Se actualiza un hoteles si el id del hoteles NO esta vacío
    public void save(Hoteles hoteles);

    // Se elimina el hoteles que tiene el id pasado por parámetro
    public void delete(Hoteles hoteles);
}