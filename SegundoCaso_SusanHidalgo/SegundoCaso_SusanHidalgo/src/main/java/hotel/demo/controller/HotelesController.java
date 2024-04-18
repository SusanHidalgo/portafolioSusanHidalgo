package hotel.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hotel.demo.domain.Hoteles;
import hotel.demo.service.HotelesService;

@Controller
@Slf4j
@RequestMapping("/hotel")
public class HotelesController {
    @Autowired
    private HotelesService hotelService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var hoteles = hotelService.getHoteles();
        model.addAttribute("hoteles", hoteles);
        return "/hotel/listado";
    }
    
    @GetMapping("/nuevo")
    public String hotelNuevo(Hoteles hotel) {
        return "/hotel/modifica";
    }

    
    @PostMapping("/guardar")
    public String hotelGuardar(Hoteles hotel) {        
        hotelService.save(hotel);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String hotelEliminar(Hoteles hotel) {
        hotelService.delete(hotel);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/modificar/{id}")
    public String hotelModificar(Hoteles hotel, Model model) {
        hotel = hotelService.getHoteles(hotel);
        model.addAttribute("hotel", hotel);
        return "/hotel/modifica";
    }
}
