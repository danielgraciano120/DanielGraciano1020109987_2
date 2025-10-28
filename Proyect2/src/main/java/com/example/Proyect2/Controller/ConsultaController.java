package com.example.Proyect2.Controller;

import com.example.Proyect2.models.*;
import com.example.Proyect2.Repository.TecnicosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class ConsultaController {

    private final TecnicosRepository repo;

    public ConsultaController(TecnicosRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Consulta 1
    @GetMapping("/consulta1")
    public String consulta1(Model model) {
        model.addAttribute("tecnicos", repo.getTecnicos());
        model.addAttribute("supervisor", repo.getSupervisor());
        return "consulta1";
    }

    // Consulta 2
    @GetMapping("/consulta2")
    public String consulta2(Model model) {
        Stack<Tecnicos> stack = repo.getTecnicos();
        Supervisor supervisor = repo.getSupervisor();

        List<String> stackList = new ArrayList<>();
        ListIterator<Tecnicos> listIterator = stack.listIterator();
        while (listIterator.hasNext()) {
            Tecnicos t = listIterator.next();
            stackList.add(t.getNombre() + " - " + t.getCategoria() + " - " + t.getEmpresa());
        }

        List<String> dequeList = new ArrayList<>();
        Iterator<Tecnicos> iterator = supervisor.getTecnicos().iterator();
        while (iterator.hasNext()) {
            Tecnicos t = iterator.next();
            dequeList.add(t.getNombre() + " - " + t.getCategoria() + " - " + t.getEmpresa());
        }

        model.addAttribute("stack", stackList);
        model.addAttribute("deque", dequeList);
        return "consulta2";
    }

    // Consulta 3
    @GetMapping("/consulta3")
    public String consulta3(Model model) {
        Deque<Tecnicos> deque = new ArrayDeque<>(repo.getTecnicos());
        List<String> resultado = deque.stream()
                .filter(t -> t.getEmpresa() == Empresa.AMAZON)
                .map(Tecnicos::getNombre)
                .collect(Collectors.toList());
        model.addAttribute("resultado", resultado);
        return "consulta3";
    }

    // Consulta 4
    @GetMapping("/consulta4")
    public String consulta4(Model model) {
        Function<Tecnicos, Integer> sumarProyectos = t -> t.getProyectos().stream().mapToInt(Integer::intValue).sum();

        Map<String, Integer> resultados = repo.getTecnicos().stream()
                .collect(Collectors.toMap(Tecnicos::getNombre, sumarProyectos::apply));

        model.addAttribute("resultados", resultados);
        return "consulta4";
    }

    // Consulta 5
    @GetMapping("/consulta5")
    public String consulta5(Model model) {
        Function<Tecnicos, Integer> sumarProyectos = t -> t.getProyectos().stream().mapToInt(Integer::intValue).sum();
        Tecnicos t = repo.getTecnicos().peek();
        int total = t.verTotalProyectos(sumarProyectos);
        model.addAttribute("tecnico", t.getNombre());
        model.addAttribute("total", total);
        return "consulta5";
    }
}
