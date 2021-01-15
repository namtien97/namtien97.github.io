package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.IPersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonRepositoryCSVTest {
    @Autowired
    IPersonRepository personRepository;

    @Test
    public void getAll() {
        List<Person> people = personRepository.getAll();
        people.forEach(System.out::println);
        assertThat(people).hasSize(20);
    }

    @Test
    public void getSortedCities() {
        List<String> sortedCities = personRepository.getSortedCities();
        sortedCities.forEach(System.out::println);
        assertThat(sortedCities).isSortedAccordingTo(Comparator.naturalOrder()).contains("Berlin", "Budapest", "Hanoi");
    }

    @Test
    public void getSortedJobs() {
        List<String> sortedJobs = personRepository.getSortedJobs();
        sortedJobs.forEach(System.out::println);

        assertThat(sortedJobs).isSortedAccordingTo(Comparator.naturalOrder())
                .contains("Pole Dancer", "Bartender", "Developer");
    }

    @Test
    public void sortPeopleByFullNameReversed() {
        List<Person> sortedPeople = personRepository.sortPeopleByFullNameReversed();
        sortedPeople.forEach(person -> System.out.println(person.getFullname()));
        assertThat(sortedPeople).isSortedAccordingTo(Comparator.comparing(Person::getFullname).reversed());
    }

    @Test
    public void groupPeopleByCityTest() {
        Map<String, List<Person>> groupByCity = personRepository.groupPeopleByCity();
        groupByCity.forEach((k, v) -> System.out.println("City: " + k + " - " + v));
    }

    @Test
    public void groupJobByCountTest() {
        Map<String, Long> countJob = personRepository.groupJobByCount();
        countJob.forEach((k, v) -> System.out.println("job: " + k + " - " + v));
    }

    @Test
    public void findTop5JobsTest() {
        Map<String, Long> top5Jobs = personRepository.findTop5Jobs();
        top5Jobs.forEach((k, v) -> System.out.println("job: " + k + " - " + v));
    }

    @Test
    public void findTop5CitisTest() {
        Map<String, Long> top5Citis = personRepository.findTop5Citis();
        top5Citis.forEach((k, v) -> System.out.println("city: " + k + " - " + v));
    }

    @Test
    public void findTopJobInCityTest() {
        Map<String, String> topJobInCity = personRepository.findTopJobInCity();
        topJobInCity.forEach((k, v) -> System.out.println("City: " + k + " - Job: " + v));
    }

    @Test
    public void averageJobSalaryTest() {
        Map<String, Integer> averageJobSalary = personRepository.averageJobSalary();
        averageJobSalary.forEach((k, v) -> System.out.println("Job: " + k + " - Average Salary: " + v));
    }

    @Test
    public void averageJobAgeTest() {
        Map<String, Integer> averageJobAge = personRepository.averageJobAge();
        averageJobAge.forEach((k, v) -> System.out.println("Job: " + k + " - Average age: " + v));
    }

    @Test
    public void averageCityAgeTest() {
        Map<String, Integer> averageCityAge = personRepository.averageCityAge();
        averageCityAge.forEach((k, v) -> System.out.println("City: " + k + " - Average age: " + v));
    }

    @Test
    public void top5HighestSalaryCitiesTest() {
        Map<String, Long> top5HighestSalaryCities = personRepository.top5HighestSalaryCities();
        top5HighestSalaryCities.forEach((k, v) -> System.out.println("City: " + k + " - Average salary: " + v));
    }

    @Test
    public void find5CitiesHaveMostSpecificJobTest() {
        personRepository.find5CitiesHaveMostSpecificJob("doctor");
    }
}
