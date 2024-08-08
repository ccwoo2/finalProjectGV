package com.humber.finalProjGV;

import com.humber.finalProjGV.models.Haircut;
import com.humber.finalProjGV.services.HaircutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjGvApplication implements CommandLineRunner {

	private final HaircutService haircutService;

	public FinalProjGvApplication(HaircutService haircutService) {
		this.haircutService = haircutService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjGvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("helloooooo");

		//for testing table data
		haircutService.addHaircut(new Haircut(1, "topper", "makes u fly", 30.0));

	}
}
