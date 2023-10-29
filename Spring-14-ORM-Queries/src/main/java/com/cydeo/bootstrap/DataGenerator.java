package com.cydeo.bootstrap;

import com.cydeo.entity.Region;
import com.cydeo.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------------- Region -------------------");
        List<Region> regionList = regionRepository.findByCountry("Canada");
        regionList.forEach(System.out::println);


        List<Region> regionList1 = regionRepository.findDistinctByCountry("Canada");
        regionList1.forEach(System.out::println);


        System.out.println("\n--------------- Region - containing-------------------");
        List<Region> united = regionRepository.findByCountryContaining("United");
        united.forEach(System.out::println);


        System.out.println("\n--------------- Region - OrderBy-------------------");
        List<Region> orderByCountry = regionRepository.findByCountryContainingOrderByCountry("Asia");
        orderByCountry.forEach(System.out::println);


        System.out.println("\n--------------- Region  - TopBy-------------------");
        List<Region> topByCountry = regionRepository.findTop2ByCountry("Canada");
        topByCountry.forEach(System.out::println);

    }


}
