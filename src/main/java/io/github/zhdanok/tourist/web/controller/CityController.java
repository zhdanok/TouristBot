package io.github.zhdanok.tourist.web.controller;

import io.github.zhdanok.tourist.web.bean.City;
import io.github.zhdanok.tourist.web.bean.CityInfo;
import io.github.zhdanok.tourist.web.repository.CityInfoRepository;
import io.github.zhdanok.tourist.web.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "/")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityInfoRepository cityInfoRepository;


    @GetMapping(value = "table")
    public ModelAndView tablePage() {
        ModelAndView modelAndView = new ModelAndView("/table");
        modelAndView.addObject("listCity", cityRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = "addCity")
    public ModelAndView addCityPage() {
        ModelAndView modelAndView = new ModelAndView("/addCity");
        modelAndView.addObject("addCity");
        return modelAndView;
    }

    @PostMapping(value = "addCity")
    public ModelAndView addCity(@RequestParam(value = "nameRu", required = false) String nameRu,
                                @RequestParam(value = "nameEn", required = false) String nameEn,
                                @RequestParam(value = "info", required = false) String info) {
        ModelAndView modelAndView = new ModelAndView("/addCity");
        CityInfo cityInfo = new CityInfo(info);
        cityInfoRepository.save(cityInfo);
        City city = City.builder()
                .nameRu(nameRu)
                .nameEn(nameEn)
                .cityInfo(cityInfo)
                .build();
        cityRepository.save(city);
        modelAndView.setViewName("redirect:/table");
        return modelAndView;
    }

    @GetMapping(value = "update" + "/{nameRu}")
    public ModelAndView updateCity(@PathVariable(name = "nameRu") String nameRu) {
        ModelAndView modelAndView = new ModelAndView("/updateCity");

        modelAndView.addObject("listCity", cityRepository.findAllByNameRu(nameRu));
        modelAndView.addObject("nameRu", nameRu);
        modelAndView.addObject("nameEn", cityRepository.getCityEnByCityRu(nameRu));
        modelAndView.addObject("info", cityRepository.getInfoByCity(nameRu));

        return modelAndView;
    }

    @PostMapping(value = "update" + "/{nameRu}")
    public ModelAndView updateCityPage(@PathVariable(name = "nameRu") String nameRu,
                                       @RequestParam(value = "nameEn", required = false) String nameEn,
                                       @RequestParam(value = "info", required = false) String info) {
        ModelAndView modelAndView = new ModelAndView("/updateCity");

        cityRepository.setNewData(nameRu, nameEn, info);
        modelAndView.setViewName("redirect:/table");
        return modelAndView;
    }

    @GetMapping(value = "delete" + "/{nameRu}")
    public ModelAndView deleteCity(@PathVariable(name = "nameRu") String nameRu) {
        ModelAndView modelAndView = new ModelAndView("/deleteCity");

        modelAndView.addObject("listCity", cityRepository.findAllByNameRu(nameRu));
        modelAndView.addObject("nameRu", nameRu);
        modelAndView.addObject("nameEn", cityRepository.getCityEnByCityRu(nameRu));
        modelAndView.addObject("info", cityRepository.getInfoByCity(nameRu));

        return modelAndView;
    }

    @PostMapping(value = "delete" + "/{nameRu}")
    public ModelAndView deleteCityPage(@PathVariable(name = "nameRu") String nameRu) {
        ModelAndView modelAndView = new ModelAndView("/deleteCity");
        cityRepository.deleteCityByCityRu(nameRu);
        modelAndView.setViewName("redirect:/table");
        return modelAndView;
    }

}
