package com.distribuida.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.DetallesDevolucionesDAO;
import com.distribuida.entities.DetallesDevoluciones;

@Controller
@RequestMapping("/detallesdevoluciones") //path Principal
public class DetallesDevolucionesController {

    @Autowired
    private DetallesDevolucionesDAO detallesDevolucionesDAO;

    @GetMapping("/findAll") // path secundario
    public String findAll(Model model) {
        List<DetallesDevoluciones> detallesDevoluciones = detallesDevolucionesDAO.findAll();
        model.addAttribute("keyDetallesDevoluciones", detallesDevoluciones);
        return "listar-detallesdevoluciones"; //nombre del formulario EJ.listar-detallesdevoluciones.html o listar-detallesdevoluciones.jsp
    }

    @GetMapping("/findOne")
    public String findOne(@RequestParam("idDetalleDevolucion") @Nullable Integer idDetalleDevolucion,
                          @RequestParam("opcion") @Nullable Integer opcion,
                          Model model) {
        if (idDetalleDevolucion != null) {
            DetallesDevoluciones detalleDevolucion = detallesDevolucionesDAO.findOne(idDetalleDevolucion);
            model.addAttribute("detalleDevolucion", detalleDevolucion);
        }
        if (opcion == 1) return "add-detallesdevoluciones"; //Actualizacion
        else return "del-detallesdevoluciones"; //Eliminación
    }

    @PostMapping("/add")
    public String add(@RequestParam("idDetalleDevolucion") @Nullable Integer idDetalleDevolucion,
                      @RequestParam("idDevolucion") @Nullable Integer idDevolucion,
                      @RequestParam("idProducto") @Nullable Integer idProducto,
                      @RequestParam("cantidad") @Nullable Integer cantidad,
                      @RequestParam("precioUnitario") @Nullable Double precioUnitario,
                      Model model) {
        if (idDetalleDevolucion == null) {
            DetallesDevoluciones detalleDevolucion = new DetallesDevoluciones(0, idDevolucion, idProducto, cantidad, precioUnitario);
            detallesDevolucionesDAO.add(detalleDevolucion);
        } else {
            DetallesDevoluciones detalleDevolucion = new DetallesDevoluciones(idDetalleDevolucion, idDevolucion, idProducto, cantidad, precioUnitario);
            detallesDevolucionesDAO.up(detalleDevolucion);
        }
        return "redirect:/detallesdevoluciones/findAll"; //ir a formulario web por path o url.
    }

    @GetMapping("/del")
    public String del(@RequestParam("idDetalleDevolucion") @Nullable Integer idDetalleDevolucion) {
        detallesDevolucionesDAO.del(idDetalleDevolucion);
        return "redirect:/detallesdevoluciones/findAll";
    }
}
