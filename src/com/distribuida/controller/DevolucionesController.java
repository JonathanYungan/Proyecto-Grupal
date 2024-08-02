package com.distribuida.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.DevolucionesDAO;
import com.distribuida.entities.Devoluciones;

@Controller
@RequestMapping("/devoluciones") //path Principal
public class DevolucionesController {

    @Autowired
    private DevolucionesDAO devolucionesDAO;

    @GetMapping("/findAll") // path secundario
    public String findAll(Model model) {
        List<Devoluciones> devoluciones = devolucionesDAO.findAll();
        model.addAttribute("keyDevoluciones", devoluciones);
        return "listar-devoluciones"; //nombre del formulario EJ.listar-devoluciones.html o listar-devoluciones.jsp
    }

    @GetMapping("/findOne")
    public String findOne(@RequestParam("idDevolucion") @Nullable Integer idDevolucion,
                          @RequestParam("opcion") @Nullable Integer opcion,
                          Model model) {
        if (idDevolucion != null) {
            Devoluciones devolucion = devolucionesDAO.findOne(idDevolucion);
            model.addAttribute("devolucion", devolucion);
        }
        if (opcion == 1) return "add-devoluciones"; //Actualizacion
        else return "del-devoluciones"; //Eliminación
    }

    @PostMapping("/add")
    public String add(@RequestParam("idDevolucion") @Nullable Integer idDevolucion,
                      @RequestParam("idPedido") @Nullable Integer idPedido,
                      @RequestParam("fechaDevolucion") @Nullable Date fechaDevolucion,
                      @RequestParam("motivo") @Nullable String motivo,
                      Model model) {
        if (idDevolucion == null) {
            Devoluciones devolucion = new Devoluciones(0, fechaDevolucion, motivo);
            devolucion.setIdPedido(idPedido);
            devolucionesDAO.add(devolucion);
        } else {
            Devoluciones devolucion = new Devoluciones(idDevolucion, fechaDevolucion, motivo);
            devolucion.setIdPedido(idPedido);
            devolucionesDAO.up(devolucion);
        }
        return "redirect:/devoluciones/findAll"; //ir a formulario web por path o url.
    }

    @GetMapping("/del")
    public String del(@RequestParam("idDevolucion") @Nullable Integer idDevolucion) {
        devolucionesDAO.del(idDevolucion);
        return "redirect:/devoluciones/findAll";
    }
}
