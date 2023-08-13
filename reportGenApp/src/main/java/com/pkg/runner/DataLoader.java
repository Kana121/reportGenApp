package com.pkg.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.pkg.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*
		//Cash Plan data;
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("sita");
		c1.setGender("Fe-Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmt(5000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Aakash");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("denied");
		c2.setDenialReason("Rental Income");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Aakash");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmt(5000.00);
		c3.setTerminetedDate(LocalDate.now());
		c3.setTerminationRsn("Employeed");

		//Food Plan data;
				CitizenPlan c4 = new CitizenPlan();
				c4.setCitizenName("Ram");
				c4.setGender("Male");
				c4.setPlanName("Food");
				c4.setPlanStatus("Approved");
				c4.setPlanStartDate(LocalDate.now());
				c4.setPlanEndDate(LocalDate.now().plusMonths(6));
				c4.setBenifitAmt(6000.00);

				CitizenPlan c5 = new CitizenPlan();
				c5.setCitizenName("Smith");
				c5.setGender("Male");
				c5.setPlanName("Food");
				c5.setPlanStatus("denied");
				c5.setDenialReason("Property Income");

				CitizenPlan c6 = new CitizenPlan();
				c6.setCitizenName("Orline");
				c6.setGender("Fe-Male");
				c6.setPlanName("Food");
				c6.setPlanStatus("Terminated");
				c6.setPlanStartDate(LocalDate.now().minusMonths(4));
				c6.setPlanEndDate(LocalDate.now().plusMonths(6));
				c6.setBenifitAmt(5000.00);
				c6.setTerminetedDate(LocalDate.now());
				c6.setTerminationRsn("Employeed");

				//Medical Plan data;
				CitizenPlan c7 = new CitizenPlan();
				c7.setCitizenName("Devid");
				c7.setGender("Male");
				c7.setPlanName("Medical");
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenifitAmt(6000.00);

				CitizenPlan c8 = new CitizenPlan();
				c8.setCitizenName("shruti");
				c8.setGender("Fe-Male");
				c8.setPlanName("Medical");
				c8.setPlanStatus("denied");
				c8.setDenialReason("Property Income");

				CitizenPlan c9 = new CitizenPlan();
				c9.setCitizenName("Rathod");
				c9.setGender("Male");
				c9.setPlanName("Medical");
				c9.setPlanStatus("Terminated");
				c9.setPlanStartDate(LocalDate.now().minusMonths(4));
				c9.setPlanEndDate(LocalDate.now().plusMonths(6));
				c9.setBenifitAmt(5000.00);
				c9.setTerminetedDate(LocalDate.now());
				c9.setTerminationRsn("Gov. job");

				//Employment Plan data;
				CitizenPlan c10 = new CitizenPlan();
				c10.setCitizenName("Ajay");
				c10.setGender("Male");
				c10.setPlanName("Employment");
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenifitAmt(6000.00);

				CitizenPlan c11 = new CitizenPlan();
				c11.setCitizenName("Rani");
				c11.setGender("Fe-Male");
				c11.setPlanName("Employment");
				c11.setPlanStatus("denied");
				c11.setDenialReason("Property Income");

				CitizenPlan c12 = new CitizenPlan();
				c12.setCitizenName("Rohit");
				c12.setGender("Male");
				c12.setPlanName("Employment");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(4));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenifitAmt(5000.00);
				c12.setTerminetedDate(LocalDate.now());
				c12.setTerminationRsn("Gov. job");

				List<CitizenPlan>list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
				repo.saveAll(list);
				*/
	}

}
