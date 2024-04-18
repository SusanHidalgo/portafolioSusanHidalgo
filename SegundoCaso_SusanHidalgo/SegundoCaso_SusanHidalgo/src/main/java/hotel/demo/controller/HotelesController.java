package hotel.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import hotel.demo.domain.Hoteles;
import hotel.demo.service.HotelesService;


@Controller
@RequestMapping("/hotel")
public class HotelesController {

    @Autowired
    private HotelesService hotelesService;

    @GetMapping("/listado")
    private String listado(Model model) {
        var hoteles = hotelesService.getHoteles();
        model.addAttribute("hoteles", hoteles);
        model.addAttribute("totalHoteles", hoteles.size());
        return "/hotel/listado";
    }

    @GetMapping("/nuevo")
    public String hotelNuevo(Hoteles hotel) {
        return "/hotel/modifica";
    }

    @PostMapping("/guardar")
    public String hotelGuardar(Hoteles hotel,
                               @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            hotelesService.save(hotel);
            
        }
        hotelesService.save(hotel);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String hotelEliminar(Hoteles hotel) {
        hotelesService.delete(hotel);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/modificar/{id}")
    public String hotelModificar(Hoteles hotel, Model model) {
        hotel = hotelesService.getHoteles(hotel);
        model.addAttribute("hotel", hotel);
        return "/hotel/modifica";
    }
}

