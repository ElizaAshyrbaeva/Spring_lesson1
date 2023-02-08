package peaksoft;

import org.postgresql.copy.CopyOut;
import peaksoft.config.HibernateConfig;
import peaksoft.enams.Status;
import peaksoft.model.Address;
import peaksoft.model.Country;
import peaksoft.model.Programmer;
import peaksoft.model.Project;
import peaksoft.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AddressService addressService = new AddressServiceImpl();
        CountryService countryService = new CountryServiceImpl();
        ProgrammerService programmerService = new ProgrammerServiceImpl();
        ProjectService projectService = new ProjectServiceImpl();
        Address address1 = new Address("Bishkek", "Lev Tolstoi", "61D");
        Address address2 = new Address("Osh", "Osmonov", "23A");
        List<Address> addresses = new ArrayList<>(List.of(address1, address2));
        Country country1 = new Country("Country", peaksoft.enams.Country.USA);
        Country country2 = new Country("country1", peaksoft.enams.Country.KYRGYZSTAN);
        List<Country> countries = List.of(country2, country1);

        Programmer programmer1 = new Programmer("Eliza ", "Ashyrbaeva", LocalDate.of(2004, 1, 30), Status.COLLABORATOR);
        Programmer programmer2 = new Programmer("Nuriza ", "Muratova", LocalDate.of(2004, 2, 5), Status.CONTRIBUTE);
        Programmer programmer3 = new Programmer("Zhiydegul ", "Jalilova", LocalDate.of(1993, 1, 17), Status.OWNER);
        List<Programmer> programmers = List.of(programmer1, programmer2, programmer3);
        Project project1 = new Project("Peaksoft", "IdCompany", LocalDate.of(2022, 01, 01), LocalDate.of(2022, 7, 12), 600000);
        Project project2 = new Project("Taxi", "Project", LocalDate.of(2020, 5, 15), LocalDate.of(2022, 12, 30), 4000000);
        List<Project> projects = List.of(project1, project2);
        while (true) {
            System.out.println("""
                    >>>>>>>>>>ADDRESS<<<<<<<<<<
                    1.Save Address->
                    2.Save All Address->
                    3.Get All->
                    4.Find By Id->
                    5.Delete All->
                    6.Update Address->
                                         
                    *****************************
                                         
                    >>>>>>>>>>COUNTRY<<<<<<<<<
                    7. Save Country->
                    8. Save All Countries->
                    9. Get All->
                    10.Find By Id->
                    11. Delete By Id->
                    12.Delete All->
                    13.Update->
                    14.Get Long Description->
                    15.Find By Name->
                    16.Count The Country->
                                         
                    ******************************
                                         
                    >>>>>>>>>>Programmer<<<<<<<<<<
                    17.Add Constraint Unique->
                    18.Save ->
                    19.Save All->
                    20.Get All()->
                    21.Find By Id->
                    22.Delete By Id->
                    23.Delete All->
                    24.Update->
                    25.Find By Country Name->
                    26.Find Youngest->
                    27.Find Eldest();
                                         
                    ******************************
                                         
                    >>>>>>>>>>>Project<<<<<<<<<<<<
                    28.Save->
                    29.Save All->
                    30.Find By Id->
                    31.Delete By Id->
                    32.Delete All->
                    33.Update->
                    34.Assign->
                    35.Find Expensive->
                    36.Find Short Time Project->
                    """);
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> addressService.saveAddress(address1, new Scanner(System.in).nextLong());
                case 2 -> addressService.saveAddresses(addresses, 2L);
                case 3 -> System.out.println(addressService.getAllAddresses());
                case 4 -> System.out.println(addressService.findById(new Scanner(System.in).nextLong()));
                case 5 -> System.out.println(addressService.removeAllAddresses());
                case 6 -> System.out.println(addressService.updateAddress(1L, address1));
                case 7 -> System.out.println(countryService.saveCountry(country1));
                case 8 -> System.out.println(countryService.saveCountries(countries));
                case 9 -> System.out.println(countryService.getAllCountries());
                case 10 -> countryService.findCountryById(new Scanner(System.in).nextLong());
                case 11 -> countryService.deleteCountryById(new Scanner(System.in).nextLong());
                case 12 -> System.out.println(countryService.removeAllCountries());
                case 13 -> System.out.println(countryService.findTheLongestDescription());
                case 14 -> System.out.println(countryService.updateCountry(1L, country2));
                case 16 -> System.out.println(countryService.CountProgrammerInSameCountry(new Scanner(System.in).nextLine()));
                case 17 -> programmerService.addConstraintToEmail();
                case 18 -> System.out.println(programmerService.saveProgrammer(programmer1, 1L));
                case 19 -> System.out.println(programmerService.saveProgrammers(programmers, new Scanner(System.in).nextLong()));
                case 20 -> System.out.println(programmerService.getAllProgrammers());
                case 21 -> System.out.println(programmerService.findById(new Scanner(System.in).nextLong()));
                case 22 -> System.out.println(programmerService.deleteById(new Scanner(System.in).nextLong()));
                case 23 -> System.out.println(programmerService.deleteAllProgrammers());
                case 24 ->
                        System.out.println(programmerService.updateProgrammer(new Scanner(System.in).nextLong(), programmer1));
                case 25 -> System.out.println(programmerService.findTheYoungestProgrammer());
                case 26 -> System.out.println(programmerService.findTheOldestProgrammer());
                case 27 -> System.out.println(programmerService.findTheOldestProgrammer());
                case 29 -> System.out.println(projectService.saveProject(project1));
                case 30 -> System.out.println(projectService.saveProjects(projects));
                case 31 -> System.out.println(projectService.findById(new Scanner(System.in).nextLong()));
                case 32 -> System.out.println(projectService.removeAllProjects());
                case 33 -> System.out.println(projectService.updateProject(new Scanner(System.in).nextLong(), project1));
                case 34 ->
                        System.out.println(projectService.assignProgrammerToProject(new Scanner(System.in).nextLong(), new Scanner(System.in).nextLong()));
                case 35 -> System.out.println(projectService.findTheBestExpensiveProject());
                case 36 -> System.out.println(projectService.findTheBestExpensiveProject());
            }
        }

    }
}
