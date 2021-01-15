package com.example.demo.repository;

import com.example.demo.model.Person;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Repository
public class PersonRepositoryCSV implements IPersonRepository {
    private ArrayList<Person> people;

    @Autowired
    public PersonRepositoryCSV(@Value("${csvFile}") String csvFile) {
        people = new ArrayList<>();
        loadData(csvFile);
    }

    private void loadData(String csvFile) {
        try {
            File file = ResourceUtils.getFile("classpath:static/" + csvFile);
            CsvMapper mapper = new CsvMapper(); // Dùng để ánh xạ cột trong CSV với từng trường trong POJO
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // Dòng đầu tiên sử dụng làm Header
            ObjectReader oReader = mapper.readerFor(Person.class).with(schema); // Cấu hình bộ đọc CSV phù hợp với kiểu
            Reader reader = new FileReader(file);
            MappingIterator<Person> mi = oReader.readValues(reader); // Iterator đọc từng dòng trong file
            while (mi.hasNext()) {
                Person person = mi.next();
                people.add(person);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return people.stream().sorted(comparing(Person::getFullname).reversed()).collect(toList());
    }

    @Override
    public List<String> getSortedJobs() {
        return people.stream().map(Person::getJob).sorted().collect(toList());
    }

    @Override
    public List<String> getSortedCities() {
        return people.stream().map(Person::getCity).sorted().collect(toList());
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {

        Map<String, List<Person>> result = people.stream().collect(Collectors.groupingBy(w -> w.getCity()));
        return result;
    }

    @Override
    public Map<String, Long> groupJobByCount() {
        Map<String, Long> result = people.stream().collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
        return result;
    }

    @Override
    public Map<String, Long> findTop5Jobs() {
        //dem
        Map<String, Long> count = people.stream().collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
        Map<String, Long> result = getTop5(count);
        return result;
    }

    @Override
    public Map<String, Long> findTop5Citis() {
        //dem
        Map<String, Long> count = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        Map<String, Long> result = getTop5(count);
        return result;
    }

    @Override
    public Map<String, String> findTopJobInCity() {
        Map<String, Map<String, List<Person>>> map = people.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.groupingBy(Person::getJob)));
        Map<String, String> result = new HashMap<>();
        Set<String> setCity = map.keySet();
        for (String keyCity : setCity) {
            Set<String> setJob = map.get(keyCity).keySet();
            String maxKey = null;
            int maxSize = 0;
            for (String keyJob : setJob) {
                if (map.get(keyCity).get(keyJob).size() > maxSize) {
                    maxSize = map.get(keyCity).get(keyJob).size();
                    maxKey = String.valueOf(keyJob);
                }
            }
            result.put(keyCity, maxKey);
        }
        return result;
    }

    @Override
    public Map<String, Integer> averageJobSalary() {
        //Group salary and job
        Map<String, List<Integer>> salaryAndJob = new HashMap<>();
        for (Person person : people) {
            String job = person.getJob();
            if (salaryAndJob.containsKey(job)) {
                salaryAndJob.get(job).add(person.getSalary());
            } else {
                List<Integer> salaries = new ArrayList<>();
                salaries.add(person.getSalary());
                salaryAndJob.put(job, salaries);
            }
        }

        //Calculate salary each job
        Map<String, Integer> results = calcAverageAndPutMap(salaryAndJob);
        return results;
    }

    @Override
    public Map<String, Long> top5HighestSalaryCities() {
        //group city and salary
        Map<String, List<Integer>> cityAndSalary = new HashMap<>();
        for (Person person : people) {
            String city = person.getCity();
            if (cityAndSalary.containsKey(city)) {
                cityAndSalary.get(city).add(person.getSalary());
            } else {
                List<Integer> salaries = new ArrayList<>();
                salaries.add(person.getSalary());
                cityAndSalary.put(city, salaries);
            }
        }
        Map<String, Integer> resultMapAverage = calcAverageAndPutMap(cityAndSalary);

        //change type long to int

        Map<String, Long> resultTemp = new HashMap<>();
        for (Map.Entry<String, Integer> item : resultMapAverage.entrySet()
        ) {
            resultTemp.put(item.getKey(), Long.valueOf(item.getValue()));
        }

        Map<String, Long> result = getTop5(resultTemp);
        return result;
    }

    @Override
    public Map<String, Integer> averageJobAge() {
        //group job and age
        Map<String, List<Integer>> jobAndAge = new HashMap<>();
        for (Person person : people) {
            String job = person.getJob();
            groupTwoCol(jobAndAge, person, job);
        }

        //Calculate salary each job
        Map<String, Integer> results = calcAverageAndPutMap(jobAndAge);
        return results;
    }

    @Override
    public Map<String, Integer> averageCityAge() {
        //group city and age
        Map<String, List<Integer>> cityAndAge = new HashMap<>();
        for (Person person : people) {
            String city = person.getCity();
            groupTwoCol(cityAndAge, person, city);
        }

        //Calculate age each city
        HashMap<String, Integer> results = calcAverageAndPutMap(cityAndAge);
        return results;
    }

    private void groupTwoCol(Map<String, List<Integer>> cityAndAge, Person person, String city) {
        Date birthday = person.getBirthday();
        int age = getAge(birthday);
        if (cityAndAge.containsKey(city)) {
            cityAndAge.get(city).add(age);
        } else {
            List<Integer> ageList = new ArrayList<>();
            ageList.add(age);
            cityAndAge.put(city, ageList);
        }
    }

    @Override
    public List<String> find5CitiesHaveMostSpecificJob(String job) {
        return null;
    }

    private Integer calcAverage(List<Integer> values) {
        Integer result = 0;
        for (Integer value : values
        ) {
            result += value;
        }
        return result / values.size();
    }

    private int getAge(Date birthday) {
        Date now = new Date();
        long timeBetween = now.getTime() - birthday.getTime();
        double yearsBetween = timeBetween / 3.15576e+10;
        int age = (int) Math.floor(yearsBetween);
        return age;
    }

    private HashMap<String, Integer> calcAverageAndPutMap(Map<String, List<Integer>> mapInput) {
        HashMap<String, Integer> results = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : mapInput.entrySet()) {
            Integer average = calcAverage(entry.getValue());
            results.put(entry.getKey(), average);
        }
        return results;
    }

    private Map<String, Long> getTop5(Map<String, Long> count) {
        //sap xep
        Map<String, Long> arrangement = count.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> (int) (o2 - o1)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        //lay 5 phan tu
        int temp = 0;
        Map<String, Long> resultTemp = new HashMap<>();
        Set<String> keySet = arrangement.keySet();
        for (String key : keySet) {
            resultTemp.put(key, arrangement.get(key));
            temp++;
            if (temp == 5) {
                break;
            }
        }
        Map<String, Long> result = resultTemp.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> (int) (o2 - o1)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }

    private Map<String, List<Integer>> groupTowCol() {
        Map<String, List<Integer>> resultMap = new HashMap<>();
        for (Person person : people) {
            String job = person.getJob();
            if (resultMap.containsKey(job)) {
                resultMap.get(job).add(person.getSalary());
            } else {
                List<Integer> salaries = new ArrayList<>();
                salaries.add(person.getSalary());
                resultMap.put(job, salaries);
            }
        }
        return resultMap;
    }
}
